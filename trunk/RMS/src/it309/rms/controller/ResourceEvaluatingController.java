/*
 * This class is a class to receive the delegation of ResourceEvalutingView.
 * This class is responsible for processing application logic
 * and call funtions of business classes.
 */

package it309.rms.controller;

import it309.rms.view.ResourceEvalutingView;
import it309.rms.business.ResourceHelper;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.DataConstant;

/**
 *
 * @author khangdt
 */
public class ResourceEvaluatingController extends BaseController{
    
    private ResourceEvalutingView view;
    ResultInfo result;

    public ResourceEvaluatingController(ResourceEvalutingView view){
        super(view);
        this.view = view;
    }

    //Inititaion of View
    public void init(){
        try{
            ResourceInfo resourceInfo = new ResourceInfo();
            result = ResourceHelper.getInstance().getResourceById(view.getTxtResouceId(), resourceInfo);
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

    //Pass resource status to View for display
    private void setCboStatusValues(String status){
        view.removeAllCboStatusItems();
        if (status.equals(DataConstant.ResourceStatus.BOOKED)){
            view.setCboStatusValue(DataConstant.ResourceStatus.APPROVED);
            view.setCboStatusValue(DataConstant.ResourceStatus.DAMAGED);
            view.setCboStatusValue(DataConstant.ResourceStatus.MAINTAINANCE);
            view.setCboStatusValue(DataConstant.ResourceStatus.FUNCTIONING);
        }
        else
        {
            view.setCboStatusValue(DataConstant.ResourceStatus.MAINTAINANCE);
            view.setCboStatusValue(DataConstant.ResourceStatus.DAMAGED);
            view.setCboStatusValue(DataConstant.ResourceStatus.FUNCTIONING);
        }
    }

    //Pass resource information to View for display.
    private void showResourceInfo(ResourceInfo resourceInfo){
        view.setTxtResourceId(resourceInfo.getResourceId());
        view.setTxtResourceType(resourceInfo.getResourceType());
        view.setTxtResourceTitle(resourceInfo.getResourceTitle());
        view.setTxtDescription(resourceInfo.getDescription());

        setCboStatusValues(resourceInfo.getStatus());

        if (resourceInfo.getAuthorIdInfo() != null)
        {
            view.setTxtEmployeeId(resourceInfo.getAuthorIdInfo().getId());
            view.setTxtRequestingDate(resourceInfo.getDate_required().toString());
            view.setTxtReturnDate(resourceInfo.getDate_return().toString());
            view.setTxtEnteredDate(resourceInfo.getDate_entered().toString());
            view.setTxtPurpose(resourceInfo.getPurpose());
        }
        if (resourceInfo.getEvaluatorIdInfo() != null)
        {
            view.setTxtEvaluatorId(resourceInfo.getEvaluatorIdInfo().getId());
            view.setTxtLastEvaluation(resourceInfo.getDate_evaluated().toString());
            view.setTxtComment(resourceInfo.getComment());

        }
        
        view.setTxtPurpose(resourceInfo.getPurpose());
        view.setCboStatus(resourceInfo.getStatus());

        if(preView.getClass().getName().equals("it309.rms.view.MyResourcesView")){
            view.removeAllCboStatusItems();
            view.setCboStatusValue(resourceInfo.getStatus());
            view.setViewCase();
        }
    }

    //Get information of resource from View
    private ResourceInfo getResourceInfo(){
        ResourceInfo resourceInfo = new ResourceInfo();
        resourceInfo.setResourceId(view.getTxtResouceId());
        resourceInfo.setEvaluatorIdInfo(BaseController.getUserIdInfo());
        resourceInfo.setComment(view.getTxtComment());
        resourceInfo.setStatus(view.getCboStatus());
        

        return resourceInfo;
    }

    //Process of evaluation
    public void evaluate(){
        try {

            result = ResourceHelper.getInstance().Evaluate(getResourceInfo());
            if (result.getResult())
            {
                view.showInformMessage(DataConstant.Message.EVALUATED_RESOURCE);
                //Return the default screen
                view.setDefaultEmployeeComponent();
            }
            else
            {
                view.showMessage(result.getMessage(), result.getErrorType());
            }

        } catch (Exception e){
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
