package com.hms.PracticePacage;

import org.testng.annotations.Test;

public class PractiseTest {
@Test
public void createTest() {
	System.out.println("data created");
	
}
@Test(priority=0,invocationCount=2)
public void editTest() {
	System.out.println("data modification done");
}


@Test
public void deleteTest() {
	System.out.println("data deleted Successfully");
}
}
