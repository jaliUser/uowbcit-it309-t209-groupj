package it309.rms.business;

import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.ResourceIdInfo;
import java.util.List;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.UserIdInfo;

public interface IResourceHelper {

  public ResultInfo getList(List resourceList);

  public ResourceInfo getDetail(ResourceIdInfo resouceIdInfo);

  public ResultInfo book(ResourceInfo resouceInfo);

  public ResultInfo evaludate(ResourceInfo resourceInfo);

  public ResultInfo cancelBooking(ResourceIdInfo resourceIdInfo);

  public resultInfo getBookingList(UserIdInfo userIdInfo, List bookinglist);
}