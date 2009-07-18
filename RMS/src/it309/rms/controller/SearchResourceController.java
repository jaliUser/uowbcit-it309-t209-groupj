/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.business.ResourceHelper;
import it309.rms.dataclass.ResultInfo;
import it309.rms.view.SearchResourceView;
import it309.rms.util.Util;
import java.util.Collection;
import it309.rms.dataclass.DataConstant;
import it309.rms.view.ResourceBookingView;
import it309.rms.view.ResourceEvalutingView;
import it309.rms.view.ResourceView;
import java.util.LinkedList;


/**
 *
 * @author khangdt
 */
public class SearchResourceController {
    
    private SearchResourceView view;
    private ResultInfo  result;

    private static String searchField;
    private static String searchCondition;
    
    public SearchResourceController(SearchResourceView view){
        this.view = view;
    }
    
    public void init()
    {
        if (!(Util.isNullOrEmpty(searchField) && Util.isNullOrEmpty(searchCondition)))
        {
            setPreSearchCondition();
            search();
        }
    }

    public void search(){
        try{
            //Save search condition
            searchField = view.getCboSearch();
            searchCondition = view.getTxtSearch();


            Collection list = new LinkedList();
            result = ResourceHelper.getInstance().searchByTextField(getSearchFieldCondition(), view.getTxtSearch(), list);
            
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

    public void book(){
        if (isValid())
        {
            ResourceBookingView bookingView = new ResourceBookingView(view.selectedId(), view);
            view.setComponent(bookingView);
        }
    }

    public void evaluate(){
        if (isValid())
        {
            ResourceEvalutingView evaluatingView = new ResourceEvalutingView(view.selectedId(), view);
            view.setComponent(evaluatingView);
        }
    }

    public void view(){
        if (isValid())
        {
            ResourceView resourceDetail = new ResourceView(view.selectedId(), view);
            view.setComponent(resourceDetail);
        }
    }

    private String getSearchFieldCondition()
    {
        String field = DataConstant.Entity.ID;

        if (view.getCboSearch().equals("Title"))
        {
            field = DataConstant.Entity.TITLE;
        }
        else if (view.getCboSearch().equals("Type"))
        {
            field = DataConstant.Entity.TYPE;
        }
        else if (view.getCboSearch().equals("Status"))
        {
            field = DataConstant.Entity.STATUS;
        }
        
        return field;
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
