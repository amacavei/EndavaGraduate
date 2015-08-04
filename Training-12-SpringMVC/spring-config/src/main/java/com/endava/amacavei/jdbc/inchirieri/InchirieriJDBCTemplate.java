package com.endava.amacavei.jdbc.inchirieri;

import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amacavei on 8/3/2015.
 */
public class InchirieriJDBCTemplate implements InchirieriDAO {

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setDataSource(DataSource dataSource){

        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void create(int rentCode,int billCode,int dvdCode){

        String sql = "Insert into INCHIRIERI (COD_INCHIRIERE,COD_BON,COD_DVD) VALUES (:rentCode,:billCode,:dvdCode)";

        Map parameters = new HashMap();
        parameters.put("rentCode",rentCode);
        parameters.put("billCode",billCode);
        parameters.put("dvdCode",dvdCode);

        this.namedParameterJdbcTemplate.update(sql, parameters);
        System.out.println("----------InchirieriRecord---------");
    }

    @Override
    public Inchirieri getBon(int id) {
        return null;
    }

    @Override
    public List<Inchirieri> listBon() {
        return null;
    }

    public Inchirieri getInchirieri(int rentCode){
        String SQL = "SELECT * FROM Inchirieri WHERE COD_INCHIRIERE = :rentCode";
        SqlParameterSource namedParameters = new MapSqlParameterSource("rentCode",Integer.valueOf(rentCode));
        Inchirieri inchiriere = namedParameterJdbcTemplate.queryForObject(SQL,namedParameters,new InchirieriMapper());
        return inchiriere;
    }

    public List<Inchirieri> listInchirieri(){
        String SQL = "select * from INCHIRIERI";
        List<Inchirieri> inchirieri = namedParameterJdbcTemplate.query(SQL, new InchirieriMapper());

        return inchirieri;
    }

    public void delete(Integer rentCode){
        String SQL = "delete from INCHIRIERI where COD_INCHIRIERE = :rentCode";
        SqlParameterSource namedParameters = new MapSqlParameterSource("rentCode",Integer.valueOf(rentCode));
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Deleted Inchiriere with COD_INCHIRIERE = " + rentCode);
    }

    public void update(Integer rentCode,Integer dvdCode){
        String SQL = "update Inchiriere set COD_DVD = :dvdCode WHERE COD_INCHIRIERE = :rentCode";
        Map parameters = new HashMap();
        parameters.put("rentCode",rentCode);
        parameters.put("dvdCode",dvdCode);
        SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Updated Inchirieri with COD_INCHIRIERE = "+ rentCode);
    }

}
