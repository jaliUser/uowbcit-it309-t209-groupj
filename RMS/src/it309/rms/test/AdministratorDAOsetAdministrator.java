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

public class AdministratorDAOsetAdministrator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdministratorInfo admin = new AdministratorInfo("admin", "nimda");
        AdministratorDao adminDAO = AdministratorDao.getInstance();
        try
        {
                //to test whether setAdministrator function in Administrator DAO works properly
                adminDAO.setAdministrator(admin);
                System.out.println("Admin Password Changed : " + adminDAO.getAdministrator("admin"));
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
