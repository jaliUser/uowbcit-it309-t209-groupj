/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.ResourceEvalutingView;

/**
 *
 * @author khangdt
 */
public class ResourceEvaluatingController {
    
    private ResourceEvalutingView view;
    
    public ResourceEvaluatingController(ResourceEvalutingView view){
        this.view = view;
    }
    
    public void evaluateResource(){
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
