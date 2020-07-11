package pl.camp.it.db;

import pl.camp.it.model.Categorie;
import pl.camp.it.model.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLdb {

    public static final Connection connection = connect();


    private static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Magazyn?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8", "root", "");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Brak połączenia z bazą !!");
        return null;
    }

    public static void saveProduct(Products products) {
        try {
            Statement statement = connection.createStatement();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO Magazyn1, (kategoria, nazwaProduktu, iloscSztuk, kodKreskowy)")
                    .append(" values ('")
                    .append(products.getKategoria())
                    .append("', '")
                    .append(products.getNazwaProduktu())
                    .append("', '")
                    .append(products.getIloscSztuk())
                    .append("', ")
                    .append(products.getKodKreskowy());

            if (products.getKategoria()==null) {
                sql.append("INSERT INTO MagazynBrakKategorii, (kategoria, nazwaProduktu, iloscSztuk, kodKreskowy)")
                        .append(" values ('")
                        .append(products.getKategoria())
                        .append("', '")
                        .append(products.getNazwaProduktu())
                        .append("', '")
                        .append(products.getIloscSztuk())
                        .append("', ")
                        .append(products.getKodKreskowy());

            } else {
                sql.append(", ")
                        .append("NULL")
                        .append(", ")
                        .append("NULL");
            }

            sql.append(")");

            statement.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }public static void saveCategory(Categorie categorie) {
        try {
            Statement statement = connection.createStatement();

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO Categorie (kategoria)")
                    .append(" values ('")
                    .append(categorie.getKategoria());


            sql.append(")");

            statement.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Products> getAllProducts() {
        List<Products> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet wyniki = statement
                    .executeQuery("SELECT * FROM Magazyn1, MagazynBrakKategorii");

            while (wyniki.next()) {
                int id = wyniki.getInt("id");
                String kategoria = wyniki.getString("kategoria");
                String nazwaProduktu = wyniki.getString("nazwaProduktu");
                Integer iloscSztuk = wyniki.getInt("iloscSztuk");
                Integer kodKreskowy = wyniki.getInt("kodKreskowy");


                resultList.add(new Products(id, kategoria, nazwaProduktu, iloscSztuk, kodKreskowy));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }
    public static List<Products> getAllProductsfromCategory(String taKategoria) {
        List<Products> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet wyniki = statement
                    .executeQuery("SELECT * FROM Magazyn1, MagazynBrakKategorii WHERE category = '" + taKategoria + "'");

            while (wyniki.next()) {
                int id = wyniki.getInt("id");
                String kategoria = wyniki.getString("kategoria");
                String nazwaProduktu = wyniki.getString("nazwaProduktu");
                Integer iloscSztuk = wyniki.getInt("iloscSztuk");
                Integer kodKreskowy = wyniki.getInt("kodKreskowy");


                resultList.add(new Products(id, kategoria, nazwaProduktu, iloscSztuk, kodKreskowy));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }


    public static List<Categorie> getAllCategory() {
        List<Categorie> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet wyniki = statement
                    .executeQuery("SELECT * FROM Categorie");

            while (wyniki.next()) {
                int id = wyniki.getInt("id");
                String kategoria = wyniki.getString("kategoria");


                resultList.add(new Categorie(id, kategoria));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;

    }





}
