/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;

import it309.rms.dao.EmployeeDao;
import it309.rms.dataclass.EmployeeInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;

/**
 *
 * @author DucQuang
 */
public class EmployeeDAOupdatePassword {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserIdInfo uid = new UserIdInfo("TestID1", "TestUpdatePassword");
        EmployeeDao empDao = EmployeeDao.getInstance();
        try
        {
                //to test whether update password function in Employee DAO works properly
            ResultInfo ri = empDao.updatePassword(uid);
            if (ri.getResult())
            {
                System.out.println("Update password success : "+uid.getPassword());
            } else {
                System.out.println("Update password fail ");
            }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
