/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.EmployeeProfileChangingView;

/**
 *
 * @author khangdt
 */
public class EmployeeProfileChangingController {
    
    private EmployeeProfileChangingView view;
    
    public EmployeeProfileChangingController(EmployeeProfileChangingView view){
        this.view = view;
    }
    
    public void changeMyProfile(){
        try {
            //Todo: call business function
            
            view.showInformMessage("Success.");
            
            //Return the default screen
            view.setDefaultAdminComponent();
        } catch (Exception ex){
            view.showErrorMessage(ex.getMessage());
        }
    }
}
