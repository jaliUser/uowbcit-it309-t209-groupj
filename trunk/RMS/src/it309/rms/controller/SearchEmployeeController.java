/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import com.sun.org.apache.bcel.internal.generic.Select;
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

    public void init()
    {
        if (!(Util.isNullOrEmpty(searchField) && Util.isNullOrEmpty(searchCondition)))
        {
            setPreSearchCondition();
            searchEmployee();
        }
    }
    
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

    public void editEmployee(){
        if (isValid())
        {
            EmployeeUpdatingView employeeUpdatingView =
                    new EmployeeUpdatingView(DataConstant.EmployeeAction.EDIT, view.selectedId(), view);
            view.setComponent(employeeUpdatingView);
        }
    }

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

    private void setPreSearchCondition()
    {
        view.setCboSearch(searchField);
        view.setTxtSearch(searchCondition);
    }
    
    private void showSearchResult(Collection list){
        view.setTableResources(list);
    }

    private boolean isValid(){
        if(Util.isNullOrEmpty(view.selectedId()))
        {
            view.showInformMessage(DataConstant.Message.NO_OBJECT_SELECTED);
            return false;

        }
        return true;
    }
}
