/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.ice4.Contact;
import com.mycompany.ice4.ContactManager;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author stezh
 */
public class Test1 {

    Contact[] testArray;
    Contact testContact1;
    Contact testContact2;
    Contact testContact3;
    Contact testContact4;
    ContactManager testManager;

    public Test1() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    // Sets up a prepopulated Contact Array for a ContactManager.
    @BeforeEach
    public void setUp() {
        this.testContact1 = new Contact();
        this.testContact1.setFirstName("C1 First Name");
        this.testContact1.setLastName("C1 Last Name");
        this.testContact1.setEmailAddress("C1 Email");

        this.testContact2 = new Contact();
        this.testContact2.setFirstName("C2 First Name");
        this.testContact2.setLastName("C2 Last Name");
        this.testContact2.setEmailAddress("C2 Email");

        this.testContact3 = new Contact();
        this.testContact3.setFirstName("C3 First Name");
        this.testContact3.setLastName("C3 Last Name");
        this.testContact3.setEmailAddress("C3 Email");

        this.testContact4 = new Contact();
        this.testContact4.setFirstName("C4 First Name");
        this.testContact4.setLastName("C4 Last Name");
        this.testContact4.setEmailAddress("C4 Email");

        Contact[] testArray2 = {testContact1, testContact2, testContact3, testContact4};
        this.testArray = Arrays.copyOf(testArray2, testArray2.length);
        this.testManager = new ContactManager();
        this.testManager.setContactList(testArray);
    }

    @AfterEach
    public void tearDown() {
    }

    // We have a array of 4 Contact objects. Expected result: array with length = 0
    @Test
    public void testClearContacts() {
        this.testManager.clearContacts();

        int expected = 0;
        int result = this.testManager.getContactList().length;
        assertEquals(expected, result);
    }
    
    // Test Good : Found Contact has correct information
    // Array of 4 Contact Objects, check the first and last names. Expected result: C1 First Name, C2 Last Name
    @Test
    public void findContactCorrectName(){
        String expected = "C1 First Name C1 Last Name";
        Contact resultContact = this.testManager.findContact("C1 Email");
        String resultFirstName = resultContact.getFirstName();
        String resultLastName = resultContact.getLastName();
        String result = resultFirstName + " " + resultLastName;
        
        assertEquals(expected, result);
    }

    // Test Good : Search for a null Contact
    // Array of 4 Contact Objects. Look for null Object. Expected result: null;
    @Test
    public void findContactNull() {
        Contact expected = null;
        Contact result = this.testManager.findContact(null);

        assertEquals(expected, result);
    }

    // Test Boundary : Traverse empty list
    // We have a empty array of Contact objects in the ContactManager. Expected result: null
    @Test
    public void findContactEmptyTraverse() {
        this.testManager.setContactList(new Contact[0]);
        Contact expected = null;
        Contact result = this.testManager.findContact("C1 Email");

        assertEquals(expected, result);
    }

    // Test Bad : Look for Contact that does not exist
    // Array of 4 Contact Objects. Expected result: null
    @Test
    public void findContactNoExist() {
        Contact expected = null;
        Contact result = this.testManager.findContact("Non existant email");

        assertEquals(expected, result);
    }

    // Test Good : Look for a Contact that does exist
    // Array of 4 Contact Objects. Expected result: this.testContact3
    @Test
    public void findContactExists() {
        Contact expected = this.testContact3;
        Contact result = this.testManager.findContact("C3 Email");

        assertEquals(expected, result);
    }
    
    // Test Boundary : Test if we can reach the last item
    // Array of 4 Contact Objects, expected result: this.testContact4
    @Test
    public void findContactLastItem(){
        Contact expected = this.testManager.getContactList()[3]; // Last item in array
        Contact result = this.testManager.findContact("C4 Email");
        
        assertEquals(expected, result);
    }
    // Test Boundary : Test if we can reach the first item
    // Array of 4 Contact Objects, expected result: this.testContact1
    @Test
    public void findContactFirstItem(){
        Contact expected = this.testManager.getContactList()[0]; //First item in array 
        Contact result = this.testManager.findContact("C1 Email");
        
        assertEquals(expected, result);
    }
    
    // Test Good : If a element in the list is null can we still traverse to the end?
    // Array of length 4, 1 Contact is null. Expected: this.testContact4
    @Test
    public void findContactTraverseOverNull(){
        this.testManager.getContactList()[2] = null;
        
        Contact expected = this.testManager.getContactList()[3];
        Contact result = this.testManager.findContact("C4 Email");
        
        assertEquals(expected, result);
    }
    
    // Test Good : If a Contact has a email of null, can we still search for this?
    // Array of length 4, 1 Contact has email of null. Expected: null
    @Test
    public void findContactNullEmail(){
        this.testManager.getContactList()[2].setEmailAddress(null);
        String expected = null;
        String result = this.testManager.findContact(null).getEmailAddress();
        
        assertEquals(expected, result);
    }
}
