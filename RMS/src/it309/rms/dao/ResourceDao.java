package it309.rms.dao;

import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.exception.ResourceException;
import it309.rms.util.Util;

import java.sql.*;
import java.util.*;

/* This is a class to keep track of Resource Information			*
 * The implementation of this dao uses Singleton design pattern,	*
 * which is to make sure only one dao per class Loader 				*/

 public class ResourceDao implements java.io.Serializable
{
	//class variable, dao, references to the only instance
	private static ResourceDao resourceDAO = null;

	//Ensure only this class can instantiate ResourceDao
	private ResourceDao()
	{
	}

	//Other class must call getInstance method to get the instance in this class
	public static ResourceDao getInstance()
	{
		if (resourceDAO == null)
		{
			synchronized (ResourceDao.class)
			{
				if (resourceDAO == null)
				{
					resourceDAO = new ResourceDao();
				}
			}
		}
		return resourceDAO;
	}

	//Book Resource, resourceId as primary key
	public synchronized ResultInfo book(ResourceInfo resourceInfo) throws ResourceException
	{
		Connection con = null;
        ResultInfo resultInfo = new ResultInfo();
		try
		{
			con = Util.getConnection();
			Statement state = con.createStatement();

			String sqlStatement = "UPDATE Resource SET author_id = '";
			sqlStatement = sqlStatement + resourceInfo.getAuthorIdInfo().getId() + "', date_entered = ";
			sqlStatement = sqlStatement + "now , date_required = '";
            sqlStatement = sqlStatement + resourceInfo.getDate_required() + "', purpose = '";
			sqlStatement = sqlStatement + resourceInfo.getPurpose() + "'";
            sqlStatement = sqlStatement + " WHERE id='";
			sqlStatement = sqlStatement + resourceInfo.getResourceId() + "'";

			int count = state.executeUpdate(sqlStatement);
			if (count == 0)
			{
				resultInfo.setResult(false);
                resultInfo.setMessage(DataConstant.Message.NO_DATA_UPDATED);
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


    //update resource status
	public synchronized ResultInfo updateResourceStatus(ResourceInfo resourceInfo) throws ResourceException
	{
		Connection cont = null;
        ResultInfo resultInfo = new ResultInfo();
		try
		{
			cont = Util.getConnection();
			Statement state = cont.createStatement();

			String sqlStatement = "UPDATE Resource SET status = '";
			sqlStatement = sqlStatement + resourceInfo.getStatus() + "'";
            sqlStatement = sqlStatement + " WHERE id='";
			sqlStatement = sqlStatement + resourceInfo.getResourceId() + "'";

			int count = state.executeUpdate(sqlStatement);
			if (count == 0)
			{
				resultInfo.setResult(false);
                resultInfo.setMessage(DataConstant.Message.NO_DATA_UPDATED);
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
			Util.closeConnection(cont);
            return resultInfo;
		}
	}


	/* evaluate existing Resource
	   by targetted employee 		*/
	public synchronized ResultInfo updateResource(ResourceInfo resourceInfo) throws ResourceException
	{
		Connection cont = null;
        ResultInfo resultInfo = new ResultInfo();
		try
		{
			cont = Util.getConnection();
			Statement state = cont.createStatement();

			String sqlStatement = "UPDATE Resource SET evaluator_id = '";
			sqlStatement = sqlStatement + resourceInfo.getEvaluatorIdInfo().getId() + "', comment = '";
			sqlStatement = sqlStatement + resourceInfo.getComment() + "', date_evaluated = now";
			sqlStatement = sqlStatement + ", status = '";
            sqlStatement = sqlStatement + resourceInfo.getStatus() + "'";
            sqlStatement = sqlStatement + " WHERE id='";
			sqlStatement = sqlStatement + resourceInfo.getResourceId() + "'";

			int count = state.executeUpdate(sqlStatement);

			if(count == 0)
			{
				resultInfo.setResult(false);
                resultInfo.setMessage(DataConstant.Message.NO_DATA_UPDATED);
			}
		}
		catch(Exception e)
		{
			resultInfo.setResult(false);
            resultInfo.setErrorType(DataConstant.ErrorType.ERROR);
            resultInfo.setMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                        this.getClass().getName(),e.getMessage()));
		}
		finally
		{
			Util.closeConnection(cont);
            return resultInfo;
		}
	}

	//Retrieve all Resources based on string condition
	public ResultInfo searchResource(String fieldName, 
                                           String condition,
                                           Collection collect) throws ResourceException
	{
		Connection cont = null;
		collect = new LinkedList();

        ResourceInfo resourceInfo = null;

        ResultInfo resultInfo = new ResultInfo();

		try
		{
			cont = Util.getConnection();
			Statement state = cont.createStatement();
			String sqlStatement = "SELECT * FROM Resource WHERE "+ fieldName +" like '%"+ condition +"%'" ;
            sqlStatement = sqlStatement + " ORDER BY " + fieldName;
			

			ResultSet rs = state.executeQuery(sqlStatement);

			if((rs.next()))
			{
				resourceInfo = Util.getResource(rs);
				collect.add(resourceInfo);
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
			Util.closeConnection(cont);
            return resultInfo;
		}
	}

	//Retrieve all Resources based on Resource date
	public ResultInfo searchResource(String fieldName,
                                            String fromDate,
                                            String toDate,
                                            Collection collect) throws ResourceException				//(java.sql.Date sggDate) throws ResourceException
	{
		Connection cont = null;
		collect = new LinkedList();
		ResultInfo resultInfo = new ResultInfo();
		try
		{
			cont = Util.getConnection();
			Statement state = cont.createStatement();
			ResultSet rs = state.executeQuery("SELECT * FROM Resource WHERE " + fromDate +  " <= "+fieldName+" <= " + fromDate + " ORDER BY " + fieldName);

			ResourceInfo resourceInfo;

			while (rs.next())
			{
				resourceInfo = Util.getResource(rs);
				collect.add(resourceInfo);
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
			Util.closeConnection(cont);
            return resultInfo;
		}
	}
}