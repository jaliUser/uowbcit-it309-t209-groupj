/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.business.EmployeeHelper;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResultInfo;
import it309.rms.view.EmployeePasswordChangingView;

/**
 *
 * @author khangdt
 */
public class EmployeePasswordChangingController extends BaseController{
    
    private EmployeePasswordChangingView view;
    private ResultInfo result;
    
    public EmployeePasswordChangingController(EmployeePasswordChangingView view){
        this.view = view;
    }
    
    public void changePassword(){
        try {

            if (isValid())
            {
                result = EmployeeHelper.getInstance().changePassword(getUserIdInfo(), view.getTxtNewPassword());
                if (result.getResult())
                {
                    view.showInformMessage(DataConstant.Message.CHANGED_PASSWORD);
                    //Return the default screen
                    view.setDefaultEmployeeComponent();
                }
                else
                {
                    view.showMessage(result.getMessage(), result.getErrorType());
                }
            }
        } catch (Exception e){
            view.showErrorMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
            view.setDefaultEmployeeComponent();
        }
    }

    private boolean isValid()
    {
        return true;
    }
}
