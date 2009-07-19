/*
 * This class is a class to receive the delegation of ResourceBookingView.
 * This class is responsible for processing application logic
 * and call funtions of business classes.
 */

package it309.rms.controller;

import it309.rms.business.ResourceHelper;
import it309.rms.dataclass.ResultInfo;
import it309.rms.view.ResourceBookingView;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.DataConstant;
import it309.rms.util.Validator;
import it309.rms.view.SearchResourceView;
import java.util.Hashtable;
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

    //Initiation of View
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

    //Pass resource information to View for display
    private void showResourceInfo(ResourceInfo resourceInfo){
        view.setTxtId(resourceInfo.getResourceId());
        view.setTxtType(resourceInfo.getResourceType());
        view.setTxtTitle(resourceInfo.getResourceTitle());
        view.setTxtDescription(resourceInfo.getDescription());
    }

    //Get booking information from View
    private ResourceInfo getResourceInfo(){
        ResourceInfo resourceInfo = new ResourceInfo();
        resourceInfo.setResourceId(view.getTxtId());
        resourceInfo.setAuthorIdInfo(BaseController.getUserIdInfo());

        resourceInfo.setDate_required(java.sql.Date.valueOf(view.getTxtRequestingDate()));
        resourceInfo.setDate_return(java.sql.Date.valueOf(view.getTxtReturnDate()));
        resourceInfo.setPurpose(view.getTxtPurpose());
        
        return resourceInfo;
    }

    //Process of resource booking
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

    //Show pre form
    public void back(){
        view.setComponent(preView);
    }

    //Validate inputted data
    private boolean isValid()
    {
        Hashtable ht = new Hashtable();
        ht.put(DataConstant.FieldName.REQUESTING_DATE, view.getTxtRequestingDate());
        ht.put(DataConstant.FieldName.RETURN_DATE, view.getTxtReturnDate());
        ht.put(DataConstant.FieldName.PURPOSE, view.getTxtPurpose());

        result = Validator.checkEmpty(ht);

        if (result.getResult())
        {
            result = Validator.checkDateFormat(view.getTxtRequestingDate());

            if (result.getResult()) result = Validator.checkDateFormat(view.getTxtReturnDate());

        }

        if (!result.getResult()){
            view.showWarningMessage(result.getMessage());
            return false;
        }

        return true;
    }
}
