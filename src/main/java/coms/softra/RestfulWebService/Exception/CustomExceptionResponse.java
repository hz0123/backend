package coms.softra.RestfulWebService.Exception;

import java.util.Date;

public class CustomExceptionResponse {
	private Date timeStamp;
	private String msg;
	private String detailedMsg;
	public CustomExceptionResponse(Date timeStamp, String msg, String detailedMsg) {
		super();
		this.timeStamp = timeStamp;
		this.msg = msg;
		this.detailedMsg = detailedMsg;
	}
	
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetailedMsg() {
		return detailedMsg;
	}
	public void setDetailedMsg(String detailedMsg) {
		this.detailedMsg = detailedMsg;
	}
	
}
