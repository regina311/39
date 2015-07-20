package com.example.tests;






import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.SortedListOf;

import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;





public class ContactsCreationTests extends TestBase {
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
	return wrapContactDataForProvider(loadContactsFromXmlFile(new File( "contact.xml"))).iterator();
		
	}
		
	



@Test(dataProvider ="contactFromFile")
  public void testNonEmptyContactCreation(ContacnData contact ) throws Exception {
	//app.navigateTo().mainPage();

	ContactHelper contactHelper = app.getContactHelper();
	SortedListOf<ContacnData> oldList = contactHelper.getContacts();
	
	//ContacnData contact1 = new ContacnData();
	contact.fname = "Regina";
	contact.lname = "gizatullina";
	contact.address1 = "Address 1";
	contact.hnumber = "123";
	contact.mnumber = "321";
	contact.wnumber = "456";
	contact.mail1 = "email1@mail.ru";
	contact.mail2 = "email2@mail.ru";
	contact.year = "1990";
	contact.address2 = "Address 2";
	contact.phonenumber = "987654321";
	app.getContactHelper().createContacts(contact);
	
	SortedListOf<ContacnData> newList = contactHelper.getContacts();
    
    //  assertEquals(newList.size(), oldList.size()+1);
	assertThat(newList, equalTo(oldList.withAdded(contact)));
	
      
  }
  
	
  
  //@Test
  public void testEmptyContactCreation() throws Exception {
	app.navigateTo().mainPage();
	app.getContactHelper().gotoContactsPage();
	app.getContactHelper().fillContactForm(new ContacnData("", "", "", "", "", "", "", "", "", "", ""), false);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnContactPage();
  }
  


}