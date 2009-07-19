/*
 * This class is a class to receive the delegation of AdminPasswordChangingView.
 * This class is responsible for processing application logic
 * and call funtions of business classes.
 */

package it309.rms.controller;

import it309.rms.business.AdministratorHelper;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResultInfo;
import it309.rms.util.Validator;
import it309.rms.view.AdminPasswordChangingView;
import java.util.Hashtable;

/**
 *
 * @author khangdt
 */
public class AdminPasswordChangingController extends BaseController {

    private AdminPasswordChangingView view;
    private ResultInfo result;

    public AdminPasswordChangingController(AdminPasswordChangingView view){
        this.view = view;
    }

    //Process of password change
    public void changePassword(){
        try {
            
            if (isValid())
            {
                result = AdministratorHelper.getInstance().changePassword(getUserIdInfo(), view.getTxtNewPassword());
                if (result.getResult())
                {
                    view.showInformMessage(DataConstant.Message.CHANGED_PASSWORD);
                    //Return the default screen
                    view.setDefaultAdminComponent();
                }
                else
                {
                    view.showMessage(result.getMessage(), result.getErrorType());
                }
            }
        } catch (Exception e){
            view.showErrorMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
            view.setDefaultAdminComponent();
        }
    }

    //Validate inputted data
    private boolean isValid()
    {
        Hashtable ht = new Hashtable();
        ht.put("Old Pasword", view.getTxtOldPassword());
        ht.put("New Password", view.getTxtNewPassword());
        ht.put("Confirm Password", view.getTxtConfirmPassword());

        result = Validator.checkEmpty(ht);

        if (result.getResult()){
            result = Validator.checkConfirmPassword(view.getTxtOldPassword(), view.getTxtConfirmPassword());
        }

        if (!result.getResult()){
            view.showWarningMessage(result.getMessage());
            return false;
        }
        
        return true;
    }
}
