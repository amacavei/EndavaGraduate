package com.endava.amacavei.mvc.model;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.lang.Object.*;

/**
 * Created by amacavei on 8/14/2015.
 */
public class Node {

    public String id;
    public String name;
    public ArrayList<String> children;
    public String key;
    public String value;



    public Node(String id,String name,String key,String value) {
        this.key = key;
        this.value = value;
        this.id = id;
        children = new ArrayList<String>();
        this.name = name;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setID(){
        this.id = id;
    }

    public ArrayList<String> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<String> children){
        this.children = children;
    }


}
