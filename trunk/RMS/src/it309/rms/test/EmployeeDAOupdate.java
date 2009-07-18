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
public class EmployeeDAOupdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmployeeInfo emp = new EmployeeInfo();
        emp.setId("TestID1");
        emp.setPassword("PassTest02");
        emp.setName("NameTest03");
        emp.setTitle("TitleTest04");
        emp.setAdress("AddressTest05");
        emp.setEmail("EmailTest06");
        emp.setPhone("PhoneTest07");
        EmployeeDao empDao = EmployeeDao.getInstance();

        try
        {
                //to test whether update function in Employee DAO works properly
            ResultInfo ri = empDao.update(emp);
            if (ri.getResult())
            {
                System.out.println("Update Success : "+emp);
            } else {
                System.out.println("Update Fail ");
            }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
