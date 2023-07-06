package com.example.catalogservice.entity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
    //    List<Catalog> findByProductId(String productId);
    Catalog findByProductId(String productId);
}
