package pl.camp.it.db;
import pl.camp.it.model.Products;

import java.util.List;

public class ProductReposytory {

    private static List<Products> products = SQLdb2.getAllProducts();
    private static final ProductReposytory productReposytory = new ProductReposytory();

    public List<Products> getProducts() {
        products = SQLdb2.getAllProducts();
        return products;
    }
    public static ProductReposytory getProductReposytory() {
        return productReposytory;
    }

    public static ProductReposytory getProductRepositoryByCategory(String kategoria) {
        products = SQLdb2.getProductsFromCategorie(kategoria);
        return productReposytory;
    }
}
