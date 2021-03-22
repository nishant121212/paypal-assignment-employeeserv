package com.paypal.bfs.test.employeeserv.exception.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.paypal.bfs.test.employeeserv.dto.ApiResponse;
import com.paypal.bfs.test.employeeserv.dto.ValidationFailure;
import com.paypal.bfs.test.employeeserv.exception.EmployeeNotFoundException;
import com.paypal.bfs.test.employeeserv.exception.EmployeeServiceException;
import com.paypal.bfs.test.employeeserv.exception.ErrorCode;

/**
 * Application Exception Handler controller advice
 *
 */
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
        public ResponseEntity<Object> handleExceptions(EmployeeNotFoundException employeeNotFoundException, WebRequest webRequest) {
           ApiResponse apiResponse = new ApiResponse(ErrorCode.EMPLOYEE_NOT_FOUND);
           return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
        }
	
	@ExceptionHandler(EmployeeServiceException.class)
        public ResponseEntity<Object> handleExceptions(EmployeeServiceException employeeServiceException, WebRequest webRequest) {
           ApiResponse apiResponse = new ApiResponse(ErrorCode.EMPLOYEE_SERVICE_EXCPTION);
           return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	
	@ExceptionHandler(DataAccessException.class)
        public ResponseEntity<Object> handleExceptions(DataAccessException dataAccessException, WebRequest webRequest) {
           ApiResponse apiResponse = new ApiResponse(ErrorCode.DATA_BASE_EXCEPTION);
           return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	
	@ExceptionHandler(Exception.class)
        public ResponseEntity<Object> handleExceptions(Exception exception, WebRequest webRequest) {
           ApiResponse apiResponse = new ApiResponse(ErrorCode.INTERNAL_SERVER_ERROR);
           return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		if(ex instanceof MethodArgumentNotValidException) {
			ApiResponse apiResponse = new ApiResponse(ErrorCode.BAD_REQUEST);
	        List<ValidationFailure> validationFailures = new ArrayList<>();
	        ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors().forEach(e -> {
	            String fieldName = ((FieldError) e).getField();
	            String errorMessage = e.getDefaultMessage();
	            ValidationFailure validationFailure = new ValidationFailure();
	            validationFailure.setField(fieldName);
	            validationFailure.setMessage(errorMessage);
	            validationFailures.add(validationFailure);
	        });
	        apiResponse.setFieldValidation(validationFailures);
	        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
		}else if (ex instanceof HttpRequestMethodNotSupportedException) {
			ApiResponse apiResponse = new ApiResponse(ErrorCode.METHOD_NOT_ALLOWED);
			return new ResponseEntity<>(apiResponse, HttpStatus.METHOD_NOT_ALLOWED);
		}else if (ex instanceof HttpMediaTypeNotSupportedException) {
			ApiResponse apiResponse = new ApiResponse(ErrorCode.UNSUPPORTED_MEDIA_TYPE);
			return new ResponseEntity<>(apiResponse, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
		}else if (ex instanceof HttpMediaTypeNotAcceptableException) {
			ApiResponse apiResponse = new ApiResponse(ErrorCode.NOT_ACCEPTABLE);
			return new ResponseEntity<>(apiResponse, HttpStatus.NOT_ACCEPTABLE);
		}else return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	
}
