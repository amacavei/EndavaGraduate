package jdbc.DVD;

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
public class DVDJDBCTemplate implements DVDDAO{

    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void setDataSource(DataSource dataSource){

        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void create(int code,String title,String description,int time, int number,int price){

        String sql = "Insert into Categorii(id,name,city,address) VALUES (:id, :name,:city,:address)";

        Map parameters = new HashMap();
        parameters.put("code",code);
        parameters.put("title",title);
        parameters.put("description",description);
        parameters.put("time",time);
        parameters.put("number",number);
        parameters.put("price",price);

        this.namedParameterJdbcTemplate.update(sql, parameters);
        System.out.println("----------DVDRecord---------");
    }

    @Override
    public DVD getBon(int code) {
        return null;
    }

    @Override
    public List<DVD> listBon() {
        return null;
    }

    public DVD getDVD(int code){
        String SQL = "SELECT * FROM DVD WHERE COD_DVD = :code";
        SqlParameterSource namedParameters = new MapSqlParameterSource("code",Integer.valueOf(code));
        DVD dvd = namedParameterJdbcTemplate.queryForObject(SQL,namedParameters,new DVDMapper());
        return dvd;
    }

    public List<DVD> listClienti(){
        String SQL = "select * from DVD";
        List<DVD> dvd = namedParameterJdbcTemplate.query(SQL, new DVDMapper());

        return dvd;
    }

    public void delete(Integer code){
        String SQL = "delete from DVD where COD_DVD = :code";
        SqlParameterSource namedParameters = new MapSqlParameterSource("code",Integer.valueOf(code));
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Deleted DVD with code = " + code);
    }

    public void update(Integer code,String title){
        String SQL = "update DVD set title = :title WHERE code = :code";
        Map parameters = new HashMap();
        parameters.put("code",code);
        parameters.put("title",title);

        SqlParameterSource namedParameters = new MapSqlParameterSource(parameters);
        namedParameterJdbcTemplate.update(SQL,namedParameters);
        System.out.println("Updated DVD with code = "+ code);
    }
}
