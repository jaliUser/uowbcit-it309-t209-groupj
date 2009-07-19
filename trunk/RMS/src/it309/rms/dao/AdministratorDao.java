/*
 * This class is responsible for processing data of table Administrator in database.
 *
 */

package it309.rms.dao;

import it309.rms.dataclass.*;
import it309.rms.exception.AdministratorException;
import it309.rms.util.Util;
import java.sql.*;

/**
 *
 * @author khangdt
 */
public class AdministratorDao implements java.io.Serializable
{
	// The class variable, dao, is reference to the only instance of this class
	private static AdministratorDao dao = null;


	// Make sure no other class can instantiate any AdministratorDao
	private AdministratorDao()
	{
	}

	// 	Other class should call this method to get the only instance of this class
	// 	The instantiation of object is on demand only
	//	The method is thread-safe
	public static AdministratorDao getInstance()
	{
		if (dao == null)
		{
			synchronized (AdministratorDao.class)
			{
				if (dao == null)
				{
					dao = new AdministratorDao();
				}
			}
		}
		return dao;
	}


    //Update Administrator password
	public synchronized ResultInfo updatePassword(UserIdInfo administrator) throws AdministratorException
	{
		Connection con = null;
        ResultInfo resultInfo = new ResultInfo();
        
		try
		{
		   con = Util.getConnection();
		   Statement stm = con.createStatement();
		   int n = stm.executeUpdate("update Administrator set password = '"+administrator.getPassword()+"' where id = '"+ administrator.getId()+"'");
		   if (n == 0)
		   {
			   	resultInfo.setResult(false);
                resultInfo.setMessage(DataConstant.Message.NO_DATA_UPDATED);
			}
		}catch (Exception e)
		{
			resultInfo.setResult(false);
            resultInfo.setErrorType(DataConstant.ErrorType.ERROR);
            resultInfo.setMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
		}
        finally
		{
			Util.closeConnection(con);
            return resultInfo;
		}
	}

     // check if Administrator exists or not
	public synchronized ResultInfo checkExist(UserIdInfo userIdInfo) throws AdministratorException
	{
		Connection con = null;
        ResultInfo resultInfo = new ResultInfo();
		try
		{
			con=Util.getConnection();
			Statement stm = con.createStatement();
			String sql = "SELECT id FROM Administrator WHERE id='"+userIdInfo.getId()+"' and password='";
            sql = sql + userIdInfo.getPassword() + "'";

            ResultSet rs = stm.executeQuery(sql);

			if (!rs.next())
			{
                resultInfo.setResult(false);
                resultInfo.setMessage(DataConstant.Message.USER_NOT_EXIST);
			}

		}
        catch (Exception e)
		{
            resultInfo.setResult(false);
            resultInfo.setErrorType(DataConstant.ErrorType.ERROR);
            resultInfo.setMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
		}
        finally
		{
			Util.closeConnection(con);
            return resultInfo;
		}
	}
}
