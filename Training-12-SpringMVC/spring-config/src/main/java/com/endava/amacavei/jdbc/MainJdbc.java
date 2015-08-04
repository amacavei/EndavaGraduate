package com.endava.amacavei.jdbc;

import com.endava.amacavei.jdbc.DVD.DVDJDBCTemplate;
import com.endava.amacavei.jdbc.DVDCategorii.DVDCategoriiJDBCTemplate;
import com.endava.amacavei.jdbc.bon.Bon;
import com.endava.amacavei.jdbc.bon.BonJDBCTemplate;
import com.endava.amacavei.jdbc.categorii.CategoriiJDBCTemplate;
import com.endava.amacavei.jdbc.clienti.ClientiJDBCTemplate;
import com.endava.amacavei.jdbc.inchirieri.InchirieriJDBCTemplate;
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
        //createBon();
        //createDVD();
        //createCategorie();
        //createDVDCategorii();
        //createInchirieri();
        //deleteClient();
        updateClient();
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

    private static void updateClient(){
        System.out.println("-------Client update-------");
        clientiJDBCTemplate.update(4,"ANDREI");
    }

    private static void deleteClient(){
        System.out.println("-------Client DELETE------");
        clientiJDBCTemplate.delete(4);
    }
    private static void createInchirieri(){
        System.out.println("-------Inchirieri Create-------");
        inchirieriJDBCTemplate.create(1,2,1);
    }

    private static void createDVDCategorii(){
        System.out.println("-------DVDCategorii Create-------");
        dvdCategoriiJDBCTemplate.create(1,1,1);
    }

    private static void createCategorie(){
        System.out.println("-------Categorii Create-------");
        categoriiJDBCTemplate.create(3,"Comedie");
    }

    private static void createDVD(){
        System.out.println("-------DVD Create-------");
        dvdJDBCTemplate.create(3,"500 days","500 de zile",180,2,50);
    }

    private static void createClient(){
        System.out.println("-------Client Create-------");
        clientiJDBCTemplate.create(4,"andrei","arges","Cuza-voda");
    }


    private static void createBon() {
        System.out.println("--------Bon Create--------");
        bonJDBCTemplate.create(3, "28-MAY-2015", 2);

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


