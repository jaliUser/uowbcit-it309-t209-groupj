/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.test;

/**
 *
 * @author DucQuang
 */
import it309.rms.dao.AdministratorDao;
import it309.rms.dataclass.AdministratorInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;

public class AdministratorDAOsetAdministrator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserIdInfo admin = new UserIdInfo("admin", "nimda");
        AdministratorDao adminDAO = AdministratorDao.getInstance();
        try
        {
                //to test whether setAdministrator function in Administrator DAO works properly
                ResultInfo ri = adminDAO.updatePassword(admin);
                if (ri.getResult())
                {
                    System.out.println("Admin Password Changed : " + admin.getPassword());
                } else {
                    System.out.println("Change Password Failed");
                }
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
