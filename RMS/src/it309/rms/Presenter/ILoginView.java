package it309.rms.presenter;

import String;

public interface ILoginView extends IAbstractBaseView {

  public void SetUserId(String userId);

  public String GetUserId();

  public void SetPassword(String password);

  public String GetPassword();
}