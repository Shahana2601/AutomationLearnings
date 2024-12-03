package com.test.datadriventest;

import org.testng.annotations.Test;

public class TwoDimArray {

    @Test(dataProvider = "dp1", dataProviderClass = DataSupplier.class)
    public void testLogin(String[] s){
        System.out.println(s[0] + " >> " + s[1]);
    }

    @Test(dataProvider = "dp1", dataProviderClass = DataSupplier.class)
    public void testLogin1(String[] s){
        System.out.println(s[0] + " >> " + s[1]);
    }

    @Test(dataProvider = "dp3", dataProviderClass = DataSupplier.class)
    public void testLogin2(String username, String password){
        System.out.println(username + " " + password);
    }
}
