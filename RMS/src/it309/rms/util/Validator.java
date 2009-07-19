/*
 * This method is used to validate user-input from views.
 */

package it309.rms.util;

import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResultInfo;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author khangdt
 */
public class Validator {

    //To check if values in Hashtable are empty.
    public static ResultInfo checkEmpty(Hashtable ht)
	{
        ResultInfo result = new ResultInfo();

        Enumeration e = ht.keys();

        while( e. hasMoreElements() ){
            Object obj = e.nextElement();
            if (Util.isNullOrEmpty(ht.get(obj))){
                result.setResult(false);
                result.setMessage(String.format(DataConstant.Message.REQUIRED_FIELD, obj));
            }
        }
                
		return result;
	}

    //To check if passwords match.
    public static ResultInfo checkConfirmPassword(String oldPassword, String confirmPassword){
        ResultInfo result = new ResultInfo();
        if(!oldPassword.equals(confirmPassword)){
            result.setResult(false);
            result.setMessage(DataConstant.Message.PASSWORDS_NOT_MATCH);
        }

        return result;
    }

    //To check entered date format
    public static ResultInfo checkDateFormat(String date){
        ResultInfo result = new ResultInfo();

        try
        {
            java.sql.Date.valueOf(date);
        }
        catch(Exception e)
        {
            result.setResult(false);
            result.setMessage(DataConstant.Message.WRONG_DATE_FORMAT);
        }

        return result;
    }
   
}
