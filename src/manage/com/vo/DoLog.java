package manage.com.vo;


public class DoLog {

  private long id;
  private String username;
  private String depName;
  private String roleName;
  private String loginIp;
  private java.sql.Timestamp loginTime;
  private String function;
  private java.sql.Timestamp doTime;
  private long status;
  private java.sql.Timestamp logoutTime;


  public java.sql.Timestamp getLogoutTime() {
	return logoutTime;
}

public void setLogoutTime(java.sql.Timestamp logoutTime) {
	this.logoutTime = logoutTime;
}

public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getDepName() {
    return depName;
  }

  public void setDepName(String depName) {
    this.depName = depName;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  public String getLoginIp() {
    return loginIp;
  }

  public void setLoginIp(String loginIp) {
    this.loginIp = loginIp;
  }


  public java.sql.Timestamp getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(java.sql.Timestamp loginTime) {
    this.loginTime = loginTime;
  }


  public String getFunction() {
    return function;
  }

  public void setFunction(String function) {
    this.function = function;
  }


  public java.sql.Timestamp getDoTime() {
    return doTime;
  }

  public void setDoTime(java.sql.Timestamp doTime) {
    this.doTime = doTime;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }

}
