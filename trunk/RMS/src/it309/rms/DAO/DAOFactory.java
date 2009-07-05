package it309.rms.dao;

public class DAOFactory implements IUserDAO, IEmployeeDAO, IResourceDAO {

  public IUserDAO getUserDAOInstance() {
  return null;
  }

  public IEmployeeDAO getEmployeeDAOInstance() {
  return null;
  }

  public IResourceDAO getResourceDAOInstance() {
  return null;
  }
}