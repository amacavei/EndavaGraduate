package jdbc.DVDCategorii;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by amacavei on 8/3/2015.
 */
public class DVDCategoriiMapper implements RowMapper<DVDCategorii>{

    public DVDCategorii mapRow(ResultSet rs, int rowNum) throws SQLException {
        DVDCategorii dvdCateg = new DVDCategorii();
        dvdCateg.setId(rs.getInt("id"));
        dvdCateg.setTitle(rs.getString("title"));
        dvdCateg.setIdCateg(rs.getInt("idCateg"));

        return dvdCateg;
    }
}
