package jdbc.DVDCategorii;

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
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void create(int id,String title,int idCateg){

        String sql = "Insert into DVDCategorii(id,title,idCateg) VALUES (:id, :title, :idCateg)";

        Map parameters = new HashMap();
        parameters.put("id",id);
        parameters.put("title",title);
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
        System.out.println("Deleted DVD_CATEGORII with id = " + id);
    }

    public void update(Integer id,String title){
        String SQL = "update DVD_CATEGORII set title = :title WHERE id = :id";
        Map parameters = new HashMap();
        parameters.put("id",id);
        parameters.put("title",title);
        SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Updated DVD_CATEGORII with id = "+ id);
    }
}
