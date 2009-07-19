/*
 * This is a class used to contain data from Resource and Employee table
 * and tranfer data between layers.
 */

package it309.rms.dataclass;

import java.io.Serializable;
import java.sql.Date;

public class ResourceInfo extends ResourceIdInfo implements Cloneable, Serializable{

    private String description = "";

    private String status = "";

    private String purpose = "";

    private Date date_entered;

    private Date date_required;

    private Date date_return;

    private UserIdInfo evaluatorIdInfo;

    private UserIdInfo authorIdInfo;

    private String comment = "";

    private Date date_evaluated;

    public Date getDate_evaluated() {
        return date_evaluated;
    }

    public void setDate_evaluated(Date date_evaluated) {
        this.date_evaluated = date_evaluated;
    }

    public UserIdInfo getAuthorIdInfo() {
        return authorIdInfo;
    }

    public void setAuthorIdInfo(UserIdInfo authorIdInfo) {
        this.authorIdInfo = authorIdInfo;
    }

    public Date getDate_entered() {
        return date_entered;
    }

    public void setDate_entered(Date date_entered) {
        this.date_entered = date_entered;
    }

    public Date getDate_required() {
        return date_required;
    }

    public void setDate_required(Date date_required) {
        this.date_required = date_required;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserIdInfo getEvaluatorIdInfo() {
        return evaluatorIdInfo;
    }

    public void setEvaluatorIdInfo(UserIdInfo evaluatorIdInfo) {
        this.evaluatorIdInfo = evaluatorIdInfo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate_return() {
        return date_return;
    }

    public void setDate_return(Date date_return) {
        this.date_return = date_return;
    }


}