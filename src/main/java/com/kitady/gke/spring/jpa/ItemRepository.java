package com.kitady.gke.spring.jpa;

import com.google.cloud.spring.data.spanner.repository.SpannerRepository;

public interface ItemRepository extends SpannerRepository<Item, String> {

}
