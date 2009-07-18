/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.business.EmployeeHelper;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.EmployeeInfo;
import it309.rms.view.EmployeeProfileChangingView;

/**
 *
 * @author khangdt
 */
public class EmployeeProfileChangingController extends BaseController{
    
    private EmployeeProfileChangingView view;
    private ResultInfo result;
    
    public EmployeeProfileChangingController(EmployeeProfileChangingView view){
        this.view = view;
    }

    public void init(){
        showMyProfile();
    }
    
    public void changeMyProfile(){
        try {

            if (isValid())
             {
                result = result = EmployeeHelper.getInstance().update(getEmployeeInfo());
                if (result.getResult())
                {
                    view.showInformMessage(DataConstant.Message.UPDATED_EMPLOYEE);
                    //Return the default screen
                    //view.setDefaultAdminComponent();
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

    public boolean isValid()
    {
        //result = Validator.checkEmpty(paramList);
        return true;
    }

    private EmployeeInfo getEmployeeInfo()
    {
        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setId(view.getTxtId());
        employeeInfo.setPassword(getUserIdInfo().getPassword());
        employeeInfo.setName(view.getTxtName());
        employeeInfo.setAdress(view.getTxtAddress());
        employeeInfo.setEmail(view.getTxtEmail());
        employeeInfo.setTitle(view.getTxtTitle());
        employeeInfo.setPhone(view.getTxtPhone());

        return employeeInfo;
    }

    private void showEmployeeInfo(EmployeeInfo employeeInfo)
    {
        view.setTxtId(getUserIdInfo().getId());
        view.setTxtName(getUserIdInfo().getPassword());
        view.setTxtTitle(employeeInfo.getTitle());
        view.setTxtEmail(employeeInfo.getEmail());
        view.setTxtAddress(employeeInfo.getAdress());
        view.setTxtPhone(employeeInfo.getPhone());
    }

    private void showMyProfile(){
        try{

            EmployeeInfo employeeInfo = new EmployeeInfo();
            result = EmployeeHelper.getInstance().getEmployeeById(getUserIdInfo().getId(), employeeInfo);
            if (result.getResult())
            {
                showEmployeeInfo(employeeInfo);
            }
            else
            {
                view.showMessage(result.getMessage(), result.getErrorType());
                //view.setDefaultAdminComponent();
            }
        }
        catch (Exception e)
        {
             view.showErrorMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
             view.setDefaultAdminComponent();
        }
    }
}
