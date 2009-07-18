/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.ResourceView;

/**
 *
 * @author khangdt
 */
public class ResourceDetailController {
    
    private ResourceView view;
    
    public ResourceDetailController(ResourceView view){
        this.view = view;
    }
    
    public void viewResourceDetail(){
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
