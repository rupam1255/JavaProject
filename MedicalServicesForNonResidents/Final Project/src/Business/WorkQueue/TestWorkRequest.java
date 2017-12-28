/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Appointment.Appointment;
import Business.Appointment.Test;

/**
 *
 * @author Rupam Tiwari
 */
public class TestWorkRequest extends WorkRequest {
     Appointment app;
     Test test;

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Appointment getApp() {
        return app;
    }

    public void setApp(Appointment app) {
        this.app = app;
    }
}
