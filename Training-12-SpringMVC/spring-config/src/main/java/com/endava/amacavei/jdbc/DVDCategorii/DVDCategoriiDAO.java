package com.endava.amacavei.jdbc.DVDCategorii;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by amacavei on 8/3/2015.
 */
public interface DVDCategoriiDAO {

    public void setDataSource(DataSource ds);

    public void create(int id, int codDVD,int idCateg);

    public DVDCategorii getBon(int id);

    public List<DVDCategorii> listBon();

    public void delete(Integer id);

    public void update(Integer id, Integer codDVD);
}
