package pl.camp.it.db;

import pl.camp.it.model.Categorie;

import java.util.List;


public class CategoryReposytory {
    private static List<Categorie> categories;
    private static final CategoryReposytory categoryReposytory = new CategoryReposytory();

    public List<Categorie> getCategories() {

        return this.categories;
    }

    public static CategoryReposytory getCategoryReposytory() {
        categories = SQLdb2.getAllCategorie();
        return categoryReposytory;
    }

}