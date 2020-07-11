package pl.camp.it.model;

public class Categorie {
    private int id;
    private String kategoria;

    public Categorie(int id, String kategoria) {
        this.id = id;
        this.kategoria = kategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKategoria() {
        return kategoria;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", kategoria='" + kategoria + '\'' +
                '}';
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;


    }

}
