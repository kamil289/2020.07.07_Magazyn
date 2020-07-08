package pl.camp.it.db;

import jdk.jfr.Category;
import pl.camp.it.model.Categorie;

import java.util.List;
import java.util.Locale;

public class CategoryReposytory {
    private List<Categorie> categories = SQLdb.getAllCategory();

    private static final CategoryReposytory categoryReposytory = new CategoryReposytory();

    public List<Categorie> getCategories() {
        return categories;
    }

    public static CategoryReposytory getCategoryReposytory() {
        return categoryReposytory;
    }
}