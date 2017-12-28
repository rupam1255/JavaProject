/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Hospital.Doctor;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rupam Tiwari
 */
public class SlotRangeDirectory {
    private ArrayList<SlotRange> slotRangeList;
    private static long id=1;
    
    public SlotRangeDirectory(){
        slotRangeList=new ArrayList();
    }

    public ArrayList<SlotRange> getSlotRangeList() {
        return slotRangeList;
    }

    public void setSlotRangeList(ArrayList<SlotRange> slotRangeList) {
        this.slotRangeList = slotRangeList;
    }
    
    public SlotRange createAndAddSlot(Date inputDate1, Date inputDate2, Doctor doctor,String offer){
        boolean overlap=false;
        SlotRange slotRange=null;
        //check if input slot is having overlap with any existing slot for the same Doctor.
        for(SlotRange slot:slotRangeList){
            if(slot.getDoctor().equals(doctor))
            if(((inputDate2.getTime()>slot.getStartDt().getTime()) && (inputDate2.getTime()<=slot.getEndDt().getTime()))|| 
                 (inputDate1.getTime()<slot.getEndDt().getTime() && inputDate1.getTime()>=slot.getStartDt().getTime())){
                overlap=true;
            }
        }
        //Add slot only if there is no overlap with existing slot
        if(!overlap){
            slotRange=new SlotRange(inputDate1,inputDate2,doctor);
            if(!"".equals(offer)){
                slotRange.setOffer(offer);
            }
            slotRange.setSlotRangeID("SLOT00"+String.valueOf(id));
            id++;
            slotRangeList.add(slotRange);
        }
        //Write a code in UI to check if overlap is false then show popup that slot has been added successfully
        return slotRange;
    }
}
