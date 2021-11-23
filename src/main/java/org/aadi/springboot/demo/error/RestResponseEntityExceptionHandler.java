package org.aadi.springboot.demo.error;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.aadi.springboot.demo.entity.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {
	
	//To handle various ResponseEntity types exceptions.

    @Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
    	String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Request Method is not supported.");
		details.add(ex.getMessage());
        ErrorMessage errors = new ErrorMessage(message,details,status,LocalDateTime.now());

        return ResponseEntity.status(status)
                .body(errors);
    	
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Media Type is not supported.");
		details.add(ex.getMessage());
        ErrorMessage errors = new ErrorMessage(message,details,status,LocalDateTime.now());

        return ResponseEntity.status(status)
                .body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Path Variable is missing.");
		details.add(ex.getMessage());
        ErrorMessage errors = new ErrorMessage(message,details,status,LocalDateTime.now());

        return ResponseEntity.status(status)
                .body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Message is not readable.");
		details.add(ex.getMessage());
        ErrorMessage errors = new ErrorMessage(message,details,status,LocalDateTime.now());

        return ResponseEntity.status(status)
                .body(errors);
	}
	
	//To handle specific exceptions.

	@ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException ex,
                                                                    WebRequest request) {
    	String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("DepartmentNotFoundException Occured.");
		details.add(ex.getMessage());
        ErrorMessage errors = new ErrorMessage(message,details,HttpStatus.NOT_FOUND,
        		LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errors);
    }
	
	//To handle generic global types exceptions, for all other cases.
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleOtherException(Exception ex) {
		
		String message = ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add("Some Other Exception");
		details.add(ex.getMessage());
        ErrorMessage error = new ErrorMessage(message,details,HttpStatus.BAD_REQUEST,
                LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}
