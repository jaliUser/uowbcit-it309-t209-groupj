package it309.rms.presenter;

import String;

public interface IBookingResourceListView extends IAbstractBaseView {

  public String SelectedResourceId();

  public void BindDataToTable(String columns[], Object data[][]);
}