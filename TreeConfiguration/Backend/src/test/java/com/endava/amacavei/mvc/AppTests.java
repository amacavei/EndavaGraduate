package com.endava.amacavei.mvc;

import com.endava.amacavei.mvc.repository.impl.NodeRepositoryImpl;
import com.endava.amacavei.mvc.service.impl.NodeServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.powermock.api.mockito.PowerMockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;





    @InjectMocks
    @Autowired
    private NodeRepositoryImpl nodeRepository;


    @Autowired
    @Mock
    private DBCollection dbCollection;
    @Autowired
    @Mock
    private ObjectMapper objectMapper;



    @Before
    public void setup() {

        this.mockMvc = webAppContextSetup(this.wac).build();

        nodeRepository = new NodeRepositoryImpl();

    }

    @Test
    public void test2()throws Exception{
        Mockito.when(dbCollection.find()).thenReturn(null);
        ArrayList<DBObject> actual = nodeRepository.getNodes();
        assertNull(actual);
    }

    @Test
    public void test1()throws Exception{
        Mockito.when(dbCollection.find(new BasicDBObject("name", "T"))).thenReturn(null);
        DBObject actual = nodeRepository.findNode("T");
        assertNull(actual);
    }

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }

    @Test
    public void simpleRead() throws Exception {
        mockMvc.perform(get("/read"))
                .andExpect(status().isOk());
    }

    @Test
    public void simpleReadNode() throws Exception {
        mockMvc.perform(get("/readNode/A"))
                .andExpect(status().isOk());
    }

    @Test
    public void simpleReadPathBU() throws Exception {
        mockMvc.perform(get("/pathBottomUp/B"))
                .andExpect(status().isOk());
    }
    @Test
    public void simpleReadPathTD() throws Exception {
        mockMvc.perform(get("/pathTopDown/B"))
                .andExpect(status().isOk());
    }

    @Test
    public void simpleReadChildren() throws Exception {
        mockMvc.perform(get("/children/A"))
                .andExpect(status().isOk());
    }

    @Test
    public void simpleReadParent() throws Exception {
        mockMvc.perform(get("/parent/B"))
                .andExpect(status().isOk());
    }

    @Test
    public void simpleReadRoot() throws Exception {
        mockMvc.perform(get("/root/B"))
                .andExpect(status().isOk());
    }

    @Test
    public void simpleReadHasChildren() throws Exception {
        mockMvc.perform(get("/hasChildren/A"))
                .andExpect(status().isOk());
    }


}
