package it309.rms.dataclass;

import java.io.Serializable; 

public class ResultInfo  implements Cloneable, Serializable{
  /* {src_lang=Java}*/
    private Boolean result = true;

    private String message  = "";

    private int errorType = 2;

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }


}