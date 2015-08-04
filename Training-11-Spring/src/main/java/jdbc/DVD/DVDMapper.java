package jdbc.DVD;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by amacavei on 8/3/2015.
 */
public class DVDMapper implements RowMapper<DVD>{

    public DVD mapRow(ResultSet rs, int rowNum) throws SQLException {
        DVD dvd = new DVD();
        dvd.setCode(rs.getInt("code"));
        dvd.setDescription(rs.getString("description"));
        dvd.setTitle(rs.getString("title"));
        dvd.setTime(rs.getInt("time"));
        dvd.setNumber(rs.getInt("number"));
        dvd.setPrice(rs.getInt("price"));


        return dvd;
    }
}
