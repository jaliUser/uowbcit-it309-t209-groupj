/*
 * This class is a class to receive the delegation of SearchEmployeeView.
 * This class is responsible for processing application logic
 * and call funtions of business classes.
 */

package it309.rms.controller;

import it309.rms.business.EmployeeHelper;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;
import it309.rms.util.Util;
import it309.rms.view.EmployeeUpdatingView;
import it309.rms.view.SearchEmployeeView;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author khangdt
 */
public class SearchEmployeeController extends BaseController {
    
    private SearchEmployeeView view;
    private ResultInfo result;

    private static String searchField;
    private static String searchCondition;
    
    public SearchEmployeeController(SearchEmployeeView view){
        this.view = view;
    }

    //Initiation of View.
    public void init()
    {
        if (!(Util.isNullOrEmpty(searchField) && Util.isNullOrEmpty(searchCondition)))
        {
            setPreSearchCondition();
            searchEmployee();
        }
    }

    //Process of search employee
    public void searchEmployee(){
        try{
            //Save search condition
            searchField = view.getCboSearch();
            searchCondition = view.getTxtSearch();

            Collection list = new LinkedList();
            result = EmployeeHelper.getInstance().search(getSearchFieldCondition(), view.getTxtSearch(), list);

            if (result.getResult())
            {
                showSearchResult(list);
            }
            else
            {
                view.showMessage(result.getMessage(), result.getErrorType());
            }
        }
        catch (Exception e)
        {
             view.showErrorMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
             view.setDefaultEmployeeComponent();
        }
    }

    //Show form for editing employee
    public void editEmployee(){
        if (isValid())
        {
            EmployeeUpdatingView employeeUpdatingView =
                    new EmployeeUpdatingView(DataConstant.EmployeeAction.EDIT, view.selectedId(), view);
            view.setComponent(employeeUpdatingView);
        }
    }

    //Process of deleting employee
    public void deleteEmployee(){
        try{
            if (isValid())
            {

                result = EmployeeHelper.getInstance().delete(new UserIdInfo(view.selectedId(),""));

                if (!result.getResult())
                {
                    view.showMessage(result.getMessage(), result.getErrorType());
                }
                else
                {
                    view.showInformMessage(DataConstant.Message.DETELETED_EMPLOYEE);
                }
                searchEmployee();
            }
        }
        catch (Exception e)
        {
             view.showErrorMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
             view.setDefaultAdminComponent();
        }
    }

    //Get search field condition base on the object selected by user.
    private String getSearchFieldCondition()
    {
        if (view.getCboSearch().equals("Id"))
        {
            return DataConstant.Entity.ID;
        }
        else
        {
            return DataConstant.Entity.NAME;
        }
    }

    //Pass pre-search condition to view.
    private void setPreSearchCondition()
    {
        view.setCboSearch(searchField);
        view.setTxtSearch(searchCondition);
    }

    //Pass result list to view for display.
    private void showSearchResult(Collection list){
        view.setTableResources(list);
    }

    //Validate data inputted
    private boolean isValid(){
        if(Util.isNullOrEmpty(view.selectedId()))
        {
            view.showInformMessage(DataConstant.Message.NO_OBJECT_SELECTED);
            return false;

        }
        return true;
    }
}
