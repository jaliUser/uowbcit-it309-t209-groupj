package it309.rms.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

import it309.rms.exception.ResourceException;
import it309.rms.exception.EmployeeException;
import it309.rms.exception.AdministratorException;

import it309.rms.dataclass.*;
import it309.rms.exception.BaseException;
import java.util.List;


/************************************************************************************
*	This utility class will grow when will find more and more utility methods		*
*************************************************************************************/

public class Util
{
	public static final String HSQLDB_DRIVER_NAME = "org.hsqldb.jdbcDriver";
	//public static final String HSQLDB_SERVER_URL = "jdbc:hsqldb:hsql://localhost/rms";
        public static final String HSQLDB_SERVER_URL = "jdbc:hsqldb:file:RMS";
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		return getConnectionFromDriverManager();
	}

	public static Connection getConnectionFromDriverManager() throws SQLException, ClassNotFoundException
	{
		Connection cont;
		Class.forName(HSQLDB_DRIVER_NAME);
		cont = DriverManager.getConnection(HSQLDB_SERVER_URL);
		return cont;
	}

	public static void closeConnection(Connection conn)
	{
		try
		{
			conn.close();
		}
		catch(Exception e){}
	}

	public static UserIdInfo getAdministrator(ResultSet rs) throws SQLException
	{
		AdministratorInfo administrator = new AdministratorInfo();
		administrator.setId(rs.getString("admin_id"));
		administrator.setPassword(rs.getString("admin_password"));
		return administrator;
	}

    public static UserIdInfo getEmployeeIdInfo(ResultSet rs) throws SQLException
    {
        EmployeeInfo employee = new EmployeeInfo();


		employee.setId(rs.getString("id"));
		employee.setPassword(rs.getString("password"));
		employee.setName(rs.getString("name"));

        return employee;
    }


	public static EmployeeInfo getEmployee(ResultSet rs) throws SQLException
	{
		EmployeeInfo employee = new EmployeeInfo();


		employee.setId(rs.getString("id"));
		employee.setPassword(rs.getString("password"));
		employee.setName(rs.getString("name"));
        
		employee.setTitle(rs.getString("title"));
		employee.setAdress(rs.getString("address"));
		employee.setEmail(rs.getString("email"));
		employee.setPhone(rs.getString("phone"));
        
		return employee;
	}


	public static ResourceInfo getResource(ResultSet rs) throws SQLException
	{
		ResourceInfo resource = new ResourceInfo();
        
		resource.setResourceId(rs.getString("id"));
        resource.setResourceTitle(rs.getString("title"));

        UserIdInfo authorIdInfo = new UserIdInfo();
        resource.setAuthorIdInfo(authorIdInfo);
		authorIdInfo.setId(rs.getString("author_id"));

        UserIdInfo evaluatorIdInfo = new UserIdInfo();
        resource.setAuthorIdInfo(evaluatorIdInfo);
		evaluatorIdInfo.setId(rs.getString("evaluator_id"));

		resource.setDescription(rs.getString("description"));
		resource.setStatus(rs.getString("status"));
		resource.setDate_entered(rs.getDate("date_entered"));
		resource.setDate_required(rs.getDate("date_required"));
		resource.setPurpose(rs.getString("purpose"));
		resource.setComment(rs.getString("comment"));
		resource.setDate_evaluated(rs.getDate("date_evaluated"));

		return resource;
	}

	/*
	a method used to check whether a String is null or Empty
	*/

	public static boolean isNullOrEmpty(String str)
	{
		if (str==null) return true;
		if (str.equals("")) return true;
		return false;
	}

	public ResultInfo validate(List paramList)
	{
        ResultInfo result = new ResultInfo();
		
		return result;
	}

}
