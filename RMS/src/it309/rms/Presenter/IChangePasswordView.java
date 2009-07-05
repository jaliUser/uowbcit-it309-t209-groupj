package it309.rms.presenter;

import String;

public interface IChangePasswordView extends IAbstractBaseView {

  public void SetOldPassword(String oldPassword);

  private String GetOldPassword();

  public void SetNewPassword(String newPassword);

  public String GetNewPassword();

  public void SetConfirmPassword(String confirmPassword);

  public String GetConfirmPassword();
}