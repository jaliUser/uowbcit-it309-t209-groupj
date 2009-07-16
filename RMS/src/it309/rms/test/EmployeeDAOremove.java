/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;

import it309.rms.dao.EmployeeDao;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;

/**
 *
 * @author DucQuang
 */
public class EmployeeDAOremove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String empID = "TestID1";
        UserIdInfo uid = new UserIdInfo();
        uid.setId(empID);
        EmployeeDao empDao = EmployeeDao.getInstance();

        //to test whether remove function in Employee DAO works properly
        try
        {
                ResultInfo ri = empDao.remove(uid);
                if(ri.getResult())
                {
                    System.out.println("Remove success for employee ID : "+empID);
                } else {
                    System.out.println("Remove not success for employee ID : "+empID);
                }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
