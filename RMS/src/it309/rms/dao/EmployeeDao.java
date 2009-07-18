package it309.rms.dao;

import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.EmployeeInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;
import it309.rms.exception.EmployeeException;
import it309.rms.util.Util;
import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;



public class EmployeeDao implements java.io.Serializable
{

	private static EmployeeDao dao = null;


	private EmployeeDao()
	{
	}

	// 	Other class should call this method to getEmployeeInfo the only instance of this class
	// 	The instantiation of object is on demand only
	//	The method is thread-safe
	public static EmployeeDao getInstance()
	{
		if (dao == null)
		{
			synchronized (EmployeeDao.class)
			{
				if (dao == null)
				{
					dao = new EmployeeDao();
				}
			}
		}
		return dao;
	}

	// Add a particular employeeInfo to the database, using employeeID as key
	public synchronized ResultInfo add(EmployeeInfo employeeInfo) throws EmployeeException
	{
		Connection con = null;
        ResultInfo resultInfo = new ResultInfo();
		try
		{
           
			con=Util.getConnection();
			String sql = "INSERT INTO Employee (id, password, name, title, address, phone, email) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, employeeInfo.getId());
			stm.setString(2, employeeInfo.getPassword());
			stm.setString(3, employeeInfo.getName());
			stm.setString(4, employeeInfo.getTitle());
			stm.setString(5, employeeInfo.getAdress());
			stm.setString(6, employeeInfo.getPhone());
			stm.setString(7, employeeInfo.getEmail());

			int n = stm.executeUpdate();
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
		}finally
		{
			Util.closeConnection(con);
            return resultInfo;
		}
	}

	// Update a particular employeeInfo's information
	public synchronized ResultInfo update(EmployeeInfo employee) throws EmployeeException
	{
		Connection con = null;
         ResultInfo resultInfo = new ResultInfo();
		try
		{
			con=Util.getConnection();
			Statement stm = con.createStatement();

			String sql = "UPDATE Employee SET password = '";
			sql = sql + employee.getPassword()+ "', name = '";
			sql = sql + employee.getName()+ "', title = '";
			sql = sql + employee.getTitle()+ "', address = '";
			sql = sql + employee.getAdress()+ "', phone = '";
			sql = sql + employee.getPhone()+ "', email = '";
			sql = sql + employee.getEmail()+ "' WHERE id = '";
			sql = sql + employee.getId()+ "'";
			int n = stm.executeUpdate(sql);
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
		}finally
		{
			Util.closeConnection(con);
            return resultInfo;
		}

	}

    // Update a particular employeeInfo's information
	public synchronized ResultInfo updatePassword(UserIdInfo idInfo) throws EmployeeException
	{
		Connection con = null;
         ResultInfo resultInfo = new ResultInfo();
		try
		{
			con=Util.getConnection();
			Statement stm = con.createStatement();

			String sql = "UPDATE Employee SET password = '";
			sql = sql + idInfo.getPassword() + "' WHERE id = '";
			sql = sql + idInfo.getId()+ "'";
			int n = stm.executeUpdate(sql);
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
		}finally
		{
			Util.closeConnection(con);
            return resultInfo;
		}

	}

	// remove the employeeInfo record which matches the employeeID
	public synchronized ResultInfo remove(UserIdInfo employeeIdInfo) throws EmployeeException
	{
		Connection con = null;
        ResultInfo resultInfo = new ResultInfo();
		try
		{
			con=Util.getConnection();
			Statement stm = con.createStatement();

			String sql = "DELETE FROM Employee WHERE id='"+employeeIdInfo.getId()+"'";


			int n = stm.executeUpdate(sql);
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
		}finally
		{
			Util.closeConnection(con);
            return resultInfo;
		}
	}

     // Retrieve the employeeInfo information using the employeeID and password
	public synchronized ResultInfo checkExist(UserIdInfo userIdInfo) throws EmployeeException
	{
		Connection con = null;
        ResultInfo resultInfo = new ResultInfo();
		try
		{
			con=Util.getConnection();
			Statement stm = con.createStatement();
			String sql = "SELECT Count(id) FROM Employee WHERE id='"+userIdInfo.getId()+"' and passowrd='";
            sql = sql + userIdInfo.getPassword() + "'";

            ResultSet rs = stm.executeQuery(sql);

			if (!(rs.next()))
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
    
	// Retrieve the employeeInfo information using the employeeID as key
	public ResultInfo getEmployeeInfo(String employeeID, EmployeeInfo employeeInfo) throws EmployeeException
	{
		Connection con = null;
        ResultInfo resultInfo = new ResultInfo();
		try
		{
			con=Util.getConnection();
			Statement stm = con.createStatement();
			String sql = "SELECT * FROM Employee WHERE id='"+employeeID+"'";

            ResultSet rs = stm.executeQuery(sql);

			if ((rs.next()))
			{
				employeeInfo = Util.getEmployee(rs);
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

    //search all employees
    public ResultInfo searchEmployee(String fieldName, String condition, Collection collect) throws EmployeeException
	{
		Connection con = null;
		collect = new LinkedList();

        EmployeeInfo employeeInfo = null;

        ResultInfo resultInfo = new ResultInfo();

		try
		{
			con = Util.getConnection();
			Statement state = con.createStatement();
			String sqlStatement = "SELECT * FROM Employee WHERE " + fieldName + " like '%"+ condition +"%'";
            sqlStatement = sqlStatement + " ORDER BY " + fieldName;


			ResultSet rs = state.executeQuery(sqlStatement);

			if((rs.next()))
			{
				employeeInfo = Util.getEmployee(rs);
				collect.add(employeeInfo);
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
}
