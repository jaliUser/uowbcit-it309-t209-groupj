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

public class AdministratorDAOgetAdministrator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdministratorDao adminDAO = AdministratorDao.getInstance();
        try
        {
                //to test whether getAdministrator function in Administrator DAO works properly
                System.out.println("Admin Password Changed : " + adminDAO.getAdministrator("admin"));
        }
        catch(Exception ex)
        {
                ex.printStackTrace();
        }
    }

}
