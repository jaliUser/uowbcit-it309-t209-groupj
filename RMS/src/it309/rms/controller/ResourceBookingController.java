/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.ResourceBookingView;

/**
 *
 * @author khangdt
 */
public class ResourceBookingController {
    
    private ResourceBookingView view;
    
    public ResourceBookingController(ResourceBookingView view){
        this.view = view;
    }
    
    public void bookResource(){
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
