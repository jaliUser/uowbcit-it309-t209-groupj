/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.EmployeeAddingView;

/**
 *
 * @author khangdt
 */
public class EmployeeAddingController {
    
    private EmployeeAddingView view;
    
    public EmployeeAddingController(EmployeeAddingView view){
        this.view = view;
    }
    
    public void addEmployee(){
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
