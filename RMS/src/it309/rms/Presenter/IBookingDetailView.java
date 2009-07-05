package it309.rms.presenter;

import String;

public interface IBookingDetailView extends IAbstractBaseView {

  public void SetResourceId(String resourceId);

  public String GetResourceId();

  public void SetResourceName(String resourceName);

  public String GetResourceName();

  public void SetResourceType(String resourceType);

  public String GetResourceType();

  public void SetStatus(String status);

  public String GetStatus();

  public void SetDescription(void String);

  public String GetDescription();

  public void SetPurpose(String purpose);

  public String GetPurpose();

  public void SetAuthorId(String author);

  public String GetAuthorId();

  public void SetAuthorName(String authorName);

  public void SetOthers(String others);

  public String GetOthers();
}