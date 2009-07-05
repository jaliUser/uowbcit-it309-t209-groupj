package it309.rms.presenter;

import String;

public interface IEmployeeUpdateView extends IAbstractBaseView, IAbstractBaseView, IAbstractBaseView {

  public void SetEmployeeId(String employeeId);

  public String GetEmployeeId();

  public void SetPassword(String password);

  public String GetPassword();

  public String SetName(String name);

  public String GetName();

  public void SetTitle(String title);

  public String GetTitle();

  public void SetAddress(String address);

  public String GetAddress();

  public void SetPhone(String number);

  public String GetPhone();

  public void SetEmail(String email);

  public String GetEmail();
}