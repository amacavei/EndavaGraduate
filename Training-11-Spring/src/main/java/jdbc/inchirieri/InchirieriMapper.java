package jdbc.inchirieri;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by amacavei on 8/3/2015.
 */
public class InchirieriMapper implements RowMapper<Inchirieri>{

    public Inchirieri mapRow(ResultSet rs, int rowNum) throws SQLException {
        Inchirieri inchirieri = new Inchirieri();
        inchirieri.setRentCode(rs.getInt("rentCode"));
        inchirieri.setBillCode(rs.getInt("billCode"));
        inchirieri.setDvdCode(rs.getInt("dvdCode"));

        return inchirieri;
    }
}
