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
public class EmployeeDAOcheckExist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmployeeInfo emp = new EmployeeInfo();
        emp.setId("TestcheckExist");
        emp.setPassword("TestPass");
        emp.setName("TestName");
        emp.setTitle("Mr");
        emp.setAdress("Jurong");
        emp.setPhone("12345678");
        emp.setEmail("email@gmail.com");
        UserIdInfo uid = new UserIdInfo("TestcheckExist","TestPass");
        EmployeeDao empDao = EmployeeDao.getInstance();

        //to test whether check exist employee function in Employee DAO works properly
        try
        {                
                ResultInfo ri = empDao.checkExist(uid);
                if (ri.getResult())
                {
                    System.out.println("User existed : "+uid.getId());
                } else {
                    System.out.println("Not existed user: "+uid.getId());
                    empDao.add(emp);
                }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
