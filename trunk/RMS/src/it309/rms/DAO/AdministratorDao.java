package it309.rms.dao;

import it309.rms.dataclass.*;
import it309.rms.exception.AdministratorException;
import it309.rms.util.Util;
import java.sql.*;

public class AdministratorDao implements java.io.Serializable
{
	private AdministratorInfo administrator; // this is the only Administrator instance managed by this dao

	// The class variable, dao, is reference to the only instance of this class
	private static AdministratorDao dao = null;


	// Make sure no other class can instantiate any AdministratorDao
	private AdministratorDao()
	{
		initAdministrator();
	}

	// get the administrator information from database and intialize the in-memory administrator instance
	private void initAdministrator()
	{
		Connection con = null;
		try
		{
		   con = Util.getConnection();
		   Statement stm = con.createStatement();
		   ResultSet rs = stm.executeQuery("select * from Administrator");
		   if (rs.next())
		   {
			  administrator=new AdministratorInfo(rs.getString("id"),rs.getString("password"));
		   }  else
		   {
			   throw new AdministratorException("AdministratorDao:: Failed to retrieve the Administrator Information ");
			}
		}catch (Exception e)
		{
			System.out.println("AdministratorDao:: constructor:: Exception="+ e);
		}finally
		{
			Util.closeConnection(con);
		}

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


	public synchronized void setAdministrator(AdministratorInfo administrator) throws AdministratorException
	{
		this.administrator = administrator;
		Connection con = null;
		try
		{
		   con = Util.getConnection();
		   Statement stm = con.createStatement();
		   int n = stm.executeUpdate("update Administrator set password = '"+administrator.getPassword()+"' where id = '"+ administrator.getId()+"'");
		   if (n == 0)
		   {
			   	throw new AdministratorException("AdministratorDao:: Failed 'setAdministrator' operation: ");
			}
		}catch (Exception e)
		{
			throw new AdministratorException("AdministratorDao:: exception= "+ e);
		}finally
		{
			Util.closeConnection(con);
		}
	}

	public AdministratorInfo getAdministrator()
	{
		if (administrator == null) initAdministrator();
	 	return administrator;
	}

	public AdministratorInfo getAdministrator(String administratorID)
	{
		if (administrator == null) initAdministrator();
		if (administrator.getId().equals(administratorID))
		{
			return administrator;
		}
		return null;
	}
}
