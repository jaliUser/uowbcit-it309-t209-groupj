/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.business.EmployeeHelper;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.EmployeeInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.view.BaseView;
import it309.rms.view.EmployeeUpdatingView;

/**
 *
 * @author khangdt
 */
public class EmployeeUpdatingController extends BaseController {
    
    private EmployeeUpdatingView view;
    private ResultInfo result;

    private BaseView preView;

    public void setPreView(BaseView preView) {
        this.preView = preView;
    }

    
    public EmployeeUpdatingController(EmployeeUpdatingView view){
        this.view = view;
    }

    public void initEditingView(){
        try{
            EmployeeInfo employeeInfo = new EmployeeInfo();
            result = EmployeeHelper.getInstance().getEmployeeById(view.getTxtId(), employeeInfo);
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

    public void addEmployee(){
        try {

            if (isValid())
            {
                result = EmployeeHelper.getInstance().Add(getEmployeeInfo());
                if (result.getResult())
                {
                    view.showInformMessage(DataConstant.Message.ADDED_EMPLOYEE);
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

    public void editEmployee(){
        try {

            if (isValid())
             {
                result = result = EmployeeHelper.getInstance().update(getEmployeeInfo());
                if (result.getResult())
                {
                    view.showInformMessage(DataConstant.Message.UPDATED_EMPLOYEE);
                    //Return the default screen
                    this.back();
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
        employeeInfo.setName(view.getTxtName());
        employeeInfo.setPassword(view.getTxtPassword());
        employeeInfo.setAdress(view.getTxtAddress());
        employeeInfo.setEmail(view.getTxtEmail());
        employeeInfo.setTitle(view.getTxtTitle());
        employeeInfo.setPhone(view.getTxtPhone());

        return employeeInfo;
    }
    
    private void showEmployeeInfo(EmployeeInfo employeeInfo)
    {
        view.setTxtId(employeeInfo.getId());
        view.setTxtPassword(employeeInfo.getPassword());
        view.setTxtName(employeeInfo.getName());
        view.setTxtTitle(employeeInfo.getTitle());
        view.setTxtEmail(employeeInfo.getEmail());
        view.setTxtAddress(employeeInfo.getAdress());
        view.setTxtPhone(employeeInfo.getPhone());
    }

    public void back(){
        view.setComponent(preView);
    }
}
