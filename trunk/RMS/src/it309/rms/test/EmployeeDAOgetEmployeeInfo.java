/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;

import it309.rms.dao.EmployeeDao;
import it309.rms.dataclass.EmployeeInfo;
import it309.rms.dataclass.ResultInfo;

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
                ResultInfo ri = empDao.getEmployeeInfo(empID, emp);
                if (ri.getResult())
                {
                    System.out.println("Employee Info: "+ emp.getId() + " ; "
                            + emp.getName() + " ; "
                            + emp.getTitle() + " ; "
                            + emp.getAdress() + " ; "
                            + emp.getPhone());
                } else {
                    System.out.println("Retrieve Employee Info failed.");
                }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
