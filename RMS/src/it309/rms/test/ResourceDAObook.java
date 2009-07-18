/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;

import it309.rms.dao.ResourceDao;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.ResultInfo;
/**
 *
 * @author DucQuang
 */
public class ResourceDAObook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ResourceInfo rsi = new ResourceInfo();
        rsi.setResourceId("RS001");
        rsi.setResourceType("Reference");
        rsi.setResourceTitle("IT309 – System development & implementation");
        rsi.setStatus("Functioning");
        rsi.setDescription("Study guide version 1");
        ResourceDao resDao = ResourceDao.getInstance();
        
        try
        {
                //to test whether book function in Resource DAO works properly
            ResultInfo ri = resDao.book(rsi);
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
