package it309.rms.exception;

public class AdministratorException extends BaseException
{

    public AdministratorException(String message) {
        super(message);
    }
    
	public AdministratorException(String message, int errorType)
	{
		//catch exception if there is any error happened related to Administrator
		super(message, errorType);
	}
}