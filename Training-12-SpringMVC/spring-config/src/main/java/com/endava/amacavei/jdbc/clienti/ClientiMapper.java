package com.endava.amacavei.jdbc.clienti;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by amacavei on 8/3/2015.
 */
public class ClientiMapper implements RowMapper<Clienti>{

    public Clienti mapRow(ResultSet rs, int rowNum) throws SQLException {
        Clienti clienti = new Clienti();
        clienti.setCode(rs.getInt("code"));
        clienti.setName(rs.getString("name"));
        clienti.setCity(rs.getString("city"));
        clienti.setAddress(rs.getString("address"));


        return clienti;
    }
}
