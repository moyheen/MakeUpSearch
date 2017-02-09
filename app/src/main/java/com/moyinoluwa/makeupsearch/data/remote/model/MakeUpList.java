package com.moyinoluwa.makeupsearch.data.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by moyinoluwa on 2/9/17.
 */

public class MakeUpList {

    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("brand")
    @Expose
    public String brand;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("price")
    @Expose
    public String price;
    @SerializedName("image_link")
    @Expose
    public String imageLink;
    @SerializedName("product_link")
    @Expose
    public String productLink;
    @SerializedName("website_link")
    @Expose
    public String websiteLink;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("rating")
    @Expose
    public Object rating;
    @SerializedName("category")
    @Expose
    public String category;
    @SerializedName("product_type")
    @Expose
    public String productType;
    @SerializedName("tag_list")
    @Expose
    public List<Object> tagList = null;
    @SerializedName("created_at")
    @Expose
    public String createdAt;
    @SerializedName("updated_at")
    @Expose
    public String updatedAt;
    @SerializedName("product_api_url")
    @Expose
    public String productApiUrl;
    @SerializedName("product_colors")
    @Expose
    public List<Object> productColors = null;

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImageLink() {
        return imageLink;
    }

    public String getProductLink() {
        return productLink;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public String getDescription() {
        return description;
    }

    public Object getRating() {
        return rating;
    }

    public String getCategory() {
        return category;
    }

    public String getProductType() {
        return productType;
    }

    public List<Object> getTagList() {
        return tagList;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getProductApiUrl() {
        return productApiUrl;
    }

    public List<Object> getProductColors() {
        return productColors;
    }

    public MakeUpList(Integer id, String brand, String name, String price, String imageLink,
                      String productLink, String websiteLink, String description, Object rating,
                      String category, String productType, List<Object> tagList, String
                              createdAt, String updatedAt, String productApiUrl, List<Object>
                              productColors) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.imageLink = imageLink;
        this.productLink = productLink;
        this.websiteLink = websiteLink;
        this.description = description;
        this.rating = rating;
        this.category = category;
        this.productType = productType;
        this.tagList = tagList;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.productApiUrl = productApiUrl;
        this.productColors = productColors;
    }
}
