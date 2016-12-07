package org.json.simple;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by matthew on 06/12/2016.
 */
public class PrettyPrintTest {

    @Test
    public void testPrettyPrint(){
        Map m = new HashMap();
        m.put("one",1);
        m.put("two",2);
        m.put("three",3);
        System.out.println(JSONObject.prettyPrint(m));
        Assert.assertEquals("{\n" +
                "   \"one\":1,\n" +
                "   \"two\":2,\n" +
                "   \"three\":3\n" +
                "}",JSONObject.prettyPrint(m));
    }

    @Test
    public void testSimpleList(){
        List l = new ArrayList();
        l.add(1);
        l.add("two");
        l.add(3.141529);
        l.add(new Boolean(false));
        System.out.println(JSONObject.prettyPrint(l));
        Assert.assertEquals("[\n" +
                "   1,\n" +
                "   \"two\",\n" +
                "   3.141529,\n" +
                "   false\n" +
                "]",JSONObject.prettyPrint(l));
    }

    @Test
    public void testListInMap(){
        Map m = new HashMap();
        m.put("key","value");
        List l = new ArrayList();
        l.add(false);
        l.add(2);
        l.add("three");
        m.put("list",l);
        System.out.println(JSONObject.prettyPrint(m));
        Assert.assertEquals("{\n" +
                "   \"list\":[\n" +
                "      false,\n" +
                "      2,\n" +
                "      \"three\"\n" +
                "   ],\n" +
                "   \"key\":\"value\"\n" +
                "}",JSONObject.prettyPrint(m));

    }

    @Test
    public void testListInMap2(){
        Map m = new HashMap();
        List l = new ArrayList();
        l.add(false);
        l.add(2);
        l.add("three");
        m.put("list",l);
        System.out.println(JSONObject.prettyPrint(m));
        Assert.assertEquals("{\n" +
                "   \"list\":[\n" +
                "      false,\n" +
                "      2,\n" +
                "      \"three\"\n" +
                "   ]\n" +
                "}",JSONObject.prettyPrint(m));
    }

    @Test
    public void testSpaces(){
        List l = new ArrayList();
        l.add(false);
        l.add(2);
        l.add("three    ");
        System.out.println(JSONObject.prettyPrint(l));
        Assert.assertEquals("[\n" +
                "   false,\n" +
                "   2,\n" +
                "   \"three    \"\n" +
                "]",JSONObject.prettyPrint(l));
    }

    @Test
    public void testListOfList(){
        List l1 = new ArrayList();
        List l2 = new ArrayList();
        l1.add(false);
        l1.add(2);
        l1.add("three");
        l2.add(1);
        l1.add(l2);
        System.out.println(JSONObject.prettyPrint(l1));
        Assert.assertEquals("[\n" +
                "   false,\n" +
                "   2,\n" +
                "   \"three\",\n" +
                "   [\n" +
                "      1\n" +
                "   ]\n" +
                "]",JSONObject.prettyPrint(l1));
    }


    @Test
    public void testArray(){
        JSONObject json = new JSONObject();
        json.put("test", new int[] {1,2,3});
        System.out.println(json);
        System.out.println(JSONObject.prettyPrint(json));
    }



}
