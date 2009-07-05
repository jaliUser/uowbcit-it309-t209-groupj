package it309.rms.presenter;

import String;

public interface IAbstractBaseView {

  public void displayErrorMessage(String msg);

  public void displayMessageConfirm(String msg);

  public void displayInfoMessage(String msg);

  public void close();

  public void exit();

  public void show();
}