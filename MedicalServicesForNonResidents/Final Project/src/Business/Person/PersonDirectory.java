/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */
public class PersonDirectory {

    private ArrayList<Person> personList;
    private static int id=1; 

    public PersonDirectory() {
        this.personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public Person addAndCreatePerson(String name) {
        for (Person person : personList) {
            if (person.getName().equalsIgnoreCase(name)) {
                return null;
            }
        }
        Person person = new Person(name);
        personList.add(person);
        
        return person;
    }
    public Person addAndCreateConsumer(String fname,String lName) {
        String name=fname+" "+lName;
        for (Person person : personList) {
            if (person.getName().equalsIgnoreCase(name)) {
                return null;
            }
        }
        Person person = new Consumer(fname,lName);
        Consumer c = (Consumer)person;
        c.setAccountID("ACC00"+id);
        id++;
        personList.add(person);
        
        return person;
    }
    public void removePerson(Person person) {
        personList.remove(person);
    }
       
    
}
