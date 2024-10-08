package org.example.mobile;

import java.util.List;

public class MobilePhone {

    private String myNumber;
    private List<Contact> myContacts;

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public boolean addNewContact(Contact contact){
        if (contact == null || contact.getName() == null || contact.getPhoneNumber()== null){
            return false;
        }
        if (findContact(contact.getName()) >= 0 ){
            return false;
        }

            return this.myContacts.add(contact);
    }

    public boolean updateContact(Contact old, Contact now){

            int index = findContact(old);
            if(index <= 0){
                return false;
            }
            this.myContacts.set(index,now);
            return true;

    }

    public boolean removeContact(Contact contact){
        if (contact == null || findContact(contact) < 0){
            return false;
        }

        return this.myContacts.remove(contact);

    }

    public int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }


    public int findContact (String contact){
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact1 = myContacts.get(i);
            if (contact1.getName().equalsIgnoreCase(contact)){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String contactName){
        int contactIndex = findContact(contactName);
        if (contactIndex < 0){
            return null;
        }
        return this.myContacts.get(contactIndex);

    }

    public void printContact(){
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println((i+1) + ", " + contact.getName() + "->" + contact.getPhoneNumber());
        }
    }


}
