/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.business.ResourceHelper;
import it309.rms.dataclass.ResultInfo;
import it309.rms.view.ResourceBookingView;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.DataConstant;
import it309.rms.view.SearchResourceView;
/**
 *
 * @author khangdt
 */
public class ResourceBookingController extends BaseController{
    
    private ResourceBookingView view;
    ResultInfo result;

    public ResourceBookingController(ResourceBookingView view){
        this.view = view;
    }


    public void init(){
        try{
            ResourceInfo resourceInfo = new ResourceInfo();
            result = ResourceHelper.getInstance().getResourceById(view.getTxtId(), resourceInfo);
            if (result.getResult())
            {
                showResourceInfo(resourceInfo);
            }
            else
            {
                view.showMessage(result.getMessage(), result.getErrorType());
                //view.setDefaultEmployeeComponent();
            }
        }
        catch (Exception e)
        {
             view.showErrorMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
             view.setDefaultEmployeeComponent();
        }
    }

    private void showResourceInfo(ResourceInfo resourceInfo){
        view.setTxtId(resourceInfo.getResourceId());
        view.setTxtType(resourceInfo.getResourceType());
        view.setTxtTitle(resourceInfo.getResourceTitle());
        view.setTxtDescription(resourceInfo.getDescription());
    }

    private ResourceInfo getResourceInfo(){
        ResourceInfo resourceInfo = new ResourceInfo();
        resourceInfo.setResourceId(view.getTxtId());
        resourceInfo.setAuthorIdInfo(BaseController.getUserIdInfo());

        resourceInfo.setDate_required(java.sql.Date.valueOf(view.getTxtRequestingDate()));
        resourceInfo.setDate_return(java.sql.Date.valueOf(view.getTxtReturnDate()));
        resourceInfo.setPurpose(view.getTxtPurpose());
        
        return resourceInfo;
    }
    
    public void book(){
        try {

            if (isValid())
            {
                result = ResourceHelper.getInstance().book(getResourceInfo());
                if (result.getResult())
                {
                    view.showInformMessage(DataConstant.Message.BOOKED_RESOUCE);
                    //Return the default screen
                    view.setComponent(new SearchResourceView());
                }
                else
                {
                    view.showMessage(result.getMessage(), result.getErrorType());
                }
            }

        } catch (Exception e){
            view.showErrorMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
        }
    }

    public void back(){
        view.setComponent(preView);
    }

    public boolean isValid()
    {
        //result = Validator.checkEmpty(paramList);
        return true;
    }
}
