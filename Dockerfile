# Stage 1: Build the application using Maven
FROM bellsoft/liberica-openjdk-debian:25 AS maven-builder
WORKDIR /workspace

# Copy the Maven wrapper and configuration files first to cache dependencies
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (this layer will be cached unless pom.xml changes)
RUN ./mvnw dependency:go-offline

# Copy the source code and build the application
COPY src src
RUN ./mvnw clean package -DskipTests

# Stage 2: Extract the layers (Builder)
FROM bellsoft/liberica-openjre-debian:25-cds AS builder
WORKDIR /builder

# Copy the built jar file from the maven-builder stage
COPY --from=maven-builder /workspace/target/*.jar application.jar

# Extract the jar file using an efficient layout
RUN java -Djarmode=tools -jar application.jar extract --layers --destination extracted

# Stage 3: Runtime container
FROM bellsoft/liberica-openjre-debian:25-cds
WORKDIR /application

# Copy the extracted jar contents from the builder container into the working directory in the runtime container
# Every copy step creates a new docker layer
# This allows docker to only pull the changes it really needs
COPY --from=builder /builder/extracted/dependencies/ ./
COPY --from=builder /builder/extracted/spring-boot-loader/ ./
COPY --from=builder /builder/extracted/snapshot-dependencies/ ./
COPY --from=builder /builder/extracted/application/ ./
# Start the application jar - this is not the uber jar used by the builder
# This jar only contains application code and references to the extracted jar files
# This layout is efficient to start up and AOT cache (and CDS) friendly
ENTRYPOINT ["java", "-jar", "application.jar"]