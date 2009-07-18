/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;

import it309.rms.dao.ResourceDao;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.UserIdInfo;

/**
 *
 * @author DucQuang
 */
public class ResourceDAOupdateEvaluatingInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ResourceInfo rsi = new ResourceInfo();
        rsi.setResourceId("RS001");
        rsi.setResourceType("Reference");
        rsi.setResourceTitle("IT309 – System development & implementation");
        rsi.setStatus("Functioning");
        rsi.setDescription("Study guide version 2");
        rsi.setComment("Informatics Edu. Library");
        rsi.setEvaluatorIdInfo(new UserIdInfo("TestID1", null));
        ResourceDao resDao = ResourceDao.getInstance();
        try
        {
                //to test whether update evaluating info function in Resource DAO works properly
            ResultInfo ri = resDao.updateEvaludatingInfo(rsi);
            if (ri.getResult())
            {
                System.out.println("Update evaluating success : "+rsi.getResourceId());
            } else {
                System.out.println("Update evaluating fail ");
            }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
