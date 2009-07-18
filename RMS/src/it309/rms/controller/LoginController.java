/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.LoginView;

/**
 *
 * @author khangdt
 */
public class LoginController {
    
    private LoginView view;
    
    public LoginController(LoginView view){
        this.view = view;
    }
    
    public void login(){
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
