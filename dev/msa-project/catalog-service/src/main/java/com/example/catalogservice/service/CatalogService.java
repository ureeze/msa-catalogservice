package com.example.catalogservice.service;

import com.example.catalogservice.dto.CatalogDto;
import com.example.catalogservice.entity.Catalog;

import java.util.List;

public interface CatalogService {
    List<CatalogDto> getAllCatalogs();
}
