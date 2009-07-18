/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.controller;

import it309.rms.view.BaseView;

/**
 *
 * @author khangdt
 */
public class BaseController {

    private BaseView view = null;

    public BaseController(BaseView view){
        this.view = view;
    }
}
