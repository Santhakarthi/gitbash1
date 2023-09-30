package com.hms.testng;

import org.testng.annotations.Test;

public class Dummy {
@Test()
public void createCustomer() {
	System.out.println("create customer");
	
}
@Test()
	public void modifyCustomer() {
		System.out.println("Modify customer");
}

	@Test(dependsOnMethods="modifyCustomer")
	public void deleteCustomer() {
		System.out.println("Delete customer");
	}
	
	
}
