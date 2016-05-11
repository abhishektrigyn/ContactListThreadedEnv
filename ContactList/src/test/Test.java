package test;

import java.util.List;

import ServiceImpl.ServiceImpl;
import pojo.Contact;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Contact contact1 =  new Contact();
		contact1.setId(1);
		contact1.setName("abhishek");
		contact1.setPhone("1234567");
		contact1.setAddress("paris");

		Contact contact2=  new Contact();
		contact2.setId(2);
		contact2.setName("Prashant");
		contact2.setPhone("9872");
		contact2.setAddress("Munich");

		Contact contact3=  new Contact();
		contact3.setId(3);
		contact3.setName("Patel");
		contact3.setPhone("66846422");
		contact3.setAddress("Toulouse");

		ServiceImpl service = new ServiceImpl();
		service.addContact(contact1);
		service.addContact(contact2);
		service.addContact(contact3);


		Contact contact4=  new Contact();
		contact4.setId(2);
		contact4.setName("Prashant");
		contact4.setPhone("92882277");
		contact4.setAddress("Barca");
		service.modifyContact(contact4);


		service.removeContact(contact3);

		Contact contact5=  new Contact();
		contact5.setId(2);
		contact5.setName("Grish");
		contact5.setPhone("666666");
		contact5.setAddress("Mumbai");
		service.addContact(contact5);
		List<Contact> tmpList=service.searchAnything("Prashant");
		tmpList=service.searchAnything("Aris");
        tmpList = service.searchAnything("882");
	}




}
