package it309.rms.business;

import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;

public interface IUserHelper {

  public ResultInfo changePassword(UserIdInfo oldStaffIdInfo, UserIdInfo newStaffIdInfo);

  public ResultInfo authenticate(UserIdInfo userIdInfo);
}