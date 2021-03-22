package com.paypal.bfs.test.employeeserv.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.paypal.bfs.test.employeeserv.exception.ErrorCode;

/**
 * 
 * The ApiResponse object
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "message"
})
public class ApiResponse {
    
    /**
     * error code
     * 
     */
    @JsonProperty("code")
    @JsonPropertyDescription("error code")
    private String code;
    
    /**
     * error message
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("error message")
    private String message;
    
    
    /**
     * fieldValidation object
     */
    @JsonProperty("fieldValidation")
    @JsonPropertyDescription("fieldValidation object")
    private List<ValidationFailure> fieldValidation;
    
    /**
     * instantiates ApiResponse object with ErrorCode
     * 
     * @param errorCode {@link ErrorCode}
     */
	public ApiResponse(ErrorCode errorCode) {
		this.code = errorCode.getCode();
		this.message = errorCode.getMsg();
	}

	public List<ValidationFailure> getFieldValidation() {
		return fieldValidation;
	}

	public void setFieldValidation(List<ValidationFailure> fieldValidation) {
		this.fieldValidation = fieldValidation;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
