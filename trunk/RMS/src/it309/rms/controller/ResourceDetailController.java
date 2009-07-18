/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.business.ResourceHelper;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.view.BaseView;
import it309.rms.view.ResourceView;
import it309.rms.view.SearchResourceView;

/**
 *
 * @author khangdt
 */
public class ResourceDetailController {
    
    private ResourceView view;
    private ResultInfo result;
    private BaseView preView;
    
    public ResourceDetailController(ResourceView view){
        this.view = view;
    }

    public ResourceDetailController(ResourceView view, BaseView preView){
        this.view = view;
        this.preView = preView;
    }
    
    public void init(){
        viewResourceDetail();
    }

    private void showResourceInfo(ResourceInfo resourceInfo){
        view.setTxtId(resourceInfo.getResourceId());
        view.setTxtType(resourceInfo.getResourceType());
        view.setTxtTitle(resourceInfo.getResourceTitle());
        view.setTxtDescription(resourceInfo.getDescription());
        view.setTxtStatus(resourceInfo.getStatus());
    }

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

    public void back(){
        view.setComponent(preView);
    }
}
