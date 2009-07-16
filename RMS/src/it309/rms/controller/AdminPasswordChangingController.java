/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.AdminPasswordChangingView;

/**
 *
 * @author khangdt
 */
public class AdminPasswordChangingController {

    private AdminPasswordChangingView view;

    public AdminPasswordChangingController(AdminPasswordChangingView view){
        this.view = view;
    }

    public void changePassword(){
        try {
            //Todo: call business function
            
            view.showInformMessage("Success");
            
            //Return the default screen
            view.setDefaultAdminComponent();
        } catch (Exception ex){
            view.showErrorMessage(ex.getMessage());
        }
    }
}
