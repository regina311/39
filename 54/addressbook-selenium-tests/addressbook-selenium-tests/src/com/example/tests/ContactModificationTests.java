package com.example.tests;


import java.util.Random;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

import com.example.utils.SortedListOf;



public class ContactModificationTests extends TestBase{
	
	 @Test(dataProvider ="randomValidContactGenerator")
	  public void modifySomeContact(ContacnData contact) {
		
		
				app.navigateTo().mainPage();
				
				
				//save old state
				SortedListOf<ContacnData> oldList = app.getContactHelper().getContacts();
			    
			    Random rnd = new Random();
			    int index = rnd.nextInt(oldList.size() -1);
	//	app.getNavigationHelper().openMaimPage();
			    app.getContactHelper().modifyContacts(index, contact);
			    
		
	  
	  //save new state
			    SortedListOf<ContacnData> newList = app.getContactHelper().getContacts();
			    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));   
	  	    //compare states	    
	  	    oldList.remove(index);
	  	    oldList.add(contact);
	  	   
	  	    assertEquals(oldList, newList);
	  	}
	 }


