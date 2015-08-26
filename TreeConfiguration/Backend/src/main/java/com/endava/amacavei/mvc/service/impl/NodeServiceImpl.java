package com.endava.amacavei.mvc.service.impl;

import com.endava.amacavei.mvc.model.Node;
import com.endava.amacavei.mvc.repository.NodeRepository;
import com.endava.amacavei.mvc.service.NodeService;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by amacavei on 8/18/2015.
 */

@Service
public class NodeServiceImpl implements NodeService{

    @Autowired
    private NodeRepository nodeRepository;


    @Override
    @Transactional
    public String updateAllChildren(String name){
        return nodeRepository.updateAllChildren(name);
    }

    @Override
    @Transactional
    public String hasChildren(String name){
        return nodeRepository.hasChildren(name);
    }

    @Override
    @Transactional
    public ArrayList<DBObject> getNodes(){
        return nodeRepository.getNodes();
    }

    @Override
    @Transactional

    public Object getRoot(String name){
        return nodeRepository.getRoot(name);
    }
    @Override
    @Transactional

    public Object getParent(String name){
        return nodeRepository.getParent(name);
    }
    @Override
    @Transactional
    public int getNumberOfChildren(String name){

        return nodeRepository.getNumberOfChildren(name);
    }

    @Override
    @Transactional
    public DBObject findNode(String name){

        return nodeRepository.findNode(name);
    }

    @Override
    @Transactional
    public void addChild(Node parent,Node child){
        nodeRepository.addChild(parent, child);

    }

    @Override
    @Transactional
    public String getPathTopDown(String name) throws com.fasterxml.jackson.core.JsonProcessingException{
       return nodeRepository.getPathTopDown(name);
    }

    @Override
    @Transactional
    public String removeNode(String name){
        return nodeRepository.removeNode(name);
    }


    @Override
    @Transactional
    public String getPathBottomUp(String name) throws com.fasterxml.jackson.core.JsonProcessingException{
        return nodeRepository.getPathBottomUp(name);
    }

    @Override
    @Transactional
    public void addToMongo(Node node) throws UnknownHostException{
        nodeRepository.addToMongo(node);
    }
    @Override
    @Transactional
    public void clearMongo() throws UnknownHostException{
        nodeRepository.clearMongo();
    }

    @Override
    @Transactional
    public String updateChildConf(String key,String value,String parent,String child){

        return nodeRepository.updateChildConf(key,value, parent, child);
    }

    @Override
    @Transactional
    public String updateParentID(String id,String parent){
        return nodeRepository.updateParentID(id, parent);
    }

    @Override
    @Transactional
    public String updateParentConf(String key,String value,String parent){
        return nodeRepository.updateParentConf(key,value, parent);
    }

    @Override
    @Transactional
    public String createChild(String newChild,String parent,String key,String value){
        return nodeRepository.createChild(newChild, parent,key,value);
    }
}
