/*
 * This is a class used to contain data from Administrator table
 * and tranfer data between layers.
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
