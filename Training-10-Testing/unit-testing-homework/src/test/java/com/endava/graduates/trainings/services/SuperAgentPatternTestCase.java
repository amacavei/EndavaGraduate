package com.endava.graduates.trainings.services;

import com.endava.graduates.trainings.patterns.SuperAgentPattern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by amacavei on 7/30/2015.
 */
public class SuperAgentPatternTestCase{
    SuperAgentPattern testClass;

    @Before
    public void setUp(){
        testClass = new SuperAgentPattern();
    }

    @Test
    public void test1() throws Exception{
        List<String> inputList = new ArrayList<String>();
        inputList = null;
        boolean actual = testClass.checkIfSuperAgent(inputList);
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @Test
    public void test2() throws Exception{
        List<String> inputList = new ArrayList<String>();
        inputList.add("Super Secret Agent");
        boolean actual = testClass.checkIfSuperAgent(inputList);
        boolean expected = true;
        assertEquals(actual, expected);
    }
    @Test
    public void test3() throws Exception{
        List<String> inputList = new ArrayList<String>();
        inputList.add("Superman");
        boolean actual = testClass.checkIfSuperAgent(inputList);
        boolean expected = false;
        assertEquals(actual, expected);
    }

    @After
    public void tearDown(){
        testClass = null;
    }
}
