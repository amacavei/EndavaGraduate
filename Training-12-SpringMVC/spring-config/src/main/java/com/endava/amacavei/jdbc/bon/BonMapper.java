package com.endava.amacavei.jdbc.bon;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by amacavei on 8/3/2015.
 */
public class BonMapper implements RowMapper<Bon>{
    public Bon mapRow(ResultSet rs, int rowNum) throws SQLException{
        Bon bon = new Bon();
        bon.setId(rs.getInt("id"));
        bon.setDate(rs.getString("date"));
        bon.setCode(rs.getInt("code"));

        return bon;
    }
}
