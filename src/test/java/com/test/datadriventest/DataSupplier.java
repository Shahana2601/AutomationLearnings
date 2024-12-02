package com.test.datadriventest;

import org.testng.annotations.DataProvider;

import java.util.*;

public class DataSupplier {

    @DataProvider
    public String[][] dp1(){
        String[][] data = new String[][]{
                {"sha","123"},
                {"me","234"},
                {"i","345"}
        };
        return data;
    }

    @DataProvider
    public Iterator<String> dp2(){
        List<String> data = new ArrayList<>();
        data.add("Shah");
        data.add("meh");
        return data.iterator();
    }

    @DataProvider
    public Iterator<String[]> dp3(){
        Set<String[]> data = new HashSet<>();
        data.add(new String[] {"sb","BDHSD"});
        data.add(new String[] {"jnjsd", "yhgii"});
        return data.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dp4(){
        Set<Object[]> data = new HashSet<>();
        data.add(new Object[] {"sb","BDHSD"});
        data.add(new Object[] {"jnjsd", "yhgii"});
        return data.iterator();
    }
}
