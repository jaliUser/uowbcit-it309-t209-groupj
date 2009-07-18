/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.business;

import it309.rms.dao.EmployeeDao;
import it309.rms.dataclass.EmployeeInfo;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;
import it309.rms.exception.EmployeeException;
import java.util.Collection;
import java.util.LinkedList;

/**
 *
 * @author khangdt
 */
public class EmployeeHelper{

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

    public ResultInfo Add(EmployeeInfo employeeInfo) throws EmployeeException
    {
        ResultInfo resultInfo = null;
        try
        {

            resultInfo =  EmployeeDao.getInstance().add(employeeInfo);

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

    public ResultInfo changePassword(UserIdInfo idInfo, String newPassword) throws EmployeeException
    {
         ResultInfo resultInfo = null;
        try
        {
            resultInfo = EmployeeDao.getInstance().checkExist(idInfo);

            if (resultInfo.getResult())
            {
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

    public ResultInfo search(String field, String condition, Collection list) throws EmployeeException
    {
        ResultInfo resultInfo = null;
        try
        {
            list = new LinkedList();
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
