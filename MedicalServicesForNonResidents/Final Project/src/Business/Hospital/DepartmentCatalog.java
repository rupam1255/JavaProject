/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.Hospital.Department.CareType;
import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */
public class DepartmentCatalog {
    private ArrayList<Department> depatmentList;

    public DepartmentCatalog() {
        this.depatmentList = new ArrayList();
    }

    public ArrayList<Department> getDepatmentList() {
        return depatmentList;
    }

    public void setDepatmentList(ArrayList<Department> depatmentList) {
        this.depatmentList = depatmentList;
    }
    
    public Department createDepartment(String name,CareType type){
        Department d = new Department(name);
        d.setCareType(type);
        depatmentList.add(d);
        return d;
               
    }
    
    
}
