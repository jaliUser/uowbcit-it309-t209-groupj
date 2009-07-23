/*
 * This is a class is responsible for proccessing business logic which relates to Employee
 * and call functions of DAO classes.
 */

package it309.rms.business;

import it309.rms.dao.EmployeeDao;
import it309.rms.dataclass.EmployeeInfo;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;
import it309.rms.exception.EmployeeException;
import java.util.Collection;

/**
 *
 * @author khangdt
 */
public class EmployeeHelper{

    // The class variable, dao, is reference to the only instance of this class
	private static EmployeeHelper helper = null;

    // 	Other class should call this method to get the only instance of this class
	// 	The instantiation of object is on demand only
	//	The method is thread-safe
	public static EmployeeHelper getInstance()
	{
		if (helper == null)
		{
			synchronized (EmployeeHelper.class)
			{
				if (helper == null)
				{
					helper = new EmployeeHelper();
				}
			}
		}
		return helper;
	}

    //Process of logon
    public ResultInfo Logon(UserIdInfo employeeIdInfo) throws EmployeeException
    {
        ResultInfo resultInfo = null;
        try
        {
            
            resultInfo =  EmployeeDao.getInstance().checkExist(employeeIdInfo);

        }
        catch (EmployeeException e)
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

    //Process of employee addition
    public ResultInfo Add(EmployeeInfo employeeInfo) throws EmployeeException
    {
        ResultInfo resultInfo = null;
        try
        {
            EmployeeInfo employeeInfoTmp = new EmployeeInfo();
            resultInfo = EmployeeDao.getInstance().getEmployeeInfo(employeeInfo.getId(), employeeInfoTmp);

            if (resultInfo.getResult())
            {
                resultInfo.setResult(false);
                resultInfo.setMessage(DataConstant.Message.EMPLOYEE_EXISTS);
            }
            else
            {
                resultInfo =  EmployeeDao.getInstance().add(employeeInfo);
            }

            

        }
        catch (EmployeeException e)
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

    //Process of employee deleting
    public ResultInfo delete(UserIdInfo employeeIdInfo) throws EmployeeException
    {
        ResultInfo resultInfo = null;
        try
        {

            resultInfo =  EmployeeDao.getInstance().remove(employeeIdInfo);

        }
        catch (EmployeeException e)
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

    //Process of employee updating
    public ResultInfo update(EmployeeInfo employeeInfo) throws EmployeeException
    {
        ResultInfo resultInfo = null;
        try
        {
            
            resultInfo =  EmployeeDao.getInstance().update(employeeInfo);

        }
        catch (EmployeeException e)
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

    //Process of password change
    public ResultInfo changePassword(UserIdInfo idInfo, String newPassword) throws EmployeeException
    {
         ResultInfo resultInfo = null;
        try
        {
            resultInfo = EmployeeDao.getInstance().checkExist(idInfo);

            if (resultInfo.getResult())
            {
                idInfo.setPassword(newPassword);
                resultInfo =  EmployeeDao.getInstance().updatePassword(idInfo);
            }

        }
        catch (EmployeeException e)
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

    //Process of getting employee base on Id
     public ResultInfo getEmployeeById(String id, EmployeeInfo employeeInfo) throws EmployeeException
    {
        ResultInfo resultInfo = null;
        try
        {

            resultInfo = EmployeeDao.getInstance().getEmployeeInfo(id, employeeInfo);

        }
        catch (EmployeeException e)
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

     //Process of search employee
    public ResultInfo search(String field, String condition, Collection list) throws EmployeeException
    {
        ResultInfo resultInfo = null;
        try
        {
            resultInfo = EmployeeDao.getInstance().searchEmployee(field, condition, list);

        }
        catch (EmployeeException e)
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
