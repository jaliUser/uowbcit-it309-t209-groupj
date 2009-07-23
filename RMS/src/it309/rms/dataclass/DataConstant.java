/*
 * This class contains constant datas of the system.s
 */

package it309.rms.dataclass;

/**
 *
 * @author khangdt
 */
public class DataConstant {

    //Messages which are used to show to user.
    public class Message {
        
        public final static String USER_NOT_EXIST = "Please verify your id and password.";

        public final static String RESOURCE_NOT_EXIST = "The resource does not exist.";

        public final static String UNAUTHORIZED_TO_CANCEL = "Your resource is in approved status, pls contact with validator for functioning this resource.";

        public final static String NO_DATA_UPDATED = "There is a system error, the data is not updated.";

        public final static String EXEPTION_MESSAGE = "%s:: exception= %s";

        public final static String CHANGED_PASSWORD = "The password is changed.";

        public final static String BOOKED_RESOUCE = "The resource is booked. Pls wait for approvement.";

        public final static String ADDED_EMPLOYEE = "The Employee is added.";

        public final static String UPDATED_EMPLOYEE = "The Employee is updated.";

        public final static String EVALUATED_RESOURCE = "The resource is evaluated.";

        public final static String CANCELLED_BOOKING = "The resource booking is cancelled.";

        public final static String DETELETED_EMPLOYEE = "The Employee is removed.";

        public final static String NO_OBJECT_SELECTED = "Pls select an object to do the action.";

        public final static String REQUIRED_FIELD = "The %s is required.";
        
        public final static String PASSWORDS_NOT_MATCH = "The entered passwords do not match.";
        
        public final static String WRONG_DATE_FORMAT = "The entered dates are not in the format 'yyyy-mm-dd'.";

        public final static String UNAVAILABLE_RESOURCE = "The selected resource is now unavailable. Pls book functioning resources.";

        public final static String EMPLOYEE_EXISTS = "The Employee Id exists, please choose another.";

    }

    //Fields which are used in validation to inform user which exactly field is illegal.
    public class FieldName{

        public final static String NEW_PASSWORD = "New Password";

        public final static String OLD_PASSWORD = "Old Password";

        public final static String CONFIRM_PASSWORD = "Confirm Password";

        public final static String EMPLOYEE_ID = "Employee Id";

        public final static String EMPLOYEE_PASSWORD = "Employee Password";

        public final static String EMPLOYEE_NAME = "Employee Name";

        public final static String EMAIL = "Email";

        public final static String PHONE = "Phone";

        public final static String ADDRESS = "Address";

        public final static String REQUESTING_DATE = "Requesting Date";

        public final static String RETURN_DATE = "Return Date";

        public final static String PURPOSE = "Purpose";
    }

    //To select type of message box to show.
    public class ErrorType {
        public final static int ERROR = 0;
        public final static int INFORM = 1;
        public final static int WARNING = 2;
    }

    /*
     * These entities are names of columns in database.
     * They are used in DAO layer to select column for searching data.
     */
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
        public final static String APPROVED = "Booked-Approved";
        public final static String DAMAGED = "Damaged";
        public final static String MAINTAINANCE = "Under maintenance";
        public final static String FUNCTIONING = "Functioning";
    }

    //To separate type of User
    public static class UserType{
        public static final int ADMIN_LOGIN = 1;
        public static final int EMPLOYEE_LOGIN = 0;

    }

    //This constants is used to distinguish from editing and adding employee
    public static class EmployeeAction
    {
        public static final int EDIT = 1;
        public static final int ADD = 0;
    }


    //To identify format of input data for user.
    public static class DataFormat{
        public static final String DateFormat = "yyyy-mm-dd";
    }
    
}
