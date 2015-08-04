package com.endava.amacavei.jdbc.inchirieri;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by amacavei on 8/3/2015.
 */
public interface InchirieriDAO {

    public void setDataSource(DataSource ds);

    public void create(int rentCode, int billCode, int dvdCode);

    public Inchirieri getBon(int id);

    public List<Inchirieri> listBon();

    public void delete(Integer dvdCode);

    public void update(Integer rentCode, Integer billCode);
}
