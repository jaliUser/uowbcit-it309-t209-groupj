/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it309.rms.dataclass;

/**
 *
 * @author khangdt
 */
public class DataConstant {
    public class Message {
        
        public final static String USER_NOT_EXIST = "USER_NOT_EXIST";

        public final static String NO_DATA_UPDATED = "NO_DATA_UPDATED";

        public final static String EXEPTION_MESSAGE = "{0}:: exception= {1}";
    }

    public class ErrorType {
        public final static int ERROR = 0;
        public final static int INFORM = 1;
        public final static int WARNING = 2;
    }

    public class Entity {

        public final static String ID = "id";
        public final static String NAME = "name";

    }
    
}
