package jdbc.DVDCategorii;

/**
 * Created by amacavei on 8/3/2015.
 */
public class DVDCategorii {

    private int id;
    private String title;
    private int idCateg;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getIdCateg() {
        return idCateg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIdCateg(int idCateg) {
        this.idCateg = idCateg;
    }
}
