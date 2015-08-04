package com.endava.amacavei.jdbc.clienti;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by amacavei on 8/3/2015.
 */
public interface ClientiDAO {

    public void setDataSource(DataSource ds);

    public void create(int code, String name ,String city, String address);

    public Clienti getClient(int code);

    public List<Clienti> listClienti();

    public void delete(Integer code);

    public void update(Integer id, String city);
}
