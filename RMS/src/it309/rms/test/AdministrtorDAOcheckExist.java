/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;
import it309.rms.dao.AdministratorDao;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;
/**
 *
 * @author DucQuang
 */
public class AdministrtorDAOcheckExist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserIdInfo uid = new UserIdInfo("admin","nimda");
        AdministratorDao admDao = AdministratorDao.getInstance();
        //to test whether check exist administrator function in Administrator DAO works properly
        try
        {
                ResultInfo ri = admDao.checkExist(uid);
                if (ri.getResult())
                {
                    System.out.println("User existed : "+uid.getId());
                } else {
                    System.out.println("Not existed user: "+uid.getId());                    
                }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
