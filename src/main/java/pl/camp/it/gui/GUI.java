package pl.camp.it.gui;


import pl.camp.it.db.CategoryReposytory;
import pl.camp.it.db.ProductReposytory;
import pl.camp.it.db.SQLdb2;
import pl.camp.it.model.Categorie;
import pl.camp.it.model.Products;

import java.util.Scanner;

public class GUI {

    private static final Scanner scanner = new Scanner(System.in);

    public GUI() {
    }


    public static void showMainMenu() {
        System.out.println("1. Kategorie Produktów");
        System.out.println("2. Stock Produkty");
        System.out.println("3. Exit");

        String choose = scanner.nextLine();

        switch (choose) {
            case "1":
                showKategorieProduktow();
                break;
            case "2":
                showStockProduktow();
                break;
            case "3":

                SQLdb2.closeConnection();
                System.exit(0);
            default:
                System.out.println("Nieprawidłowy wybór !!");
                showMainMenu();
                break;
        }
    }
    public static void showKategorieProduktow() {
        System.out.println("1. Wpisz Kategorie");
        System.out.println("2. Wpisz Wybrana Kategorie");
        System.out.println("3. Dodaj Kategorie");
        System.out.println("4. Usuń Kategorie");
        System.out.println("5. Powrót");

        String choose = scanner.nextLine();

        switch (choose) {
            case "1":
                showCategory();
                break;
            case "2":
                showProductsByCategory();
                break;
            case "3":
                addCategoryUpgrade();
                break;
            case "4":
                //Brak metody;
                break;
            case "5":
                showMainMenu();
                break;
            default:
                System.out.println("Nieprawidłowy wybór !!");
                showMainMenu();
                break;
        }
    }

    public static void showStockProduktow() {
        System.out.println("1. Wypisz Produkt z Kategori");
        System.out.println("2. Wypisz Wszystkie Produkty");
        System.out.println("3. Dodaj Produkt");
        System.out.println("4. Powrót");

        String choose = scanner.nextLine();

        switch (choose) {
            case "1":
                showProductsByCategory();
                break;
            case "2":
                showProducts();
                break;
            case "3":
                addProductUpgrade();
                break;
            case "4":
                showMainMenu();
                break;
            default:
                System.out.println("Nieprawidłowy wybór !!");
                showMainMenu();
                break;
        }
    }
    private static void showCategory(){
        for(Categorie tempCategorie : CategoryReposytory.getCategoryReposytory().getCategories()){
            System.out.println(tempCategorie);
        }
        showMainMenu();
    }
    private static void showProducts(){
        for(Products tempProducts : ProductReposytory.getProductReposytory().getProducts()){
            System.out.println(tempProducts);
        }
        showMainMenu();
    }
    private static void addProductUpgrade() {
        System.out.println("Wpisz nazwę Kategorie:");
        String kategoria = scanner.nextLine();
        System.out.println("Wpisz Nazwe Produktu:");
        String nazwaProduktu = scanner.nextLine();
        System.out.println("Wpisz Ilosc Sztuk:");
        int iloscSztuk = Integer.parseInt(scanner.nextLine());
        System.out.println("Wpisz Kod kreskowy:");
        int kodKreskowy = Integer.parseInt(scanner.nextLine());

        SQLdb2.addProduct(kategoria,nazwaProduktu,iloscSztuk,kodKreskowy);
        System.out.println("Dodano nowy produkt");
        showMainMenu();
    }
    private static void showProductsByCategory() {
        System.out.println("Wpisz kategorię:");
        String kategoria = scanner.nextLine();
        for (Products tempProduct : ProductReposytory.getProductRepositoryByCategory(kategoria).getProducts()){
            System.out.println(tempProduct);
        }
        showMainMenu();
    }
    private static void addCategoryUpgrade(){
        System.out.println("Wpisz nazwę Kategorie:");
        String kategoria = scanner.nextLine();

        SQLdb2.addCategory(kategoria);
        System.out.println("Dodano nową kategorie");
        showMainMenu();

    }
    /*private static void deleteCategory() {
        System.out.println("Wpisz kategorię:");
        String category = scanner.nextLine();
        if (category.equals("Brak kategorii")) {
            System.out.println("Nie można usunąć tej kategorii");
            deleteCategory();
        }
        SQLDb.updateProduct(category);
        SQLDb.updateCategory(category);
        System.out.println("Kategoria została usunięta");
        showMainMenu();
    }

    private static void delateCategory(){
        System.out.println("Wpisz Kategorie");
        String kategoria = scanner.nextLine();
        if (kategoria.equals("BrakKategorii" )){
            System.out.println("Nie usuniesz tego!!");
            deleteCategory();
        }
        SQLdb2
    }*/


}
