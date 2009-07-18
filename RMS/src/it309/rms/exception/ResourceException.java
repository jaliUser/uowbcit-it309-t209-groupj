package it309.rms.exception;

public class ResourceException extends BaseException
{

    public ResourceException(String message) {
        super(message);
    }
    
	public ResourceException(String message, int errorType)
	{
		//catch exception if there is any error happened related to Suggestion
		super(message, errorType);
	}
}