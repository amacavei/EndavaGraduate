package com.endava.amacavei.mvc.controller;

import com.endava.amacavei.mvc.model.Node;
import com.endava.amacavei.mvc.service.NodeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Map;


@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private DBCollection dbCollection;

	@Autowired
	private NodeService nodeService;


	//Get the configuration of all nodes
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ResponseEntity<String> readMongo() {

		return new ResponseEntity<String>(nodeService.getNodes().toString(), HttpStatus.OK);
	}

	//Get the configuration of a specific node
	@RequestMapping(value = "/readNode/{name}", method = RequestMethod.GET)
	public ResponseEntity<String> readMongoDocName(@PathVariable String name) {

		return new ResponseEntity<String>(nodeService.findNode(name).toString(), HttpStatus.OK);
	}

	//Get the bottom up merged configuration
	@RequestMapping(value = "/pathBottomUp/{name}",method = RequestMethod.GET)
	public ResponseEntity<String> getMongoPathBU(@PathVariable String name) throws com.fasterxml.jackson.core.JsonProcessingException{

		return new ResponseEntity<String>(nodeService.getPathBottomUp(name), HttpStatus.OK);

	}

	//Get the top down merged configuration
	@RequestMapping(value = "/pathTopDown/{name}",method = RequestMethod.GET)
	public ResponseEntity<String> getMongoPathTD(@PathVariable String name) throws com.fasterxml.jackson.core.JsonProcessingException{

		return new ResponseEntity<String>(nodeService.getPathTopDown(name), HttpStatus.OK);

	}

	//Generate the tree with a pre-defined template
	@RequestMapping(value = "/generate",method = RequestMethod.POST)
	public ResponseEntity<String> generateTree(){

		dbCollection.drop();
		Node A = new Node("1","A","ticket","1");
		Node B = new Node("1.1","B","ticket","2");
		Node C = new Node("1.2","C","ticket","3");
		Node D = new Node("1.3","D","ticket","4");
		Node E = new Node("1.1.1","E","ticket","5");
		Node F = new Node("1.1.2","F","ticket","6");
		Node G = new Node("1.2.1","G","ticket","7");
		Node H = new Node("1.2.2","H","ticket","8");
		Node I = new Node("1.3.1","I","ticket","9");
		Node test = new Node("1.3.1.1","test","ticket","10");



		nodeService.addChild(A,B);
		nodeService.addChild(A,C);
		nodeService.addChild(A,D);
		nodeService.addChild(B,E);
		nodeService.addChild(B,F);
		nodeService.addChild(C,G);
		nodeService.addChild(C,H);
		nodeService.addChild(D,I);
		nodeService.addChild(I, test);

		try {
			nodeService.addToMongo(A);
			nodeService.addToMongo(B);
			nodeService.addToMongo(C);
			nodeService.addToMongo(D);
			nodeService.addToMongo(E);
			nodeService.addToMongo(F);
			nodeService.addToMongo(G);
			nodeService.addToMongo(H);
			nodeService.addToMongo(I);
			nodeService.addToMongo(test);
		}catch(UnknownHostException e){
			e.printStackTrace();
		}


		return new ResponseEntity<String>("{}", HttpStatus.OK);
	}

	//Get the children of a specific node
	@RequestMapping(value = "/children/{name}",method = RequestMethod.GET)
	public ResponseEntity<String> getChildren(@PathVariable String name){


		DBCursor result = dbCollection.find(new BasicDBObject("name", name));
		return new ResponseEntity<String>("Children of " + name + ": " + result.next().get("children").toString(),HttpStatus.OK);

	}

	//Create child for a specific node
	@RequestMapping(value = "/createChild",method = RequestMethod.POST)
	public ResponseEntity<String> createChildren(@RequestBody String body) throws com.fasterxml.jackson.core.JsonProcessingException{
		String responseMessage="";
		Map<String,String> mapBody = null;
		try {
			mapBody = objectMapper.readValue(body,Map.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(mapBody!=null && mapBody.get("nameChild") !=null && mapBody.get("nameParent")!=null && mapBody.get("key") !=null && mapBody.get("value")!=null)
			responseMessage = objectMapper.writeValueAsString(nodeService.createChild(mapBody.get("nameChild"), mapBody.get("nameParent"), mapBody.get("key"), mapBody.get("value")));
		return new ResponseEntity<String>(responseMessage,HttpStatus.OK);
	}

	//Delete a specific node
	@RequestMapping(value = "/remove/{name}",method = RequestMethod.DELETE)
	public ResponseEntity<String> removeNode(@PathVariable String name)throws com.fasterxml.jackson.core.JsonProcessingException{
		String responseMessage;
		responseMessage=objectMapper.writeValueAsString(nodeService.removeNode(name));
		return new ResponseEntity<String>(responseMessage,HttpStatus.OK);
	}

	//Get the parent of a specific node
	@RequestMapping(value = "/parent/{name}",method = RequestMethod.GET)
	public ResponseEntity<String> getParent(@PathVariable String name){

		return new ResponseEntity<String>(nodeService.getParent(name).toString(),HttpStatus.OK);
	}

	//Get the root of a specific node
	@RequestMapping(value = "/root/{name}",method = RequestMethod.GET)
	public ResponseEntity<String> getRoot(@PathVariable String name){

		return new ResponseEntity<String>(nodeService.getRoot(name).toString(),HttpStatus.OK);
	}


	//Update the configuration of a specific child
	@RequestMapping(value = "/updateChildConf",method = RequestMethod.PUT)
	public ResponseEntity<String> updateChild(@RequestBody String body)throws com.fasterxml.jackson.core.JsonProcessingException{
		String responseMessage="";
		Map<String,String> mapBody = null;
		try {
			mapBody = objectMapper.readValue(body,Map.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(mapBody!=null && mapBody.get("child") !=null && mapBody.get("parent")!=null && mapBody.get("key")!=null && mapBody.get("value")!=null)
			responseMessage = objectMapper.writeValueAsString(nodeService.updateChildConf(mapBody.get("key"), mapBody.get("value"), mapBody.get("parent"),mapBody.get("child")));
		return new ResponseEntity<String>(responseMessage,HttpStatus.OK);


	}

	//Update the ID of the parent for a specific node
	@RequestMapping(value = "/updateParentID",method = RequestMethod.PUT)
	public ResponseEntity<String> updateParent(@RequestBody String body)throws com.fasterxml.jackson.core.JsonProcessingException{

		String responseMessage="";
		Map<String,String> mapBody = null;
		try {
			mapBody = objectMapper.readValue(body,Map.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(mapBody!=null && mapBody.get("name") !=null && mapBody.get("id")!=null) {
			DBObject parentName = (DBObject) nodeService.getParent(mapBody.get("name"));

			responseMessage = objectMapper.writeValueAsString(nodeService.updateParentID(mapBody.get("id"), parentName.get("name").toString()));
		}
		return new ResponseEntity<String>(responseMessage,HttpStatus.OK);

	}

	//Update the configuration for a parent of a specific node
	@RequestMapping(value = "/updateParentConf",method = RequestMethod.PUT)
	public ResponseEntity<String> updateParentConf(@RequestBody String body)throws com.fasterxml.jackson.core.JsonProcessingException{

		String responseMessage="";
		Map<String,String> mapBody = null;
		try {
			mapBody = objectMapper.readValue(body,Map.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(mapBody!=null && mapBody.get("name") !=null && mapBody.get("key") !=null && mapBody.get("value")!=null) {
			DBObject parentName = (DBObject) nodeService.getParent(mapBody.get("name"));

			responseMessage = objectMapper.writeValueAsString(nodeService.updateParentConf(mapBody.get("key"), mapBody.get("value"), parentName.get("name").toString()));
		}
		return new ResponseEntity<String>(responseMessage,HttpStatus.OK);

	}

	//Verify that a node has children
	@RequestMapping(value = "/hasChildren/{name}", method = RequestMethod.GET)
	public ResponseEntity<String> hasChildren(@PathVariable String name){
		return new ResponseEntity<String>(nodeService.hasChildren(name),HttpStatus.OK);
	}

	//Update a child parent
	@RequestMapping(value = "/updateNewParent", method = RequestMethod.PUT)
	public ResponseEntity<String> updateParentForNode(@RequestBody String body)throws com.fasterxml.jackson.core.JsonProcessingException{

		String responseMessage="";
		Map<String,String> mapBody = null;
		try {
			mapBody = objectMapper.readValue(body,Map.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(mapBody!=null && mapBody.get("name") !=null && mapBody.get("parent")!=null)
			responseMessage = objectMapper.writeValueAsString(nodeService.updateParent(mapBody.get("name"),mapBody.get("parent")));
		return new ResponseEntity<String>(responseMessage,HttpStatus.OK);
	}

	//Update all the ID's of all children for a specific node if that node has children
	@RequestMapping(value = "/updateAllChildren", method = RequestMethod.PUT)
	public ResponseEntity<String> updateAllChildren(@RequestBody String body)throws com.fasterxml.jackson.core.JsonProcessingException{
		String responseMessage="";
		Map<String,String> mapBody = null;
		try {
			mapBody = objectMapper.readValue(body,Map.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(mapBody!=null && mapBody.get("name") !=null)
			responseMessage = objectMapper.writeValueAsString(nodeService.updateAllChildren(mapBody.get("name")));
		return new ResponseEntity<String>(responseMessage,HttpStatus.OK);
	}


}