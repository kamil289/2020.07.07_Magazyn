package pl.camp.it.gui;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.db.SQLdb;

import java.util.Scanner;

public class GUI {
    private static final Scanner scanner = new Scanner(System.in);

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

                SQLdb.closeConnection();
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
                SQLdb.getAllCategory();
                break;
            case "2":
                SQLdb.getAllProductsfromCategory();
                break;
            case "3":
                SQLdb.saveCategory();
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
                SQLdb.getAllProductsfromCategory();
                break;
            case "2":
                SQLdb.getAllProducts();
                break;
            case "3":
                SQLdb.saveProduct();
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


}
