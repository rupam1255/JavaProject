package Business;

import Business.Appointment.MasterAppointmentCatelog;
import Business.Enterprise.Enterprise;

import Business.Organization.Organization;
import Business.Network.Network;
import Business.Organization.ConsumerOrganization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */

public class EcoSystem extends Organization{
    
    private ArrayList<Disease> DiseaseCatalog;
    
    private MasterAppointmentCatelog mac;
    private ArrayList<Network> networkDirectory;
    private static EcoSystem system=null;
    
    private EcoSystem(){
        super("EcoSystem");
        networkDirectory=new ArrayList();
        DiseaseCatalog=new ArrayList();
        mac=new MasterAppointmentCatelog();
    }
    
     
    public static EcoSystem getInstance() {
       
        if(system==null){
            system=new EcoSystem();
        }
        
        return system;
    }

    
    public ArrayList<Network> getNetworkDirectory() {
        return networkDirectory;
    }

    public void setNetworkDirectory(ArrayList<Network> NetworkDirectory) {
        this.networkDirectory = NetworkDirectory;
    }  
    
    public Network createAndAddNetwork(String name,String state) {
        Network network = new Network(name,state);
        networkDirectory.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public Boolean removeNetwork(String networkName) {
         for (Network network : networkDirectory) {
            if (network.getName().equals(networkName)) {
                networkDirectory.remove(network);
                return true;
            }
        }
        return null;
    }
    public Network getNetworkInstance(String networkName) {
        for (Network network : networkDirectory) {
            if (network.getName().equals(networkName)) {
                return network;
            }
        }
        return null;
    }

    public ArrayList<Disease> getDiseaseCatalog() {
        return DiseaseCatalog;
    }

    public void setDiseaseCatalog(ArrayList<Disease> DiseaseCatalog) {
        this.DiseaseCatalog = DiseaseCatalog;
    }

    public MasterAppointmentCatelog getMac() {
        return mac;
    }

    public void setMac(MasterAppointmentCatelog mac) {
        this.mac = mac;
    }
    
    public ConsumerOrganization getConsumerOrgInstance(){
        ConsumerOrganization corg=null;
         boolean flag=false;
        for(Network n:this.getNetworkDirectory()){
            for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization org:e.getOrganizationDirectory().getOrganizationList()){
                    if(org instanceof ConsumerOrganization){
                        corg=(ConsumerOrganization) org;
                        flag=true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
            if(flag)
                break;
        }
        return corg;
    }
    
    public void removeDisease(Disease disease) {
        disease.setName(null);
        DiseaseCatalog.remove(disease);
    }
    
}
 
