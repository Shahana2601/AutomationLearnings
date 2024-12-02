package com.test.datadriventest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OneDimArray {

    @Test(dataProvider = "dp1")
    public void testLogin(String s) throws Exception{
        System.out.println(s);
    }

    @Test(dataProvider = "dp2")
    public void testLogin(Integer s) throws Exception{
        System.out.println(s);
    }

    @Test(dataProvider = "dp3")
    public void testLogin(Object s){
        System.out.println(s);
    }

    /*
    * Method for String array
    */
    @DataProvider
    public String[] dp1(){
        //String array
        String[] data = new String[]{
                "abcd",
                "xyz",
                "pqr"
        };
        return data;
    }

    /*
    * Method for integer array
    * */
    @DataProvider
    public Integer[] dp2(){
        //Integer array
        Integer[] data = new Integer[]{
                1,
                2,
                3
        };
        return data;
    }

    /*
    * Method for object array*/
    @DataProvider
    public Object[] dp3(){

        //Object array
        Object[] data =  new Object[]{
                "Admin",
                1,
                2,
                "Test"
        };
        return data;
    }
}
