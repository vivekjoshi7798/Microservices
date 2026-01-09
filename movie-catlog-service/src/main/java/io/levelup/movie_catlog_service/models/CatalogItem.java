package io.levelup.movie_catlog_service.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CatalogItem {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private int rating;

    public CatalogItem() {
    }

    public CatalogItem(String name, String desc, int rating) {
        this.name = name;
        this.description = desc;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
