package com.endava.amacavei.mvc.repository;

import com.endava.amacavei.mvc.model.Node;
import com.mongodb.DBObject;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by amacavei on 8/18/2015.
 */
public interface NodeRepository {


    String updateParentConf(String key,String value,String parent);
    DBObject findNode(String name);
    String updateAllChildren(String name);
    String createChild(String newChild,String parent,String key,String value);
    String updateParentID(String id,String parent);
    String updateChildConf(String key,String value,String parent,String child);
    ArrayList<DBObject> getNodes();
    Object getRoot(String name);
    Object getParent(String name);
    int getNumberOfChildren(String name);
    String hasChildren(String name);
    void addChild(Node parent,Node child);
    String removeNode(String name);
    String getPathBottomUp(String name) throws com.fasterxml.jackson.core.JsonProcessingException;
    void addToMongo(Node node) throws UnknownHostException;
    void clearMongo() throws UnknownHostException;
    String getPathTopDown(String name) throws com.fasterxml.jackson.core.JsonProcessingException;
}
