/*
 * This class is a class to receive the delegation of MyResourcesView.
 * This class is responsible for processing application logic
 * and call funtions of business classes.
 */

package it309.rms.controller;

import it309.rms.business.ResourceHelper;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.util.Util;
import it309.rms.view.MyResourcesView;
import it309.rms.view.ResourceEvalutingView;
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

    //Initiation of View
    public void init()
    {
        listMyResources();
    }

    //Process of getting resources
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

    //Process of booking cancellation
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

    //Show resource detail form
    public void view(){
        if (isValid())
        {
            ResourceEvalutingView resourceDetail = new ResourceEvalutingView(view.selectedId(), view);
            view.setComponent(resourceDetail);
        }
    }

    //Pass search result to View for display
    private void showSearchResult(Collection list){
        view.setTableResources(list);
    }

    //Validate inputted data
    private boolean isValid(){
        if(Util.isNullOrEmpty(view.selectedId()))
        {
            view.showInformMessage(DataConstant.Message.NO_OBJECT_SELECTED);
            return false;

        }
        return true;
    }
}
