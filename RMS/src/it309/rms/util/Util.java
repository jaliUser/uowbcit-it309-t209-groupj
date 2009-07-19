package it309.rms.util;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

import it309.rms.dataclass.*;



/************************************************************************************
*	This utility class will grow when will find more and more utility methods		*
*************************************************************************************/

public class Util
{
	public static final String HSQLDB_DRIVER_NAME = "org.hsqldb.jdbcDriver";
	public static final String HSQLDB_SERVER_URL = "jdbc:hsqldb:hsql://localhost/rms";

	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		return getConnectionFromDriverManager();
	}

    /*
	 * This method is used to get connection from a Driver and Server information
	*/
	public static Connection getConnectionFromDriverManager() throws SQLException, ClassNotFoundException
	{
		Connection cont;
		Class.forName(HSQLDB_DRIVER_NAME);
		cont = DriverManager.getConnection(HSQLDB_SERVER_URL);
		return cont;
	}

    /*
	 * This method is used to close connection to database.
	*/
	public static void closeConnection(Connection conn)
	{
		try
		{
			conn.close();
		}
		catch(Exception e)
        {
        }
	}

    /*
	 * This method is used to add result from resultset to a object of AdministratorInfo
	*/
	public static UserIdInfo getAdministrator(ResultSet rs) throws SQLException
	{
		AdministratorInfo administrator = new AdministratorInfo();
		administrator.setId(rs.getString("admin_id"));
		administrator.setPassword(rs.getString("admin_password"));
		return administrator;
	}

    /*
	 * This method is used to add result from resultset to a object of EmployeeInfo
	*/
	public static EmployeeInfo getEmployee(ResultSet rs, EmployeeInfo employee) throws SQLException
	{
		//EmployeeInfo employee = new EmployeeInfo();


		employee.setId(rs.getString("id"));
		employee.setPassword(rs.getString("password"));
		employee.setName(rs.getString("name"));
        
		employee.setTitle(rs.getString("title"));
		employee.setAdress(rs.getString("address"));
		employee.setEmail(rs.getString("email"));
		employee.setPhone(rs.getString("phone"));
        
		return employee;
	}

    /*
	 * This method is used to add result from resultset to a object of ResourceInfo
	*/
	public static ResourceInfo getResource(ResultSet rs, ResourceInfo resource) throws SQLException
	{
		//ResourceInfo resource = new ResourceInfo();
        
		resource.setResourceId(rs.getString("id"));
		resource.setResourceType(rs.getString("type"));
        resource.setResourceTitle(rs.getString("title"));
        resource.setDescription(rs.getString("description"));
		resource.setStatus(rs.getString("status"));

        if (!Util.isNullOrEmpty(rs.getString("author_id"))){
            UserIdInfo authorIdInfo = new UserIdInfo();
            resource.setAuthorIdInfo(authorIdInfo);
            authorIdInfo.setId(rs.getString("author_id"));
            resource.setDate_entered(rs.getDate("date_entered"));
            resource.setDate_required(rs.getDate("date_required"));
            resource.setDate_return(rs.getDate("date_return"));
            resource.setPurpose(rs.getString("purpose"));
        }

        if (!Util.isNullOrEmpty(rs.getString("evaluator_id"))){
            UserIdInfo evaluatorIdInfo = new UserIdInfo();
            resource.setEvaluatorIdInfo(evaluatorIdInfo);
            evaluatorIdInfo.setId(rs.getString("evaluator_id"));
            resource.setDate_evaluated(rs.getDate("date_evaluated"));
            resource.setComment(rs.getString("comment"));
        }
		
		return resource;
	}

	/*
	* This method used to check whether a String is null or Empty
	*/
	public static boolean isNullOrEmpty(String str)
	{
		if (str==null) return true;
		if (str.equals("")) return true;
		return false;
	}

    /*
	* This method used to check whether an Object is null or Empty
	*/
    public static boolean isNullOrEmpty(Object obj)
	{
		if (obj==null) return true;
		if (obj.equals("")) return true;
		return false;
	}

    /*
	 * This method used to check whether or not an object is null.
     * This method is used to when updating database.
	*/
    public static String DBValue(Object obj){
        if (obj != null)
        {
            return "'" + obj.toString() + "'";
        }
        return null;
    }
}
