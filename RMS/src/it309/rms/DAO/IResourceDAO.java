package it309.rms.dao;

import it309.rms.dataclass.ResultInfo;
import java.util.List;
import it309.rms.dataclass.ResourceInfo;

public interface IResourceDAO {

  public ResultInfo getList(List list);

  public ResultInfo getDetail(ResourceInfo resouceInfo);

  public ResultInfo book(ResourceInfo resourceInfo);

  public ResultInfo evaludate(ResourceInfo resourceInfo);

  public ResultInfo cancelBooking( resourceIdInfo);
}