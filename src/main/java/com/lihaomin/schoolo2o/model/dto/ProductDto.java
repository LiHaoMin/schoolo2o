package com.lihaomin.schoolo2o.model.dto;

import com.lihaomin.schoolo2o.model.Product;
import com.lihaomin.schoolo2o.model.ProductImage;
import com.lihaomin.schoolo2o.model.Shop;

import java.util.List;

public class ProductDto extends Product{
    private Shop shop;
    private List<ProductImage> productImages;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }
}
