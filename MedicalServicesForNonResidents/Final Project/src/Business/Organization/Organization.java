/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Hospital.DepartmentCatalog;
import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private PersonDirectory personDirectory;
    private UserAccountDirectory userAccountDirectory;
    private Organization.OrganizationType type;
    
    private int organizationID;
    private static int counter=0;
    
    
    public enum OrganizationType{
        TPHospitalOperation("TPHospitalOperation"),
        TPHospitalAppintmentScheduler("Appointment Scheduler Organization"),
        ConsumerOrganization("ConsumerOrganization"),
        EmbassyOrganization("EmbassyOrganization"),
        GovernmentOrganization("GovernmentOrganization");
        
        
        private String value;
        private OrganizationType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString(){
            return value;
        }
    }

    public OrganizationType getType() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type = type;
    }
    
    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        personDirectory = new PersonDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        
        ++counter;
    }

   

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

      
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
