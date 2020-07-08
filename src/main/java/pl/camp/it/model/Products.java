package pl.camp.it.model;

public class Products {

    private int id;
    private String kategoria;
    private String nazwaProduktu;
    private int iloscSztuk;
    private int kodKreskowy;

    public void Categorie(int id, String kategoria) {
        this.id = id;
        this.kategoria = kategoria;
    }

    public Products(int id, String kategoria, String nazwaProduktu, int iloscSztuk, int kodKreskowy) {
        this.id = id;
        this.kategoria = kategoria;
        this.nazwaProduktu = nazwaProduktu;
        this.iloscSztuk = iloscSztuk;
        this.kodKreskowy = kodKreskowy;
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

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getNazwaProduktu() {
        return nazwaProduktu;
    }

    public void setNazwaProduktu(String nazwaProduktu) {
        this.nazwaProduktu = nazwaProduktu;
    }

    public int getIloscSztuk() {
        return iloscSztuk;
    }

    public void setIloscSztuk(int iloscSztuk) {
        this.iloscSztuk = iloscSztuk;
    }

    public int getKodKreskowy() {
        return kodKreskowy;
    }

    public void setKodKreskowy(int kodKreskowy) {
        this.kodKreskowy = kodKreskowy;
    }
}
