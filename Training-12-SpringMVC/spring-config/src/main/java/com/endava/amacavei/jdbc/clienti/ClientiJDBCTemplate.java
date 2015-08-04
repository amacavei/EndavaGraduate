package com.endava.amacavei.jdbc.clienti;

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
public class ClientiJDBCTemplate implements ClientiDAO{

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setDataSource(DataSource dataSource){

        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public void create(int code,String name,String city,String address){

        String sql = "Insert into CLIENTI(COD_CLIENT,NUME_CLIENT,ORAS_CLIENT,ADRESA_CLIENT) VALUES (:code, :name,:city,:address)";

        Map parameters = new HashMap();
        parameters.put("code",code);
        parameters.put("name",name);
        parameters.put("city",city);
        parameters.put("address",address);

        this.namedParameterJdbcTemplate.update(sql, parameters);
        System.out.println("----------ClientiRecord---------");

    }



    public Clienti getClient(int code){
        String SQL = "SELECT * FROM Clienti WHERE COD_CLIENT = :code";
        SqlParameterSource namedParameters = new MapSqlParameterSource("code",Integer.valueOf(code));
        Clienti clienti = namedParameterJdbcTemplate.queryForObject(SQL,namedParameters, new ClientiMapper());
        return clienti;
    }

    public List<Clienti> listClienti(){
        String SQL = "select * from CATEGORII";
        List<Clienti> clienti = namedParameterJdbcTemplate.query(SQL, new ClientiMapper());

        return clienti;
    }

    public void delete(Integer code){
        String SQL = "delete from Clienti where COD_CLIENT = :code";
        SqlParameterSource namedParameters = new MapSqlParameterSource("code",Integer.valueOf(code));
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Deleted client with code = " + code);
    }

    public void update(Integer code,String name){
        String SQL = "update Clienti set NUME_CLIENT = :name WHERE COD_CLIENT = :code";
        Map parameters = new HashMap();
        parameters.put("code",code);
        parameters.put("name",name);

        SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Updated Clienti with code = "+ code);
    }
}
