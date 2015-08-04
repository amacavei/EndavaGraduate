package com.endava.amacavei.jdbc.bon;

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
public class BonJDBCTemplate implements BonDAO{

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setDataSource(DataSource dataSource){

        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void create(int id,String date,int code){

        String sql = "Insert into BON(BON_ID,DATA_BON,COD_CLIENT) VALUES (:id,:date,:code)";

        Map parameters = new HashMap();
        parameters.put("id",id);
        parameters.put("date",date);
        parameters.put("code",code);

        this.namedParameterJdbcTemplate.update(sql, parameters);
        System.out.println("----------BonRecord---------");

    }

    public Bon getBon(int id){
        String SQL = "SELECT * FROM Bon WHERE BON_ID = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id",Integer.valueOf(id));
        Bon bon = namedParameterJdbcTemplate.queryForObject(SQL,namedParameters,new BonMapper());
        return bon;
    }

    public List<Bon> listBon(){
        String SQL = "select * from bon";
        List<Bon> bonuri = namedParameterJdbcTemplate.query(SQL, new BonMapper());

        return bonuri;
    }

    public void delete(Integer id){
        String SQL = "delete from Bon where BON_ID = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id",Integer.valueOf(id));
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Deleted bon with id = " + id);
    }

    public void update(Integer id,String date){
        String SQL = "update bon set date = :date WHERE id = :id";
        Map parameters = new HashMap();
        parameters.put("id",id);
        parameters.put("Date",date);
        SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Updated Bon with id = "+ id);
    }





}
