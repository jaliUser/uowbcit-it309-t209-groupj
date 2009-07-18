/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.SearchResourceView;

/**
 *
 * @author khangdt
 */
public class SearchResourceController {
    
    private SearchResourceView view;
    
    public SearchResourceController(SearchResourceView view){
        this.view = view;
    }
    
    public void searchResouces(){
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
