package com.kitady.gke.spring.jpa;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import com.google.cloud.spring.data.spanner.core.mapping.Column;
import com.google.cloud.spring.data.spanner.core.mapping.PrimaryKey;
import com.google.cloud.spring.data.spanner.core.mapping.Table;
import lombok.Data;

/**
 * ITEM Entity
 */
@Data
@Table(name = "ITEM")
public class Item {

  /** PK */
  /** UUID(UUID) */
  @PrimaryKey
  @Column(name = "UUID")
  private String uuid;

  /** NAME(NAME) */
  @Column(name = "NAME")
  private String name;

  /** JP NAME(NAMEJP) */
  @Column(name = "NAMEJP")
  private String namejp;

  /** TYPE(TYPE) */
  @Column(name = "TYPE")
  private String type;

  /** DIV(DIV) */
  @Column(name = "DIV")
  private String div;

  /** ITEMNO(ITEMNO) */
  @Column(name = "ITEMNO")
  private Long itemno;

  /** PRICE(PRICE) */
  @Column(name = "PRICE")
  private BigDecimal price;

  /** EXPLANATION(EXPLANATION) */
  @Column(name = "EXPLANATION")
  private String explanation;

  /** REG_DATE(REGDATE) */
  @Column(name = "REGDATE")
  private Date regdate;

  /** TIME_ZONE(TIMEZONE) */
  @Column(name = "TIMEZONE")
  private String timezone;

  /** TIME_STMP(TIMESTMP) */
  @Column(name = "TIMESTMP")
  private Timestamp timestmp;

  /** VERSION(VERSION) */
  @Column(name = "VERSION")
  private Timestamp version;

}
