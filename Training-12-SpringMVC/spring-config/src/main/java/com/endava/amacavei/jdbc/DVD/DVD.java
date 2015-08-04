package com.endava.amacavei.jdbc.DVD;

/**
 * Created by amacavei on 8/3/2015.
 */
public class DVD {

    private int code;
    private String title;
    private String Description;
    private int time;
    private int number;
    private int price;

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return Description;
    }

    public int getTime() {
        return time;
    }

    public int getNumber() {
        return number;
    }

    public int getPrice() {
        return price;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
