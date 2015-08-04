package com.endava.amacavei.jdbc.bon;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by amacavei on 8/3/2015.
 */
public interface BonDAO {


    public void setDataSource(DataSource ds);

    public void create(int id, String date,int code);

    public Bon getBon(int id);

    public List<Bon> listBon();

    public void delete(Integer id);

    public void update(Integer id, String date);
}

