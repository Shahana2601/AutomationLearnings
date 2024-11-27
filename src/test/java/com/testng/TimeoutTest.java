package com.testng;

import org.testng.annotations.Test;

public class TimeoutTest {

    @Test(invocationTimeOut = 2,expectedExceptions = NumberFormatException.class)
    public void sum(){
        int i=1;
        while (i==1){
            System.out.println(i);
        }
    }
}
