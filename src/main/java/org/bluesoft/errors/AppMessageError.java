package org.bluesoft.errors;

public class AppMessageError {
 
  private String message;
  private Boolean status;
  //private Throwable throwable;

  public String getMessage() {
      return message;
  }

  /*public Throwable getThrowable() {
    return throwable;
}

public void setThrowable(Throwable throwable) {
    this.throwable = throwable;
}*/

public void setMessage(String message) {
      this.message = message;
  }

  public Boolean getStatus() {
      return status;
  }

  public void setStatus(Boolean status) {
      this.status = status;
  }

  public AppMessageError(String message, Boolean status) {
      super();
      this.message = message;
      this.status = status;
  }
  /*public AppMessageError(String message,Throwable throwable) {
    super();
    this.message = message;
    this.throwable = throwable;
}
  public AppMessageError(String message, Boolean status,Throwable throwable) {
    super();
    this.message = message;
    this.status = status;
    this.throwable = throwable;
}*/

  public AppMessageError() {
      super();
  }
}
