/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.SearchEmployeeView;

/**
 *
 * @author khangdt
 */
public class SearchEmployeeController {
    
    private SearchEmployeeView view;
    
    public SearchEmployeeController(SearchEmployeeView view){
        this.view = view;
    }
    
    public void searchEmployee(){
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
