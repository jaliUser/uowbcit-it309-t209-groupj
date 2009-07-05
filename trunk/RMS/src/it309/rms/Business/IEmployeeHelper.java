package it309.rms.business;

import it309.rms.dataclass.ResultInfo;
import java.util.List;
import it309.rms.dataclass.UserIdInfo;
import it309.rms.dataclass.EmployeeInfo;

public interface IEmployeeHelper extends IUserHelper {

  public ResultInfo getList(List list);

  public ResultInfo getDetail(EmployeeInfo employeeInfo);

  public ResultInfo add(EmployeeInfo employeeInfo);

  public ResultInfo update(EmployeeInfo employeeInfo);

  public ResultInfo delete(UserIdInfo userIdInfo);

  public ResultInfo changeProfile(EmployeeInfo empleeInfo);
}