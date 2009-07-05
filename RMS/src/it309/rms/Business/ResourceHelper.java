package it309.rms.business;

import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.ResourceIdInfo;
import java.util.List;
import it309.rms.dao.IResourceDAO;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.UserIdInfo;

public class ResourceHelper implements IResourceHelper {

  public IResourceDAO resourceDAO;

  public ResultInfo getList(List resourceList) {
  return null;
  }

  public ResourceInfo getDetail(ResourceIdInfo resouceIdInfo) {
  return null;
  }

  public ResultInfo book(ResourceInfo resouceInfo) {
  return null;
  }

  public ResultInfo evaludate(ResourceInfo resourceInfo) {
  return null;
  }

  public ResultInfo cancelBooking(ResourceIdInfo resourceIdInfo) {
  return null;
  }

  public resultInfo getBookingList(UserIdInfo userIdInfo, List bookinglist) {
  return null;
  }
}