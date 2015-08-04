package com.endava.amacavei.jdbc.categorii;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amacavei on 8/3/2015.
 */
public class CategoriiJDBCTemplate {

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setDataSource(DataSource dataSource){

        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void create(int id,String description){

        String sql = "Insert into CATEGORII(ID_CATEGORIE,DESCRIERE_CATEGORIE) VALUES (:id, :description)";

        Map parameters = new HashMap();
        parameters.put("id",id);
        parameters.put("description",description);

        this.namedParameterJdbcTemplate.update(sql, parameters);
        System.out.println("----------CategoriiRecord---------");
    }

    public Categorii getCategorii(int id){
        String SQL = "SELECT * FROM CATEGORII WHERE ID_CATEGORIE = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id",Integer.valueOf(id));
        Categorii categorii = (Categorii) namedParameterJdbcTemplate.queryForObject(SQL,namedParameters, new CategoriiMapper());
        return categorii;
    }

    public List<Categorii> listCateg(){
        String SQL = "select * from CATEGORII";
        List<Categorii> bonuri = namedParameterJdbcTemplate.query(SQL, new CategoriiMapper());

        return bonuri;
    }

    public void delete(Integer id){
        String SQL = "delete from CATEGORII where ID_CATEGORIE = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id",Integer.valueOf(id));
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Deleted categorie with id = " + id);
    }

    public void update(Integer id,String description){
        String SQL = "update CATEGORII set DESCRIERE_CATEGORIE = :description WHERE ID_CATEGORIE = :id";
        Map parameters = new HashMap();
        parameters.put("id",id);
        parameters.put("description",description);
        SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Updated Categorii with ID_CATEGORIE = "+ id);
    }
}
