/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;

/**
 *
 * @author DucQuang
 */
import it309.rms.dao.EmployeeDao;
import it309.rms.dataclass.EmployeeInfo;

public class EmployeeDAOadd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmployeeInfo emp = new EmployeeInfo();
        emp.setId("TestID1");
        emp.setPassword("TestPass");
        emp.setName("TestName");
        emp.setTitle("Mr");
        emp.setAdress("Jurong");
        emp.setPhone("12345678");
        emp.setEmail("email@gmail.com");

        EmployeeDao empDao = EmployeeDao.getInstance();

        //to test whether add employee function in Employee DAO works properly
        try
        {
                empDao.add(emp);
                System.out.println("Employee Added Successfully : "+emp.getId());
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
