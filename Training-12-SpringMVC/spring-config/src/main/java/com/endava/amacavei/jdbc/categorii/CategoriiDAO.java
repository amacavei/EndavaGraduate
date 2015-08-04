package com.endava.amacavei.jdbc.categorii;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by amacavei on 8/3/2015.
 */
public interface CategoriiDAO {

    public void setDataSource(DataSource ds);

    public void create(int id, String description);

    public Categorii getCategorii(int id);

    public List<Categorii> listBon();

    public void delete(Integer id);

    public void update(Integer id, String description);
}
