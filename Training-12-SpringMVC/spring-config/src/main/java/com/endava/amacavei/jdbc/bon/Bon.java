package com.endava.amacavei.jdbc.bon;

/**
 * Created by amacavei on 8/3/2015.
 */
public class Bon {

    private int id;
    private String date;
    private int code;

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getCode() {
        return code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String data) {
        this.date = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
