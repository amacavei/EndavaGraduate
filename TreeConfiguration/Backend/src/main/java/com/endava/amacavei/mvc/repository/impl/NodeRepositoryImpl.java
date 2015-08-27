package com.endava.amacavei.mvc.repository.impl;

import com.endava.amacavei.mvc.model.Node;
import com.endava.amacavei.mvc.repository.NodeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

/**
 * Created by amacavei on 8/18/2015.
 */
@Repository
public class NodeRepositoryImpl implements NodeRepository {




    @Autowired
    private DBCollection dbCollection;
    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public String removeNode(String name){

        String response;
        if(findNode(name)==null){
            response = "Node not found";
        }
        else if(findNode(name).get("name").equals("A")){
            response = "Not allowed to delete root node";
        }
        else {

            DBObject obj = findNode(getParent(name).get("name").toString());
            BasicDBList resultParentChildren = (BasicDBList) obj.get("children");
            if (!resultParentChildren.isEmpty()) {
                resultParentChildren.remove(name);
            }

            BasicDBObject newParent = new BasicDBObject("_id", obj.get("_id")).append("name", obj.get("name")).append("children", resultParentChildren).append("key", obj.get("key")).append("value", obj.get("value"));
            dbCollection.remove(obj);
            dbCollection.save(newParent);

            String resultID = findNode(name).get("_id").toString();
            BasicDBObject query = new BasicDBObject();
            Pattern regex = Pattern.compile("^" + resultID);
            query.put("_id", regex);
            dbCollection.remove(query);
            response = "Node and all children deleted";
        }

        return response;

    }
    @Override
    public int getNumberOfChildren(String name){
        BasicDBList kidList = (BasicDBList) findNode(name).get("children");
        return kidList.size();
    }

    @Override
    public String hasChildren(String name){
        BasicDBList kidList = (BasicDBList) findNode(name).get("children");
        if(!kidList.isEmpty())

            return "It has";
       else
            return "No Children";
    }
    @Override
    public void addChild(Node parent,Node child){

        parent.children.add(child.getName());

    }


    @Override
    public String updateChildConf(String key,String value,String parent,String child) {

        String response;
        if(findNode(child)==null){
          response = "Child not found";
        }
        else {
            BasicDBList kidList = (BasicDBList) findNode(parent).get("children");
            for (Object kid : kidList) {
                if (kid.equals(child)) {

                    DBObject resultKid = findNode(child);
                    BasicDBObject newDoc = new BasicDBObject("_id", resultKid.get("_id")).append("name", resultKid.get("name")).append("children", resultKid.get("children")).append("key", key).append("value", value);
                    dbCollection.remove(resultKid);
                    dbCollection.save(newDoc);
                }
            }
            response = "Child Updated";
        }

        return response;
        }



    @Override
    public String createChild(String newChild,String parent,String key,String value){

        String response;


        if(findNode(newChild)!=null){
            response = "Node already exists";

        }
        else {
            DBObject next = findNode(parent);
            BasicDBList parentKidList = (BasicDBList) next.get("children");

            BasicDBObject kid = new BasicDBObject("_id", next.get("_id") + "." + (parentKidList.size() + 1)).append("name", newChild).append("children", new ArrayList<String>()).append("key", key).append("value", value);
            dbCollection.save(kid);

            BasicDBList kidList = (BasicDBList) next.get("children");
            kidList.add(kid.get("name"));
            BasicDBObject newDoc = new BasicDBObject("_id", next.get("_id")).append("name", next.get("name")).append("children", kidList).append("key", next.get("key")).append("value", next.get("value"));
            dbCollection.remove(next);
            dbCollection.save(newDoc);
            response = "Child Created";
        }
         return response;
    }
    @Override
    public String updateParentID(String id,String parent){

        String response;


        DBObject resultParent = findNode(parent);
        if(resultParent!=null) {
            BasicDBObject newDoc = new BasicDBObject("_id", id).append("name", resultParent.get("name")).append("children", resultParent.get("children")).append("key", resultParent.get("key")).append("value", resultParent.get("value"));
            dbCollection.remove(resultParent);
            dbCollection.save(newDoc);
            response = "Parent Updated";
        }
        else{
            response = "No parent";
        }

    return response;

        }

    @Override
    public String updateParentConf(String key,String value,String parent){

        String response;

        DBObject resultParent = findNode(parent);
        if(resultParent!=null) {
        BasicDBObject newDoc = new BasicDBObject("_id",resultParent.get("_id")).append("name", resultParent.get("name")).append("children", resultParent.get("children")).append("key",key).append("value",value);
        dbCollection.remove(resultParent);
        dbCollection.save(newDoc);
            response = "Parent Updated";
        }
        else{
            response = "No parent";
        }
        return response;


    }

