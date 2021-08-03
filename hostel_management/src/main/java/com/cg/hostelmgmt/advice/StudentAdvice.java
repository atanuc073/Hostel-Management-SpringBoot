package com.cg.hostelmgmt.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.hostelmgmt.dto.ErrorMessage;
import com.cg.hostelmgmt.exception.EmailIdAlreadyExistsException;
import com.cg.hostelmgmt.exception.HostelNotFoundException;
import com.cg.hostelmgmt.exception.PhoneNumberAlreadyExistsException;
import com.cg.hostelmgmt.exception.RoomNotFoundException;
import com.cg.hostelmgmt.exception.WardenNotFoundException;

@RestControllerAdvice
public class StudentAdvice {
	@ExceptionHandler(WardenNotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ErrorMessage handleExceptionWardenNotFound(WardenNotFoundException ex) {
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
		
	}
	@ExceptionHandler(HostelNotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ErrorMessage handleExceptionHostelNotFound(HostelNotFoundException ex) {
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
		
	}
	@ExceptionHandler(RoomNotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ErrorMessage handleExceptionRoomNotFound(RoomNotFoundException ex) {
		return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage());
		
	}
	@ExceptionHandler(PhoneNumberAlreadyExistsException.class)
	@ResponseStatus(code=HttpStatus.NOT_ACCEPTABLE)
	public ErrorMessage handleExceptionPhoneNumberAlreadyExists(PhoneNumberAlreadyExistsException ex) {
		
		return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.toString(), ex.getMessage());
		
	}
	@ExceptionHandler(EmailIdAlreadyExistsException.class)
	@ResponseStatus(code=HttpStatus.NOT_ACCEPTABLE)
	public ErrorMessage handleExceptionEmailIdAlreadyExists(EmailIdAlreadyExistsException ex) {
		return new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.toString(), ex.getMessage());
		
	}

}
