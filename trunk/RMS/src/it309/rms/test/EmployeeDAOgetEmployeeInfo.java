/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;

import it309.rms.dao.EmployeeDao;
import it309.rms.dataclass.EmployeeInfo;

/**
 *
 * @author DucQuang
 */
public class EmployeeDAOgetEmployeeInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmployeeInfo emp = new EmployeeInfo();
        String empID = "TestID1";
        EmployeeDao empDao = EmployeeDao.getInstance();

        try
        {
                //get employee for specified employee ID
                empDao.getEmployeeInfo(empID, emp);
                System.out.println("Employee = "+emp.getName());
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
