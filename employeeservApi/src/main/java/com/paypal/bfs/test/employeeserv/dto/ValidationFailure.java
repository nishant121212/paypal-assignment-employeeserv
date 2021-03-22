package com.paypal.bfs.test.employeeserv.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * The ApiResponse object
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "field",
    "message"
})
public class ValidationFailure {
	
	/**
	 * field name
	 */
        @JsonProperty("field")
        @JsonPropertyDescription("field name")
        private String field;
	
	/**
	 * validation failure message
	 */
	@JsonProperty("message")
        @JsonPropertyDescription("validation failure message")
	private String message;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
