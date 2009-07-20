/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;

import it309.rms.dao.ResourceDao;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;
/**
 *
 * @author DucQuang
 */
public class ResourceDAOremoveBookingInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        ResourceInfo rsi = new ResourceInfo();
        rsi.setResourceId("RS001");        
        ResourceDao resDao = ResourceDao.getInstance();

        try
        {
            //to test whether update booking info function in Resource DAO works properly
            ResultInfo ri = resDao.removeBookingInformation(rsi);
            if (ri.getResult())
            {
                System.out.println("Remove booking resource success : "+rsi.getResourceId());
            } else {
                System.out.println("Remove booking resource failed. ");
            }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
