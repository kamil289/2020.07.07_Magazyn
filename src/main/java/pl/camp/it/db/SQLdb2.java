package pl.camp.it.db;

import pl.camp.it.model.Categorie;
import pl.camp.it.model.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLdb2 {
    public static final Connection connection = connect();

    private static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Magazyn?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=utf8", "root", "");
            return con;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Brak połączenia z bazą !!");
        return null;
    }

    public static void addCategory(String kategoria) {
        try {
            String sql = "INSERT INTO Categorie (kategoria) VALUES (?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(2, kategoria);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addProduct(String kategoria, String nazwaProduktu, int iloscSztuk, int kodKreskowy) {

        try {
            String sql = "INSERT INTO Magazyn1 (kategoria, nazwaProduktu, iloscSztuk, kodKreskowy) VALUES (?, ?, ?, ?) ";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(2, kategoria);
            preparedStatement.setString(3, nazwaProduktu);
            preparedStatement.setInt(4, iloscSztuk);
            preparedStatement.setInt(5, kodKreskowy);



            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void addProductNullCategory(Products products) {

        try {
            String sql = "INSERT INTO MagazynBrakKategorii (nazwaProduktu, iloscSztuk, kodKreskowy) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            preparedStatement.setString(2, products.getNazwaProduktu());
            preparedStatement.setInt(3, products.getIloscSztuk());
            preparedStatement.setInt(4, products.getKodKreskowy());


            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static List<Products> getAllProducts() {
        List<Products> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet wyniki = statement.executeQuery("SELECT * FROM Magazyn1, MagazynBrakKategorii");

            while (wyniki.next()) {
                int id = wyniki.getInt("id");
                String kategorie = wyniki.getString("kategorie");
                String nazwaProduktu = wyniki.getString("nazwaProduktu");
                int iloscSztuk = wyniki.getInt("iloscSztuk");
                int kodKreskowy = wyniki.getInt("kodKreskowy");

                resultList.add(new Products(id, kategorie, nazwaProduktu, iloscSztuk, kodKreskowy));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultList;
    }
    public static List<Categorie> getAllCategorie() {
        List<Categorie> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet wyniki = statement.executeQuery("SELECT * FROM Categorie");

            while (wyniki.next()) {
                int id = wyniki.getInt("id");
                String kategorie = wyniki.getString("kategorie");


                resultList.add(new Categorie(id, kategorie));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultList;
    }
    public static List<Products> getProductsFromCategorie(String kategoria) {
        List<Products> resultList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            ResultSet wyniki = statement.executeQuery("SELECT * FROM Magazyn1, MagazynBrakKategorii " +
                    "WHERE category = '" + kategoria + "'" );

            while (wyniki.next()) {
                int id = wyniki.getInt("id");
                String kategorie = wyniki.getString("kategorie");
                String nazwaProduktu = wyniki.getString("nazwaProduktu");
                int iloscSztuk = wyniki.getInt("iloscSztuk");
                int kodKreskowy = wyniki.getInt("kodKreskowy");

                resultList.add(new Products(id, kategorie, nazwaProduktu, iloscSztuk, kodKreskowy));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultList;
    }
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public static void updateCatgorie(String kategoria){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Categorie SET kategorie = true WHERE name = '" + kategoria + "'");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void updateProducts(){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Magazyn1, MagazynBrakKategorii SET deleted = true WHERE name = '" + name + "'")

        }
    }
    public static void updateVehicleRent(Vehicle vehicle) {
        try {
            Statement statement = connection.createStatement();

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE tvehicle SET rent = ")
                    .append(vehicle.isRent())
                    .append(" WHERE id = ")
                    .append(vehicle.getId());

            statement.executeUpdate(sql.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/


}
