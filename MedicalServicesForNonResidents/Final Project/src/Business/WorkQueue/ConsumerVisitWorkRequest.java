/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Appointment.Appointment;

/**
 *
 * @author Rupam Tiwari
 */
public class ConsumerVisitWorkRequest extends WorkRequest{
    Appointment app;

    public Appointment getApp() {
        return app;
    }

    public void setApp(Appointment app) {
        this.app = app;
    }
    
}
