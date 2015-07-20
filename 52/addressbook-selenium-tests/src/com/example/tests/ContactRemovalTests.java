package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;




import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTests extends TestBase {
	@Test
	 
	public void deleteSomeContact() {
		 app.navigateTo().mainPage();
		//save old state
		 SortedListOf<ContacnData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() -1);
		app.getContactHelper().deleteContact(index);
		
		SortedListOf<ContacnData> newList = app.getContactHelper().getContacts();
	  	    //compare states
		assertThat(newList, equalTo(oldList.without(index)));
		
	  	   
}
}
