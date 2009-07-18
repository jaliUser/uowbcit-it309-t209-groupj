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

        public final static String RESOURCE_NOT_EXIST = "RESOURCE_NOT_EXIST";

        public final static String UNAUTHORIZED_TO_CANCEL = "UNAUTHORIZED_TO_CANCEL";

        public final static String NO_DATA_UPDATED = "NO_DATA_UPDATED";

        public final static String EXEPTION_MESSAGE = "%s:: exception= %s";

        public final static String CHANGED_PASSWORD = "CHANGED_PASSWORD";

        public final static String BOOKED_RESOUCE = "BOOKED_RESOUCE";

        public final static String ADDED_EMPLOYEE = "ADDED_EMPLOYEE";

        public final static String UPDATED_EMPLOYEE = "UPDATED_EMPLOYEE";

        public final static String EVALUATED_RESOURCE = "EVALUATED_RESOURCE";

        public final static String CANCELLED_BOOKING = "CANCELLED_BOOKING";

        public final static String DETELETED_EMPLOYEE = "DETELETED_EMPLOYEE";

        public final static String NO_OBJECT_SELECTED = "NO_OBJECT_SELECTED";

        public final static String REQUIRED_FIELD = "The %s is required.";
    }

    public class ErrorType {
        public final static int ERROR = 0;
        public final static int INFORM = 1;
        public final static int WARNING = 2;
    }

    public class Entity {

        public final static String ID = "id";
        
        public final static String NAME = "name";

        public final static String TITLE = "title";

        public final static String TYPE = "type";

        public final static String STATUS = "status";

        public final static String AUTHOR_ID = "author_id";
    }

    //Resource's status constants
    public static class ResourceStatus{
        public final static String BOOKED = "Booked";
        public final static String APPROVED = "Approved";
        public final static String DAMAGED = "Damaged";
        public final static String MAINTAINANCE = "Under maintenance";
        public final static String FUNCTIONING = "Functioning";
    }

    public static class UserType{
        public static final int ADMIN_LOGIN = 1;
        public static final int EMPLOYEE_LOGIN = 0;

    }

    public static class EmployeeAction
    {
        public static final int EDIT = 1;
        public static final int ADD = 0;
    }

    public static class Data{
        public static final String DateFormat = "yyyy-mm-dd";
    }
    
}
