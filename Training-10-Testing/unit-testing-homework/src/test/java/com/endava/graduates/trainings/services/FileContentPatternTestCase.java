package com.endava.graduates.trainings.services;

import com.endava.graduates.trainings.patterns.FileContentPattern;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by amacavei on 7/30/2015.
 */
public class FileContentPatternTestCase {
    FileContentPattern testClass;

    @Before
    public void setUp(){
        testClass = new FileContentPattern();
    }

    @Test
     public void test1() throws Exception{
        String actual = testClass.verifyContent("agent",1);
        String expected = "Secret Agent";
        assertEquals(expected,actual);
    }

    @Test
    public void test2() throws Exception{
        String actual = testClass.verifyContent("superAgent",5);
        String expected = "Super Secret Agent";
        assertEquals(expected,actual);
    }

    @Test(expected=Exception.class)
    public void test3() throws Exception{
        testClass.verifyContent("superAgent", 4);

    }
    @Test
    public void test4() throws Exception{
        String actual = testClass.verifyContent(null,5);
        String expected = null;
        assertNull(expected, actual);
    }

    @Test
    public void test5() throws Exception{
        String actual = testClass.verifyContent("agent",6);
        String expected = null;
        assertNull(expected, actual);
    }

    @Test
    public void test6() throws Exception{
        String actual = testClass.verifyContent("superAgent",6);
        String expected = "Super Secret Agent";
        assertEquals(expected, actual);
    }

    @Test
    public void test7()throws Exception{
        String actual = testClass.verifyContent("SuperMan",6);
        String expected = null;
        assertNull(expected, actual);
    }

    @Test
    public void test8()throws Exception{
        String actual = testClass.verifyContent("SuperMan",4);
        String expected = null;
        assertNull(expected, actual);
    }

    @After
    public void tearDown(){
        testClass = null;
    }

}