    @Override
    public Object getRoot(String name){

        String resultID = findNode(name).get("_id").toString();
        int i = 0;
        while(resultID.charAt(i)!='.'){
            i++;
        }
        String rootID = resultID.substring(0,i);
        DBCursor pathCursor = dbCollection.find(new BasicDBObject("_id", rootID));
        return pathCursor.next();
    }
    @Override
    public String getPathBottomUp(String name) throws com.fasterxml.jackson.core.JsonProcessingException{

        String resultID = findNode(name).get("_id").toString();
        HashMap<String,String> path = new HashMap<String,String>();
        String parentID;

        for (int i = 1; i <= resultID.length(); i+=2) {

            parentID = resultID.substring(0, i);
            DBCursor pathCursor = dbCollection.find(new BasicDBObject("_id", parentID));
            DBObject obj = pathCursor.next();
            path.put(obj.get("key").toString(),obj.get("value").toString());
        }
        System.out.println(path);
        return objectMapper.writeValueAsString(path);
    }

    @Override
    public String getPathTopDown(String name) throws com.fasterxml.jackson.core.JsonProcessingException {

        String resultID = findNode(name).get("_id").toString();
        HashMap<String,String> path = new HashMap<String,String>();
        String parentID;

        for (int i = resultID.length(); i > 0; i-=2) {
            parentID = resultID.substring(0, i);
            DBCursor pathCursor = dbCollection.find(new BasicDBObject("_id", parentID));
            DBObject obj = pathCursor.next();
            path.put(obj.get("key").toString(), obj.get("value").toString());
        }



        System.out.println(path);
        System.out.println(objectMapper.writeValueAsString(path));
        return objectMapper.writeValueAsString(path);
    }

    @Override
    public DBObject getParent(String name){

        String resultID = findNode(name).get("_id").toString();
        String parentID;
        int i = resultID.length()-1;
        while(resultID.charAt(i) != '.'){
            i--;
        }
        parentID = resultID.substring(0,i);

        DBCursor pathCursor = dbCollection.find(new BasicDBObject("_id", parentID));
        return pathCursor.next();
    }

    @Override
    public void addToMongo(Node node) {


        BasicDBObject doc = new BasicDBObject("_id",node.getId()).append("name", node.getName()).append("children", node.getChildren()).append("key", node.getKey()).append("value", node.getValue());
        dbCollection.save(doc);
    }

    @Override
    public void clearMongo() throws UnknownHostException{
        dbCollection.drop();
    }

    @Override
    public ArrayList<DBObject> getNodes() {
        ArrayList<DBObject> items = new ArrayList<DBObject>();

        DBCursor results = dbCollection.find();

        while (results.hasNext()) {
            items.add(results.next());
        }
        return items;
    }

    @Override
    public DBObject findNode(String name) {
        DBCursor result = dbCollection.find(new BasicDBObject("name", name));
        DBObject newObj = null;
        try {
            newObj = result.next();
        } catch (NoSuchElementException e) {
        }

        return newObj;
    }

    @Override
    public String updateParent(String name,String parent){
        String response="";
        DBObject node = findNode(name);

        DBObject obj = findNode(getParent(name).get("name").toString());
        BasicDBList resultParentChildren = (BasicDBList) obj.get("children");
        if (!resultParentChildren.isEmpty()) {
            resultParentChildren.remove(name);
        }

        BasicDBObject newParent = new BasicDBObject("_id", obj.get("_id")).append("name", obj.get("name")).append("children", resultParentChildren).append("key", obj.get("key")).append("value", obj.get("value"));
        dbCollection.remove(obj);
        dbCollection.save(newParent);
        updateAllChildren(newParent.get("name").toString());



        if(node==null){
            System.out.println("ceva");
            response = "Node not found!";
        }
        else {
            System.out.println("else");
            DBObject parentNode = findNode(parent);
            if(parentNode==null){
                System.out.println("altceva");
                response = "Parent not found!";
            }
            else {
                System.out.println("altelse");
                BasicDBList parentKidList = (BasicDBList) parentNode.get("children");
                System.out.println(node.get("name"));
                parentKidList.add(node.get("name"));
                dbCollection.save(parentNode);
                BasicDBObject newDoc = new BasicDBObject("_id", parentNode.get("_id") + "." + (parentKidList.indexOf(node.get("name")) + 1)).append("name", node.get("name")).append("children", node.get("children")).append("key", node.get("key")).append("value", node.get("value"));
                dbCollection.remove(node);
                dbCollection.save(newDoc);
                System.out.println("New Node details: " + newDoc);
                updateAllChildren(newDoc.get("name").toString());
            }
        }
        return response;
    }
    @Override
    public String updateAllChildren(String name){

        String response="";
        if(hasChildren(name).equals("It has")){
            //Find Node
        DBObject parentNode = findNode(name);
        String id = parentNode.get("_id").toString();
            //Get Children List
        BasicDBList kidList = (BasicDBList) parentNode.get("children");
        for(Object item:kidList) {

            DBObject resultParent = findNode(item.toString());
            BasicDBObject newDoc = new BasicDBObject("_id", id + "." + (kidList.indexOf(item) + 1)).append("name", resultParent.get("name")).append("children", resultParent.get("children")).append("key", resultParent.get("key")).append("value", resultParent.get("value"));
            System.out.println(newDoc + " " + id);
            dbCollection.remove(resultParent);
            dbCollection.save(newDoc);
            updateAllChildren(item.toString());
            response = "Children Updated";
        }

        }
        else if(hasChildren(name).equals("No Children")){
            response = "No children";
        }
        return response;
    }
}
