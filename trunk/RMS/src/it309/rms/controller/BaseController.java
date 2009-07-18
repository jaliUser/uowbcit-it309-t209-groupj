/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.dataclass.UserIdInfo;
import it309.rms.view.BaseView;

/**
 *
 * @author khangdt
 */
public class BaseController {

    private BaseView view = null;

    BaseView preView;

    public void setPreView(BaseView preView) {
        this.preView = preView;
    }

    private static UserIdInfo userIdInfo = new UserIdInfo();

    public static UserIdInfo getUserIdInfo() {
        return userIdInfo;
    }

    public BaseController(){
        
    }

    public BaseController(BaseView view){
        this.view = view;
    }
}
