/**
 * Created by amacavei on 7/20/2015.
 */
public class Verificari {

    Carte book1;
    Carte book2;

    public Verificari(Carte book1, Carte book2) {
        this.book1 = book1;
        this.book2 = book2;
    }

    public boolean duplicateBook(Carte book1, Carte book2){
        if(book1.getTitlu() == book2.getTitlu() && book1.getAutor() == book2.getAutor() && book1.getEditura() == book2.getEditura() && book1.getNumarPagini() == book2.getNumarPagini())
           return true;
                else return false;

    }

    public void biggest(Carte book1, Carte book2){
        if(book1.getNumarPagini() >= book2.getNumarPagini())
            book1.printCarte();
        else
            book2.printCarte();
    }


}
