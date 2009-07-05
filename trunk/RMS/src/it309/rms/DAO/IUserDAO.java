package it309.rms.dao;

import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;

public interface IUserDAO {

  public ResultInfo changePassword(UserIdInfo oldStaffIdInfo, UserIdInfo newStaffIdInfo);

  public ResultInfo getUserId(UserIdInfo userIdInfo);
}