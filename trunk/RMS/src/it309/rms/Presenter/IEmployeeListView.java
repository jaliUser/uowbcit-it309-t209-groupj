package it309.rms.presenter;

import String;

public interface IEmployeeListView extends IAbstractBaseView {

  public String SelectedEmployeeId();

  public void BindDataToTable(String columns[], Object data[][]);
}