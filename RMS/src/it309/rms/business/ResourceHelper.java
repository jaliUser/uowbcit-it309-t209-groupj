/*
 * This is a class is responsible for proccessing business logic which relates to Resource
 * and call functions of DAO classes.
 */

package it309.rms.business;

import it309.rms.dao.ResourceDao;
import it309.rms.dataclass.DataConstant;
import it309.rms.dataclass.ResourceInfo;
import it309.rms.dataclass.ResultInfo;
import it309.rms.dataclass.UserIdInfo;
import it309.rms.exception.ResourceException;
import java.util.Collection;

/**
 *
 * @author khangdt
 */
public class ResourceHelper {

    // The class variable, dao, is reference to the only instance of this class
	private static ResourceHelper helper = null;

    // 	Other class should call this method to get the only instance of this class
	// 	The instantiation of object is on demand only
	//	The method is thread-safe
	public static ResourceHelper getInstance()
	{
		if (helper == null)
		{
			synchronized (ResourceHelper.class)
			{
				if (helper == null)
				{
					helper = new ResourceHelper();
				}
			}
		}
		return helper;
	}

    //Process of search resource
    public ResultInfo searchByTextField(String field, String condition, Collection list) throws ResourceException
    {
        ResultInfo resultInfo = null;
        try
        {
            resultInfo = ResourceDao.getInstance().searchResource(field, condition, list);

        }
        catch (ResourceException e)
        {
            resultInfo.setResult(false);
            resultInfo.setMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                         this.getClass().getName(),e.getMessage()));
        }
         finally
        {
            return resultInfo;
        }
    }

    //Process of get resources booking
    public ResultInfo getMyResources(String id, Collection list) throws ResourceException
    {
        ResultInfo resultInfo = null;
        try
        {
            resultInfo = ResourceDao.getInstance().getResourceByAuthorId(id, list);
        }
        catch (ResourceException e)
        {
            resultInfo.setResult(false);
            resultInfo.setMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                         this.getClass().getName(),e.getMessage()));
        }
         finally
        {
            return resultInfo;
        }
    }

    //Process of getting resource by Id
    public ResultInfo getResourceById(String id, ResourceInfo resourceInfo) throws ResourceException
    {
        ResultInfo resultInfo = null;
        try
        {
            resultInfo = ResourceDao.getInstance().getResource(id, resourceInfo);
        }
        catch (ResourceException e)
        {
            resultInfo.setResult(false);
            resultInfo.setMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                         this.getClass().getName(),e.getMessage()));
        }
         finally
        {
            return resultInfo;
        }
    }

    //Process of booking resource
    public ResultInfo book(ResourceInfo resourceInfo) throws ResourceException
    {
        ResultInfo resultInfo = null;
        try
        {
            resourceInfo.setStatus(DataConstant.ResourceStatus.BOOKED);
            resultInfo = ResourceDao.getInstance().updateBookingInfo(resourceInfo);

        }
        catch (ResourceException e)
        {
            resultInfo.setResult(false);
            resultInfo.setMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                         this.getClass().getName(),e.getMessage()));
        }
         finally
        {
            return resultInfo;
        }
    }

    //Process of resource evaluation
    public ResultInfo Evaluate(ResourceInfo resourceInfo) throws ResourceException
    {
        ResultInfo resultInfo = null;
        try
        {
            if (DataConstant.ResourceStatus.APPROVED.equals(resourceInfo.getStatus()))
            {
                resultInfo = ResourceDao.getInstance().updateEvaludatingInfo(resourceInfo);
            }
            else
            {
                resourceInfo.setAuthorIdInfo(new UserIdInfo(null,null));
                resultInfo = ResourceDao.getInstance().updateBookingAndEvaluatingInfo(resourceInfo);
            }

        }
        catch (ResourceException e)
        {
            resultInfo.setResult(false);
            resultInfo.setMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                         this.getClass().getName(),e.getMessage()));
        }
         finally
        {
            return resultInfo;
        }
    }

    //Process of cancel booking
    public ResultInfo cancelBooking(ResourceInfo resourceInfo) throws ResourceException
    {
        ResultInfo resultInfo = null;
        try
        {
            ResourceInfo resourceInfoTemp = new ResourceInfo();

            resultInfo = ResourceDao.getInstance().getResource(resourceInfo.getResourceId(), resourceInfoTemp);

            if (resultInfo.getResult() &&
                    resourceInfoTemp.getAuthorIdInfo().getId().equals(resourceInfo.getAuthorIdInfo().getId()) &&
                    !resourceInfoTemp.getStatus().equals(DataConstant.ResourceStatus.APPROVED))
            {
                resourceInfo.setStatus(DataConstant.ResourceStatus.FUNCTIONING);
                resourceInfo.setAuthorIdInfo(new UserIdInfo(null,null));
                resultInfo = ResourceDao.getInstance().updateBookingInfo(resourceInfo);
            }
            else if (resultInfo.getResult())
            {
                resultInfo.setResult(false);
                resultInfo.setMessage(DataConstant.Message.UNAUTHORIZED_TO_CANCEL);
            }

        }
        catch (ResourceException e)
        {
            resultInfo.setResult(false);
            resultInfo.setMessage(String.format(DataConstant.Message.EXEPTION_MESSAGE,
                                                         this.getClass().getName(),e.getMessage()));
        }
        finally
        {
            return resultInfo;
        }
    }
}
