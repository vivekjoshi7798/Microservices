package io.levelup.movie_catlog_service.service;

import io.levelup.movie_catlog_service.dao.CatalogItemDao;
import io.levelup.movie_catlog_service.models.CatalogItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CatalogItemServiceImpl implements CatalogItemService{

    @Autowired
    private CatalogItemDao catalogItemDao;


    @Override
    public List<CatalogItem> getAllCatalogItem() {
       return catalogItemDao.findAll();
    }

    @Override
    public CatalogItem getAllCatalogItemById(int empID) {
       Optional<CatalogItem> catalogItem=catalogItemDao.findById(empID);
       return catalogItem.orElse(null);
    }

    @Override
    public void addCatalogItem(CatalogItem catalogItem) {
        catalogItemDao.save(catalogItem);
    }
}
