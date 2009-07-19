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
public class ResourceDAOsearchResource1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fieldName = "ID";
        String condition = "RS001";
        List<ResourceInfo> collect = new LinkedList<ResourceInfo>();
        ResourceDao resDao = ResourceDao.getInstance();
        //to test whether searchResource function in Resource DAO works properly
        try
        {
                ResultInfo ri = resDao.searchResource(fieldName, condition, collect);
                if(ri.getResult())
                {                    
                    System.out.println("Collection have total records : "+collect.size());                    
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
