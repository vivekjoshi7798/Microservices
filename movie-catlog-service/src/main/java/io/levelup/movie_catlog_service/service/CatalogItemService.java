package io.levelup.movie_catlog_service.service;

import io.levelup.movie_catlog_service.models.CatalogItem;

import java.util.List;

public interface CatalogItemService {

    public List<CatalogItem> getAllCatalogItem();

    public CatalogItem getAllCatalogItemById(int emp_ID);

    public void addCatalogItem(CatalogItem catalogItem);

}
