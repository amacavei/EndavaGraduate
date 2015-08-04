package jdbc.inchirieri;

/**
 * Created by amacavei on 8/3/2015.
 */
public class Inchirieri {

    private int rentCode;
    private int billCode;
    private int dvdCode;

    public int getRentCode() {
        return rentCode;
    }

    public int getBillCode() {
        return billCode;
    }

    public int getDvdCode() {
        return dvdCode;
    }

    public void setRentCode(int rentCode) {
        this.rentCode = rentCode;
    }

    public void setBillCode(int billCode) {
        this.billCode = billCode;
    }

    public void setDvdCode(int dvdCode) {
        this.dvdCode = dvdCode;
    }
}
