/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.dataclass;

import java.io.Serializable;

/**
 *
 * @author khangdt
 */
public class AdministratorInfo extends UserIdInfo  implements Cloneable, Serializable{

    public AdministratorInfo() {
    }

    public AdministratorInfo(String id, String password) {
        super(id, password);
    }

}
