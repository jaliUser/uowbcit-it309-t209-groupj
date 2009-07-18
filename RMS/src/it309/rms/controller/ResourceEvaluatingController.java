/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.ResourceEvalutingView;
import it309.rms.business.ResourceHelper;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.DataConstant;
import it309.rms.view.SearchResourceView;

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

    private void showResourceInfo(ResourceInfo resourceInfo){
        view.setTxtResourceId(resourceInfo.getResourceId());
        view.setTxtResourceType(resourceInfo.getResourceType());
        view.setTxtResourceTitle(resourceInfo.getResourceTitle());
        view.setTxtDescription(resourceInfo.getDescription());
        if (resourceInfo.getAuthorIdInfo() != null)
        {
            view.setTxtEmployeeId(resourceInfo.getAuthorIdInfo().getId());
            view.setTxtRequestingDate(resourceInfo.getDate_required().toString());
            view.setTxtReturnDate(resourceInfo.getDate_return().toString());
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
        view.setCboStatusValue(resourceInfo.getStatus());
    }

    private ResourceInfo getResourceInfo(){
        ResourceInfo resourceInfo = new ResourceInfo();
        resourceInfo.setResourceId(view.getTxtResouceId());
        resourceInfo.setEvaluatorIdInfo(BaseController.getUserIdInfo());
        resourceInfo.setComment(view.getTxtComment());
        resourceInfo.setStatus(view.getCboStatus());
        

        return resourceInfo;
    }

    public void evaluate(){
        try {

            if (isValid())
            {
                result = ResourceHelper.getInstance().Evaluate(getResourceInfo());
                if (result.getResult())
                {
                    view.showInformMessage(DataConstant.Message.EVALUATED_RESOURCE);
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
            view.setDefaultEmployeeComponent();
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
