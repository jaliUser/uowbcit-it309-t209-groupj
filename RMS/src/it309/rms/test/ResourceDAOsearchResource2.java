/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;

import it309.rms.dao.ResourceDao;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.ResourceInfo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author DucQuang
 */
public class ResourceDAOsearchResource2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fieldName = "Date Enter";
        //String fieldName = "Date Require";
        String fromDate = "1/1/2009";
        String toDate = "12/31/2009";
        ResourceInfo rsi = new ResourceInfo();
        List<ResourceInfo> collect = new LinkedList<ResourceInfo>();
        ResourceDao resDao = ResourceDao.getInstance();
        //to test whether searchResource function in Resource DAO works properly
        try
        {
                ResultInfo ri = resDao.searchResource(fieldName, fromDate, toDate, collect);
                if(ri.getResult())
                {
                    if (collect.contains(rsi))
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
