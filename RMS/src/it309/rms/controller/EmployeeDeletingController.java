/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.EmployeeDeletingView;

/**
 *
 * @author khangdt
 */
public class EmployeeDeletingController {
    
    private EmployeeDeletingView view;
    
    public EmployeeDeletingController(EmployeeDeletingView view){
        this.view = view;
    }
    
    public void deleteEmployee(){
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
