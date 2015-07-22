/**
 * Created by amacavei on 7/20/2015.
 */


public class Carte {

    public String titlu;
    public String autor;
    public String editura;
    public int numarPagini;

    public Carte(String titlu, String autor, String editura, int numarPagini) {
        this.titlu = titlu;
        this.autor = autor;
        this.editura = editura;
        this.numarPagini = numarPagini;
    }

    public String getTitlu() {
        return titlu;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditura() {
        return editura;
    }

    public int getNumarPagini() {
        return numarPagini;
    }

    public void printCarte(){
        System.out.println(titlu + " " + autor + " " + editura + " " + numarPagini);
    }
}

