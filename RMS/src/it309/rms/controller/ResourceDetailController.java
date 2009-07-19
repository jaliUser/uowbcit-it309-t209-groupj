/*
 * This class is a class to receive the delegation of ResourceView.
 * This class is responsible for processing application logic
 * and call funtions of business classes.
 */

package it309.rms.controller;

import it309.rms.business.ResourceHelper;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.view.BaseView;
import it309.rms.view.ResourceView;

/**
 *
 * @author khangdt
 */
public class ResourceDetailController extends BaseController {
    
    private ResourceView view;
    private ResultInfo result;
    
    public ResourceDetailController(ResourceView view){
        this.view = view;
    }

    public ResourceDetailController(ResourceView view, BaseView preView){
        this.view = view;
        this.preView = preView;
    }

    //Initiation of View
    public void init(){
        viewResourceDetail();
    }

    //Pass resource detail to View for display.
    private void showResourceInfo(ResourceInfo resourceInfo){
        view.setTxtId(resourceInfo.getResourceId());
        view.setTxtType(resourceInfo.getResourceType());
        view.setTxtTitle(resourceInfo.getResourceTitle());
        view.setTxtDescription(resourceInfo.getDescription());
        view.setTxtStatus(resourceInfo.getStatus());
        view.setTxtComment(resourceInfo.getComment());
    }

    //Process of getting resource detail and display.
    private void viewResourceDetail(){
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

    //Show pre form
    public void back(){
        view.setComponent(preView);
    }
}
