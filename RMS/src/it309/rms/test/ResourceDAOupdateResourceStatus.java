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
public class ResourceDAOupdateResourceStatus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ResourceInfo rsi = new ResourceInfo();
        rsi.setResourceId("RS001");
        rsi.setStatus("Ready for loan");
        //rsi.setStatus("On Loan");
        //rsi.setStatus("Missing");
        ResourceDao resDao = ResourceDao.getInstance();
        try
        {
                //to test whether update resource function in Resource DAO works properly
            ResultInfo ri = resDao.updateResourceStatus(rsi);
            if (ri.getResult())
            {
                System.out.println("Update resource status success : "+rsi.getResourceId());
            } else {
                System.out.println("Update resource status fail ");
            }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
