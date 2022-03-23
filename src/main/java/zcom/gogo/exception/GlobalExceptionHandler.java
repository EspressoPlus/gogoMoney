package zcom.gogo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// https://www.journaldev.com/2651/spring-mvc-exception-handling-controlleradvice-exceptionhandler-handlerexceptionresolver

@ControllerAdvice // pom.xml added https://mvnrepository.com/artifact/org.springframework/spring-aop
public class GlobalExceptionHandler {

	//@ExceptionHandler(MethodArgumentNotValidException.class) // https://stackoverflow.com/questions/52364851/how-to-handle-exception-thrown-by-object-in-requestbody-in-spring-boot-2
	
	@ExceptionHandler
	// function can have any name .. doesn't have to be handleException()
	public ResponseEntity<ErrorResponse> handleException(NotFoundException e){
		// need to return a ResponseEntity object
		ErrorResponse error = new ErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND );
	}
	
	// what if user sends nonsense string instead of int??
	// i.e. user gets a MethodArguemntTypeMismatchException
	// so, make another exception handler that is more generic
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception e) {
		ErrorResponse error = new ErrorResponse();
		error.setMessage(e.getMessage()); // could throw a different error that is different/better than default
		error.setStatus(HttpStatus.BAD_REQUEST.value()); // changed to BAD_REQUEST
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST );
	}

}
