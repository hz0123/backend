package coms.softra.RestfulWebService.Exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice //TODO what this?
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class) //Excception.class is your parent class for all exceptions
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) {
		CustomExceptionResponse cer = new CustomExceptionResponse(new Date(), "Exception occurred", ex.getMessage());
		return new ResponseEntity(cer,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class) //give annotation to ensure it handles a specific exception your UserNotFoundException.class will point to the specific error, if you change it is not present, it will point to Exception.class the method error above
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException unfe, WebRequest req){
		CustomExceptionResponse cer = new CustomExceptionResponse(new Date(), "User not found", unfe.getMessage());
		return new ResponseEntity(cer,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InsufficientBalanceException.class) 
	public final ResponseEntity<Object> handleInsufficientBalanceException(InsufficientBalanceException ibe, WebRequest req){
		CustomExceptionResponse cer = new CustomExceptionResponse(new Date(), "Insufficient balance", ibe.getMessage());
		return new ResponseEntity(cer,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			System.out.println("inside handleMethodArgumentNotValid");
			CustomExceptionResponse cer = new CustomExceptionResponse(new Date(), "Validation failed", ex.getMessage());
		return new ResponseEntity(cer,HttpStatus.BAD_REQUEST);
	}
	
}
