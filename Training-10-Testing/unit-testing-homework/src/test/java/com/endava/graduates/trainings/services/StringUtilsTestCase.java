package com.endava.graduates.trainings.services;

import com.endava.graduates.trainings.patterns.FileContentPattern;
import com.endava.graduates.trainings.utils.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by amacavei on 7/30/2015.
 */
public class StringUtilsTestCase {

    StringUtils testClass;

    @Before
    public void setUp(){
        testClass = new StringUtils();
    }

    @Test
    public void test1() throws Exception{
        String actual = testClass.toUpperCase("abc");
        String expected = "ABC";
        assertEquals(expected,actual);
    }

    @Test
    public void test2() throws Exception{
        String actual = testClass.concatStrings("be", "ta");
        String expected = "beta";
        assertEquals(expected,actual);
    }

    @Test
    public void test4() throws Exception{
        String actual = testClass.substringValue("abc", 1);
        String expected = "bc";
        assertEquals(expected, actual);
    }

    @Test
    public void test5() throws Exception{
        String actual = testClass.substringValue("abc", 3);
        String expected = "";
        assertEquals(expected, actual);
    }

    @After
    public void tearDown(){
        testClass = null;
    }
}
