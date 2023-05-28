package com.example.demo;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalHandlerException  {  // Using REST, specific and global exception is used
	                                    //to get displayed on the POSTMAN when hit by the user

// Handle a specific exception
//We use these specific and global exception to reduce the error content description when hit by user.
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException excep,WebRequest req) {
		
		ErrorDetails details=new ErrorDetails(new Date(),excep.getMessage(),req.getDescription(false));
    return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);	
    		}
	
			
// Handle a Global exception
			  
   @ExceptionHandler(Exception.class)
   public ResponseEntity<?> handleException(Exception excep,WebRequest req) {
			  
        ErrorDetails details=new ErrorDetails(new Date(),excep.getMessage(),req.getDescription(false)); 
    return new ResponseEntity<>(details,HttpStatus.INTERNAL_SERVER_ERROR); 
    }
   

//Handle a specific exception-------Problem?
   @ExceptionHandler(DeleteNotDoneByIdException.class)
   public ResponseEntity<?> handleDeleteNotDoneByIdException(DeleteNotDoneByIdException excep, WebRequest req) {
	   ErrorDetails details=new ErrorDetails(new Date(),excep.getMessage(),req.getDescription(false));
     return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
   }
   
	
}
