/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ice4;

/**
 *
 * @author stezh
 */
public class ContactManager {
    private Contact[] contactList;

    public Contact[] getContactList() {
        return contactList;
    }

    public void setContactList(Contact[] contactList) {
        this.contactList = contactList;
    }

    /*
	Locate a Contact record that matches the email address provided.
	Returns the Contact record if found, null if not found.
    */
    public Contact findContact(String emailAddress){
        for (Contact contact : this.contactList) {
            if (contact != null && contact.getEmailAddress() == emailAddress) {
                return contact;
            }
        }
        return null;
    }

    /*
	 Removes all contacts
    */
    public void clearContacts(){
        this.contactList = new Contact[0];
    }
    // COMMENT!
}
