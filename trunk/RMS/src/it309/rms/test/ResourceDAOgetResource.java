/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;

import it309.rms.dao.ResourceDao;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.ResourceInfo;
/**
 *
 * @author DucQuang
 */
public class ResourceDAOgetResource {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ResourceInfo rsi = new ResourceInfo();
        ResourceDao resDao = ResourceDao.getInstance();
        //to test whether getResource function in Resource DAO works properly
        try
        {
                ResultInfo ri = resDao.getResource("RS001", rsi);
                if(ri.getResult())
                {
                    System.out.println("Resource details : "+rsi.getResourceId()
                                                       + " " + rsi.getResourceTitle()
                                                       + " " + rsi.getStatus());
                } else {
                    System.out.println("Get resource details failed.");
                }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
