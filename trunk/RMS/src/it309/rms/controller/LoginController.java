/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.business.AdministratorHelper;
import it309.rms.business.EmployeeHelper;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResultInfo;
import it309.rms.view.AdminMainView;
import it309.rms.view.EmployeeMainView;
import it309.rms.view.LoginView;
import it309.rms.view.MainView;

/**
 *
 * @author khangdt
 */
public class LoginController extends BaseController {
    
    private LoginView view;
    private ResultInfo result;

   
    public LoginController(LoginView view){
        this.view = view;
    }

    public void login(){
        try {
           getUserIdInfo().setId(view.getTxtUserId());
           getUserIdInfo().setPassword(view.getTxtPassword());

          
            switch(getUserIdInfo().getUserType())
            {
                case DataConstant.UserType.ADMIN_LOGIN:
                    result = AdministratorHelper.getInstance().Logon(getUserIdInfo());
                    if (result.getResult())
                    {
                        view.show(new AdminMainView());
                    }
                    break;
                case DataConstant.UserType.EMPLOYEE_LOGIN:
                    result = EmployeeHelper.getInstance().Logon(getUserIdInfo());
                    if (result.getResult())
                    {
                        view.show(new EmployeeMainView());
                    }
                    break;
            }

            if (!result.getResult())
            {
                view.showMessage(result.getMessage(), result.getErrorType());
            }
                   
        } catch (Exception e){
            view.showErrorMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
            view.show(new MainView());
        }
    }
}
