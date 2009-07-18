/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.business.AdministratorHelper;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResultInfo;
import it309.rms.view.AdminPasswordChangingView;

/**
 *
 * @author khangdt
 */
public class AdminPasswordChangingController extends BaseController {

    private AdminPasswordChangingView view;
    private ResultInfo result;

    public AdminPasswordChangingController(AdminPasswordChangingView view){
        this.view = view;
    }

    public void changePassword(){
        try {
            
            if (isValid())
            {
                result = AdministratorHelper.getInstance().changePassword(getUserIdInfo(), view.getTxtNewPassword());
                if (result.getResult())
                {
                    view.showInformMessage(DataConstant.Message.CHANGED_PASSWORD);
                    //Return the default screen
                    view.setDefaultAdminComponent();
                }
                else
                {
                    view.showMessage(result.getMessage(), result.getErrorType());
                }
            }
        } catch (Exception e){
            view.showErrorMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
            view.setDefaultAdminComponent();
        }
    }

    private boolean isValid()
    {
        return true;
    }
}
