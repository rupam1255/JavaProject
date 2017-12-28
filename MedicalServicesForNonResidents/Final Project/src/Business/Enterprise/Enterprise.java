/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author Rupam Tiwari
 */
public abstract class Enterprise extends Organization{
    private OrganizationDirectory organizationDirectory;
    private Enterprise.TypeOfEnterprise typeOfEnterprise;

    public Enterprise() {
        super(null);
        this.organizationDirectory = new OrganizationDirectory();
    }

    public enum TypeOfEnterprise {

        HospitalEnterprise("Hospital Enterprise"),
        ConsumerEnterprise("Consumer Enterprise"),
        GovernmentEnterprise("Government Enterprise");

        private String value;

        private TypeOfEnterprise(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public TypeOfEnterprise getTypeOfEnterprise() {
        return typeOfEnterprise;
    }

    public void setTypeOfEnterprise(TypeOfEnterprise typeOfEnterprise) {
        this.typeOfEnterprise = typeOfEnterprise;
    }
    
    
}
