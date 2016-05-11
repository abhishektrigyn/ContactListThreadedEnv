package ServiceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import pojo.Contact;
import IService.Iservice;

public class ServiceImpl implements Iservice{

	List<Contact> tempList;
	List<Contact> searchList;
	public ServiceImpl() {
		tempList  = Collections.synchronizedList(new ArrayList<Contact>());
		searchList = Collections.synchronizedList(new ArrayList<Contact>());
	}

	@Override
	public boolean addContact(Contact contact) {
		// TODO Auto-generated method stub

		List<Contact>contactList = this.tempList;

		synchronized (contactList) {
			int newId=contact.getId();
			Iterator<Contact> contactItr=contactList.iterator();
			int i = 0;
			Contact innerContact =null;
			while(contactItr.hasNext())
			{
				innerContact = contactItr.next();
				if(newId==innerContact.getId())
				{
					System.out.println("Duplicated Id  "+contact);
					System.out.println("Cannot add Id  "+newId);
					System.out.println();
					return false;
				}
				else
				{
					if(i==contactList.size()-1)
					{
						contactList.add(contact);
						this.tempList = contactList;
						System.out.println("Contact added "+contact);
						System.out.println();
						return true;

					}
				}
				i++;

			}
			if(contactList.size()==0)
			{
				this.tempList.add(contact);
				System.out.println("Contact Added "+contact);
				System.out.println();
				return true;

			}
			return false;
		}

	}

	@Override
	public boolean modifyContact(Contact contact) {
		List<Contact> contactList = this.tempList;
		synchronized (contactList) {
			Iterator<Contact> contactItr=contactList.iterator();
			int newId=contact.getId();
			boolean foundContact=false;
			int position=0; 	        
			Contact innerContact=null;
			while(contactItr.hasNext())
			{
				innerContact=contactItr.next();
				if(newId==innerContact.getId())
				{

					foundContact=true;
					break;
				}

				position++;
			}
			if(foundContact)
			{
				this.tempList.set(position, contact);
				System.out.println("Contact Updated "+contact);
				System.out.println();

			}
			return foundContact;
		}

	}

	@Override
	public boolean removeContact(Contact contact) {
		List<Contact> contactList = this.tempList;
		synchronized (contactList) {
			Iterator<Contact> contactItr=contactList.iterator();
			int newId=contact.getId();
			boolean contactFound=false;
			int position=0;
			Contact innerContact=null;
			while(contactItr.hasNext())
			{
				innerContact = contactItr.next();
				if(newId==innerContact.getId())
				{

					contactFound=true;
					break;

				}
				position++;
			}
			if(contactFound)
			{
				this.tempList.remove(position);
				System.out.println("Contact Removed "+contact);
				System.out.println();

			}
			return contactFound;
		}

	}

	@Override
	public List<Contact> searchAnything(String searchString) {
		// TODO Auto-generated method stub
		List<Contact> contactList = this.tempList;
		synchronized (contactList) {
			this.searchList.clear();
			Iterator<Contact> contactItr=contactList.iterator();

			while(contactItr.hasNext())
			{
				Contact contact = contactItr.next();
				String name = contact.getName().toLowerCase();
				boolean nameFound=false;
				String phone = contact.getPhone().toLowerCase();
				boolean phoneFound=false;
				String address  = contact.getAddress().toLowerCase();
				boolean addressFound =false;
				if(name.contains(searchString.toLowerCase()))
				{
					nameFound=true;
				}
				if(phone.contains(searchString.toLowerCase()))
				{
					phoneFound=true;
				}
				if(address.contains(searchString.toLowerCase()))
				{
					addressFound = true;
				}
				if(nameFound||phoneFound||addressFound)
				{
					this.searchList.add(contact);
					System.out.println("Search string "+ searchString +" ======= Search result "+contact);
					System.out.println();
				}

			}
			return this.searchList;
		}
	}
}
