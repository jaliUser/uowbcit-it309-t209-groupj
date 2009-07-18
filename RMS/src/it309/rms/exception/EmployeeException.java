package it309.rms.exception;

public class EmployeeException extends BaseException
{

    public EmployeeException(String message) {
        super(message);
    }
    
	public EmployeeException(String message, int errorType)
	{
		//catch exception if there is any error happened related to Employee
		super(message, errorType);

	}
}