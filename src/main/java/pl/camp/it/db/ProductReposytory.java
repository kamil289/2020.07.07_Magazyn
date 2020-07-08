package pl.camp.it.db;

import pl.camp.it.model.Products;

import java.util.List;

public class ProductReposytory {


        private List<Products> products = SQLdb.getAllProducts();

        private static final ProductReposytory productReposytory = new ProductReposytory();

    public List<Products> getProducts() {
        return products;
    }


    public static ProductReposytory getProductReposytory() {
        return productReposytory;
    }


}
