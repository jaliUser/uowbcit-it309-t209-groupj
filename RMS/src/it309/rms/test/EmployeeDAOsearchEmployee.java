/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;

import it309.rms.dao.EmployeeDao;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.EmployeeInfo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DucQuang
 */
public class EmployeeDAOsearchEmployee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fieldName = "EmployeeID";
        String condition = "TestID1";
        EmployeeInfo emp = new EmployeeInfo();
        List<EmployeeInfo> collect = new LinkedList<EmployeeInfo>();
        EmployeeDao empDao = EmployeeDao.getInstance();
        //to test whether searchEmployee function in Employee DAO works properly
        try
        {
                ResultInfo ri = empDao.searchEmployee(fieldName, condition, collect);
                if(ri.getResult())
                {
                    if (collect.contains(emp))
                    {
                        System.out.println("Collection have total records : "+collect.size());
                    } else {
                        System.out.println("Collection do not have record ");
                    }
                } else {
                    System.out.println("ResultInfo do not have result ");
                }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
