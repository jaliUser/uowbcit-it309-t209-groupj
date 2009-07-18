/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import it309.rms.business.ResourceHelper;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.util.Util;
import it309.rms.view.BaseView;
import it309.rms.view.MyResourcesView;
import it309.rms.view.ResourceView;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author khangdt
 */
public class MyResourcesController extends BaseController{
    
    private MyResourcesView view;
    private ResultInfo result;
    
    public MyResourcesController(MyResourcesView view){
        this.view = view;
    }

    public void init()
    {
        listMyResources();
    }
    
    public void listMyResources(){
        try{
            Collection list = new LinkedList();
            result = ResourceHelper.getInstance().getMyResources(getUserIdInfo().getId(), list);

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

    public void cancelBooking(){
        try{
            if (isValid())
            {
                ResourceInfo resourceInfo = new ResourceInfo();
                resourceInfo.setResourceId(view.selectedId());
                resourceInfo.setAuthorIdInfo(getUserIdInfo());

                result = ResourceHelper.getInstance().cancelBooking(resourceInfo);

                if (result.getResult())
                {
                    view.showInformMessage(DataConstant.Message.CANCELLED_BOOKING);
                }
                else
                {
                    view.showMessage(result.getMessage(), result.getErrorType());
                }
            }
        }
        catch (Exception e)
        {
             view.showErrorMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
        }
        
        listMyResources();
    }

    public void view(){
        if (isValid())
        {
            ResourceView resourceDetail = new ResourceView(view.selectedId(), view);
            view.setComponent(resourceDetail);
        }
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
