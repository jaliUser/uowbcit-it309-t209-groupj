/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.EmployeePasswordChangingView;

/**
 *
 * @author khangdt
 */
public class EmployeePasswordChangingController {
    
    private EmployeePasswordChangingView view;
    
    public EmployeePasswordChangingController(EmployeePasswordChangingView view){
        this.view = view;
    }
    
    public void changeEmployeePassword(){
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
