package com.qa.testng.practice2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParallelExectionOfClasses2 {
	

	@BeforeMethod
    public void beforeMethod()
    {
        System.out.println("I am in beforeMetod - classTwo");
    }
     
    @Test
    public void testOne()
    {
        System.out.println("I am in testOne method - classTwo");
    }
     
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("I am in afterMetod - classTwo");
    }

}
