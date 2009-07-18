/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.business;

import it309.rms.dao.AdministratorDao;
import it309.rms.dao.EmployeeDao;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;
import it309.rms.exception.AdministratorException;

/**
 *
 * @author khangdt
 */
public class AdministratorHelper {

    // The class variable, dao, is reference to the only instance of this class
	private static AdministratorHelper helper = null;

    // 	Other class should call this method to get the only instance of this class
	// 	The instantiation of object is on demand only
	//	The method is thread-safe
	public static AdministratorHelper getInstance()
	{
		if (helper == null)
		{
			synchronized (AdministratorHelper.class)
			{
				if (helper == null)
				{
					helper = new AdministratorHelper();
				}
			}
		}
		return helper;
	}

    public ResultInfo Logon(UserIdInfo IdInfo) throws AdministratorException
    {
        ResultInfo resultInfo = null;
        try
        {

            resultInfo =  AdministratorDao.getInstance().checkExist(IdInfo);

        }
        catch (AdministratorException e)
        {
            resultInfo.setResult(false);
            resultInfo.setMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
        }
        finally
        {
            return resultInfo;
        }

    }

    public ResultInfo changePassword(UserIdInfo idInfo, String newPassword) throws AdministratorException
    {
         ResultInfo resultInfo = null;
        try
        {
            resultInfo = AdministratorDao.getInstance().checkExist(idInfo);

            if (resultInfo.getResult())
            {
                idInfo.setPassword(newPassword);
                resultInfo =  AdministratorDao.getInstance().updatePassword(idInfo);
            }

        }
        catch (AdministratorException e)
        {
            resultInfo.setResult(false);
            resultInfo.setMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
        }
        finally
        {
            return resultInfo;
        }
    }

}
