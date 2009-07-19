/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;

import it309.rms.dao.ResourceDao;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;
import java.util.Date;
/**
 *
 * @author DucQuang
 */
public class ResourceDAOupdateBookingInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserIdInfo uid = new UserIdInfo("khang", null);
        ResourceInfo rsi = new ResourceInfo();
        rsi.setResourceId("RS001");
        rsi.setAuthorIdInfo(uid);
        rsi.setDate_required(java.sql.Date.valueOf("2009-07-18"));
        rsi.setDate_return(java.sql.Date.valueOf("2009-07-31"));
        rsi.setPurpose("Project A");
        ResourceDao resDao = ResourceDao.getInstance();
        
        try
        {
            //to test whether update booking info function in Resource DAO works properly
            ResultInfo ri = resDao.updateBookingInfo(rsi);
            if (ri.getResult())
            {
                System.out.println("Book resource success : "+rsi.getResourceId());
            } else {
                System.out.println("Book resource fail ");
            }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
