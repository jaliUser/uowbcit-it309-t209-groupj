package it309.rms.exception;

public class BaseException extends Exception
{

    private int errorType = 0;

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public BaseException(String message)
	{
		//catch exception if there is any error happened related to Administrator
		super(message);
	}

    public BaseException(String message, int errorType)
	{
		//catch exception if there is any error happened related to Administrator
		super(message);
        this.errorType = errorType;
	}

}