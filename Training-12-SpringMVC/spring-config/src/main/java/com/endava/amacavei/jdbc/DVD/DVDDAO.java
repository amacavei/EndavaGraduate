package com.endava.amacavei.jdbc.DVD;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by amacavei on 8/3/2015.
 */
public interface DVDDAO {

    public void setDataSource(DataSource ds);

    public void create(int code,String title,String description,int time,int number,int price);

    public DVD getBon(int code);

    public List<DVD> listBon();

    public void delete(Integer code);

    public void update(Integer code, String title);
}
