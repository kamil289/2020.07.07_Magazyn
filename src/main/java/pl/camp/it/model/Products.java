package pl.camp.it.model;

public class Products {

    private final int id;
    private String kategoria;
    private String nazwaProduktu;
    private int iloscSztuk;
    private int kodKreskowy;



    public Products(int id, String kategoria, String nazwaProduktu, int iloscSztuk, int kodKreskowy) {
        this.id = id;
        this.kategoria = kategoria;
        this.nazwaProduktu = nazwaProduktu;
        this.iloscSztuk = iloscSztuk;
        this.kodKreskowy = kodKreskowy;
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

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", kategoria='" + kategoria + '\'' +
                ", nazwaProduktu='" + nazwaProduktu + '\'' +
                ", iloscSztuk=" + iloscSztuk +
                ", kodKreskowy=" + kodKreskowy +
                '}';
    }
}
