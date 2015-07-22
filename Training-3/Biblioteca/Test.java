/**
 * Created by amacavei on 7/20/2015.
 */
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);
        String titlu = s.nextLine();
        String autor = s.nextLine();
        String editura = s.nextLine();
        String numarPagini = s.nextLine();
        while(Integer.parseInt(numarPagini) == 0) {
                System.out.println("Numarul de pagini trebuie sa fie diferit de 0 !!!");
                numarPagini = s.nextLine();
            }

        Carte book = new Carte(titlu, autor, editura, Integer.parseInt(numarPagini));

        Carte book1= new Carte("titlu1","autor1","editura1",25);
        Carte book2= new Carte("titlu1","autor1","editura1",21);

        book.printCarte();

        Verificari verificari = new Verificari(book1,book2);

        System.out.println(verificari.duplicateBook(book1, book2));
        verificari.biggest(book1, book2);
    }
}