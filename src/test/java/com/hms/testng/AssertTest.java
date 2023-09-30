package com.hms.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest {
	
	@Test
public void A() {
	System.out.println("hi");
	Assert.fail();
}
@Test
public void B() {
	System.out.println("hello");
}
@Test(dependsOnMethods="A",alwaysRun=true)
public void c() {
	System.out.println("Bye");
}

}
