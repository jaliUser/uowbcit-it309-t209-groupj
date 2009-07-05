package it309.rms.business;

import it309.rms.dataclass.ResultInfo;
import it309.rms.dao.IEmployeeDAO;
import java.util.List;
import it309.rms.dataclass.UserIdInfo;
import it309.rms.dataclass.EmployeeInfo;

public class EmployeeHelper extends UserHelper implements IUserHelper, IEmployeeHelper {

  public IEmployeeDAO employeeDAO;

  public ResultInfo getList(List list) {
  return null;
  }

  public ResultInfo getDetail(EmployeeInfo employeeInfo) {
  return null;
  }

  public ResultInfo add(EmployeeInfo employeeInfo) {
  return null;
  }

  public ResultInfo update(EmployeeInfo employeeInfo) {
  return null;
  }

  public ResultInfo delete(UserIdInfo userIdInfo) {
  return null;
  }

  public ResultInfo changeProfile(EmployeeInfo empleeInfo) {
  return null;
  }
}