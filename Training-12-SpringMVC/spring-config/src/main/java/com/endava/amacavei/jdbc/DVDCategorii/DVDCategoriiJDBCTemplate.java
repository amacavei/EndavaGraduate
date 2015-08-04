package com.endava.amacavei.jdbc.DVDCategorii;

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
public class DVDCategoriiJDBCTemplate implements DVDCategoriiDAO{

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setDataSource(DataSource dataSource){

        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void create(int id,int codDVD,int idCateg){

        String sql = "Insert into DVD_CATEGORII(ID,COD_DVD,COD_CATEGORIE) VALUES (:id, :codDVD, :idCateg)";

        Map parameters = new HashMap();
        parameters.put("id",id);
        parameters.put("codDVD",codDVD);
        parameters.put("idCateg",idCateg);

        this.namedParameterJdbcTemplate.update(sql, parameters);
        System.out.println("----------DVDCategoriiRecord---------");
    }

    @Override
    public DVDCategorii getBon(int id) {
        return null;
    }

    @Override
    public List<DVDCategorii> listBon() {
        return null;
    }


    public DVDCategorii getDVDCateg(int id){
        String SQL = "SELECT * FROM DVD_CATEGORII WHERE ID = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id",Integer.valueOf(id));
        DVDCategorii dvdCateg = namedParameterJdbcTemplate.queryForObject(SQL,namedParameters,new DVDCategoriiMapper());
        return dvdCateg;
    }

    public List<DVDCategorii> listDVDCateg(){
        String SQL = "select * from bon";
        List<DVDCategorii> dvdCateg = namedParameterJdbcTemplate.query(SQL, new DVDCategoriiMapper());

        return dvdCateg;
    }

    public void delete(Integer id){
        String SQL = "delete from DVD_CATEGORII where ID = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id",Integer.valueOf(id));
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Deleted DVD_CATEGORII with ID = " + id);
    }

    public void update(Integer id,Integer codDVD){
        String SQL = "update DVD_CATEGORII set COD_DVD = :codDVD WHERE ID = :id";
        Map parameters = new HashMap();
        parameters.put("id",id);
        parameters.put("codDVD",codDVD);
        SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Updated DVD_CATEGORII with ID = "+ id);
    }
}
