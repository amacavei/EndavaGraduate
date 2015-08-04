package jdbc;

import jdbc.DVD.DVDJDBCTemplate;
import jdbc.DVDCategorii.DVDCategoriiJDBCTemplate;
import jdbc.bon.Bon;
import jdbc.bon.BonJDBCTemplate;
import jdbc.categorii.CategoriiJDBCTemplate;
import jdbc.clienti.ClientiJDBCTemplate;
import jdbc.inchirieri.InchirieriJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 * Created by amacavei on 8/3/2015.
 */
public class MainJdbc {

    private static BonJDBCTemplate bonJDBCTemplate;
    private static CategoriiJDBCTemplate categoriiJDBCTemplate;
    private static ClientiJDBCTemplate clientiJDBCTemplate;
    private static DVDJDBCTemplate dvdJDBCTemplate;
    private static DVDCategoriiJDBCTemplate dvdCategoriiJDBCTemplate;
    private static InchirieriJDBCTemplate inchirieriJDBCTemplate;

    public static void main(String[] args){
        init();
        createBon();
        deleteBon(new int[]{2, 3, 4});
        updateBon(2);
        getBon(2);
        getBons();
    }
        //BON


    private static void init(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        bonJDBCTemplate = (BonJDBCTemplate) context.getBean("BonJDBCTemplate");
        categoriiJDBCTemplate = (CategoriiJDBCTemplate) context.getBean("CategoriiJDBCTemplate");
        clientiJDBCTemplate = (ClientiJDBCTemplate) context.getBean("ClientiJDBCTemplate");
        dvdJDBCTemplate = (DVDJDBCTemplate) context.getBean("DVDJDBCTemplate");
        dvdCategoriiJDBCTemplate = (DVDCategoriiJDBCTemplate) context.getBean("DVDCategoriiJDBCTemplate");
        inchirieriJDBCTemplate = (InchirieriJDBCTemplate) context.getBean("InchirieriJDBCTemplate");
    }

    private static void createBon() {
        System.out.println("--------Bon Create--------");
        bonJDBCTemplate.create(2, "28-MAY-2015", 14);

    }

    private static void deleteBon(int[] ids) {
        System.out.println("------Bon delete--------");
        for (int id : ids) {
            bonJDBCTemplate.delete(id);
        }
    }

    private static void updateBon(int id) {
        System.out.println("------Specializations update--------");
        bonJDBCTemplate.update(id, "new bon for id = " + id);
    }

    private static Bon getBon(int id) {
        System.out.println("------Specializations get by id--------");
        Bon bon = bonJDBCTemplate.getBon(id);
        System.out.println(bon.getId() + " " + bon.getDate());
        return bon;
    }

    private static List<Bon> getBons() {
        System.out.println("------Specializations getSpecializations--------");
        List<Bon> bons = bonJDBCTemplate.listBon();
        for (Bon bon : bons) {
            System.out.println(bon.getId() + " " + bon.getDate());
        }
        return bons;
    }
}


