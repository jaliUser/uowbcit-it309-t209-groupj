/*
 * This class is a class to receive the delegation of EmployeeUpdatingView.
 * This class is responsible for processing application logic
 * and call funtions of business classes.
 */

package it309.rms.controller;

import it309.rms.business.EmployeeHelper;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.EmployeeInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.util.Validator;
import it309.rms.view.EmployeeUpdatingView;
import java.util.Hashtable;

/**
 *
 * @author khangdt
 */
public class EmployeeUpdatingController extends BaseController {
    
    private EmployeeUpdatingView view;
    private ResultInfo result;

    public EmployeeUpdatingController(EmployeeUpdatingView view){
        this.view = view;
    }

    //Initiation of employee editing view
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

    //Process of employee addition
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

    //Process of employee editing
    public void editEmployee(){
        try {

            if (isValid())
             {
                result = result = EmployeeHelper.getInstance().update(getEmployeeInfo());
                if (result.getResult())
                {
                    view.showInformMessage(DataConstant.Message.UPDATED_EMPLOYEE);
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

    //Validate inputted data
    private boolean isValid()
    {
        Hashtable ht = new Hashtable();
        ht.put(DataConstant.FieldName.EMPLOYEE_ID, view.getTxtId());
        ht.put(DataConstant.FieldName.EMPLOYEE_PASSWORD, view.getTxtPassword());
        ht.put(DataConstant.FieldName.EMPLOYEE_NAME, view.getTxtName());
        ht.put(DataConstant.FieldName.ADDRESS, view.getTxtAddress());
        ht.put(DataConstant.FieldName.PHONE, view.getTxtPhone());
        ht.put(DataConstant.FieldName.EMAIL, view.getTxtEmail());

        result = Validator.checkEmpty(ht);


        if (!result.getResult()){
            view.showWarningMessage(result.getMessage());
            return false;
        }

        return true;
    }

    //Get employee information from View
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

    //Pass employee information to View for display
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

    //Show pre form
    public void back(){
        view.setComponent(preView);
    }
}
