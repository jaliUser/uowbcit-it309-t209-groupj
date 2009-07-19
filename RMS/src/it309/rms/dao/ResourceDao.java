/*
 * This class is responsible for processing data of table Resource in database.
 *
 */

package it309.rms.dao;

import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.exception.ResourceException;
import it309.rms.util.Util;

import java.sql.*;
import java.util.*;

/**
 *
 * @author khangdt
 */
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

    //Update booking information
	public synchronized ResultInfo removeBookingInformation(ResourceInfo resourceInfo) throws ResourceException
	{
		Connection con = null;
        ResultInfo resultInfo = new ResultInfo();
		try
		{
			con = Util.getConnection();
			Statement state = con.createStatement();

			String sqlStatement = "UPDATE Resource SET author_id = null, date_entered=null, date_required=null, date_return=null, purpose = null, status='";
            sqlStatement = sqlStatement + resourceInfo.getStatus() + "'";
            sqlStatement = sqlStatement + " WHERE id=" + Util.DBValue(resourceInfo.getResourceId());

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

	//Update booking information
	public synchronized ResultInfo updateBookingInfo(ResourceInfo resourceInfo) throws ResourceException
	{
		Connection con = null;
        ResultInfo resultInfo = new ResultInfo();
		try
		{
			con = Util.getConnection();
			Statement state = con.createStatement();

			String sqlStatement = "UPDATE Resource SET author_id = ";
			sqlStatement = sqlStatement + Util.DBValue(resourceInfo.getAuthorIdInfo().getId()) + ", date_entered = now,";
			sqlStatement = sqlStatement + " date_required=";
            sqlStatement = sqlStatement + Util.DBValue(resourceInfo.getDate_required()) + ", date_return=";
            sqlStatement = sqlStatement + Util.DBValue(resourceInfo.getDate_return()) + ", status ='";
            sqlStatement = sqlStatement + resourceInfo.getStatus() + "', purpose ='";
			sqlStatement = sqlStatement + resourceInfo.getPurpose() + "'";
            sqlStatement = sqlStatement + " WHERE id=" + Util.DBValue(resourceInfo.getResourceId());

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

    //Update booking information and valuating information
	public synchronized ResultInfo updateBookingAndEvaluatingInfo(ResourceInfo resourceInfo) throws ResourceException
	{
		Connection con = null;
        ResultInfo resultInfo = new ResultInfo();
		try
		{
			con = Util.getConnection();
			Statement state = con.createStatement();

			String sqlStatement = "UPDATE Resource SET author_id=null, date_entered=null, date_required=null, date_return=null, purpose = null, status='";
            sqlStatement = sqlStatement + resourceInfo.getStatus() + "', evaluator_id=";
            sqlStatement = sqlStatement + Util.DBValue(resourceInfo.getEvaluatorIdInfo().getId()) + ", comment=";
            sqlStatement = sqlStatement + Util.DBValue(resourceInfo.getComment()) + ", date_evaluated=now";
            sqlStatement = sqlStatement + " WHERE id=" + Util.DBValue(resourceInfo.getResourceId());

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
            sqlStatement = sqlStatement + " WHERE id=" + Util.DBValue(resourceInfo.getResourceId());

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
	public synchronized ResultInfo updateEvaludatingInfo(ResourceInfo resourceInfo) throws ResourceException
	{
		Connection cont = null;
        ResultInfo resultInfo = new ResultInfo();
		try
		{
			cont = Util.getConnection();
			Statement state = cont.createStatement();

			String sqlStatement = "UPDATE Resource SET evaluator_id =";
			sqlStatement = sqlStatement + Util.DBValue(resourceInfo.getEvaluatorIdInfo().getId()) + ", comment =";
			sqlStatement = sqlStatement + Util.DBValue(resourceInfo.getComment()) + ", date_evaluated=now,";
			sqlStatement = sqlStatement + " status = '";
            sqlStatement = sqlStatement + resourceInfo.getStatus() + "'";
            sqlStatement = sqlStatement + " WHERE id=" + Util.DBValue(resourceInfo.getResourceId());

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

    //Get Resource base on Author Id
	public ResultInfo getResourceByAuthorId(String authorId, Collection list) throws ResourceException
	{
		Connection cont = null;

        ResultInfo resultInfo = new ResultInfo();

		try
		{
			cont = Util.getConnection();
			Statement state = cont.createStatement();
			String sqlStatement = "SELECT * FROM Resource WHERE author_id='"+ authorId +"'";


			ResultSet rs = state.executeQuery(sqlStatement);

            ResourceInfo resourceInfo = null;
			while((rs.next()))
			{
                resourceInfo = new ResourceInfo();
				resourceInfo = Util.getResource(rs, resourceInfo);
                list.add(resourceInfo);
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

    //Get Resource base on Resource Id
	public ResultInfo getResource(String resourceId, ResourceInfo resourceInfo) throws ResourceException
	{
		Connection cont = null;

        ResultInfo resultInfo = new ResultInfo();

		try
		{
			cont = Util.getConnection();
			Statement state = cont.createStatement();
			String sqlStatement = "SELECT * FROM Resource WHERE id='"+ resourceId +"'";


			ResultSet rs = state.executeQuery(sqlStatement);

			if((rs.next()))
			{
				resourceInfo = Util.getResource(rs, resourceInfo);
			}
            else
            {
                resultInfo.setResult(false);
                resultInfo.setMessage(DataConstant.Message.RESOURCE_NOT_EXIST);
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

	//Retrieve all Resources based on string condition
	public ResultInfo searchResource(String fieldName, String condition, Collection collect) throws ResourceException
	{
		Connection cont = null;

        ResultInfo resultInfo = new ResultInfo();

		try
		{
			cont = Util.getConnection();
			Statement state = cont.createStatement();
			String sqlStatement = "SELECT * FROM Resource WHERE "+ fieldName +" like upper('%"+ condition.toUpperCase() +"%')" ;
            sqlStatement = sqlStatement + " ORDER BY " + fieldName;
			

			ResultSet rs = state.executeQuery(sqlStatement);

            ResourceInfo resourceInfo = null;
			while((rs.next()))
			{
                resourceInfo = new ResourceInfo();
				Util.getResource(rs, resourceInfo);
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