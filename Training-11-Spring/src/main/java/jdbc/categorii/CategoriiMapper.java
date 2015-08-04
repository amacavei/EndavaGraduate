package jdbc.categorii;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Created by amacavei on 8/3/2015.
 */
public class CategoriiMapper implements RowMapper<Categorii>{

    public Categorii mapRow(ResultSet rs, int rowNum) throws SQLException{
        Categorii categorii = new Categorii();
        categorii.setId(rs.getInt("id"));
        categorii.setDescription(rs.getString("Description"));


        return categorii;
    }
}
