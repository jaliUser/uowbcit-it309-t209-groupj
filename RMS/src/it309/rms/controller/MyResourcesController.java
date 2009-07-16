/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.MyResourcesView;

/**
 *
 * @author khangdt
 */
public class MyResourcesController {
    
    private MyResourcesView view;
    
    public MyResourcesController(MyResourcesView view){
        this.view = view;
    }
    
    public void listMyResources(){
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
