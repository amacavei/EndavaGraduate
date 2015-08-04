package jdbc.inchirieri;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by amacavei on 8/3/2015.
 */
public interface InchirieriDAO {

    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to create
     * a record in the Graduate table.
     */
    public void create(int rentCode, int billCode, int dvdCode);

    /**
     * This is the method to be used to list down
     * a record from the Graduate table corresponding
     * to a passed graduate id.
     */
    public Inchirieri getBon(int id);

    /**
     * This is the method to be used to list down
     * all the records from the Graduate table.
     */
    public List<Inchirieri> listBon();

    /**
     * This is the method to be used to delete
     * a record from the Graduate table corresponding
     * to a passed graduate id.
     */
    public void delete(Integer dvdCode);

    /**
     * This is the method to be used to update
     * a record into the Graduate table.
     */
    public void update(Integer rentCode, Integer billCode);
}
