package com.paypal.bfs.test.employeeserv.exception;

/**
 * Error code enum
 * 
 */
public enum ErrorCode {
	BAD_REQUEST("E00001", "Invalid request"),
	METHOD_NOT_ALLOWED("E00002", "Http request method not supported"),
	UNSUPPORTED_MEDIA_TYPE("E00003", "Http media type not supported"),
	NOT_ACCEPTABLE("E00004", "Http media type not acceptable"),
	EMPLOYEE_NOT_FOUND("E00005", "Requested employee does not exist"),
	EMPLOYEE_SERVICE_EXCPTION("E00006", "Something went wrong, Please try later"),
	INTERNAL_SERVER_ERROR("E00007", "Currently, we are unable to serve your request. Please try again later"),
	DATA_BASE_EXCEPTION("E00008", "Currently, we are unable to serve your request. Please try again later");
	
	/**
	 * error code
	 */
	private String code;

	/**
	 * error message
	 */
	private String msg;
	
	ErrorCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public String getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}

}
