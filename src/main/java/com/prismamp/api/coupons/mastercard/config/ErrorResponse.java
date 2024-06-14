package com.prismamp.api.coupons.mastercard.config;

import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse{
	


	public static class ExceptionResponse extends Exception {

		private static final long serialVersionUID = 1L;

		private ETypeError error;
		private List<ErrorMessage> message = new ArrayList<>();

		public ExceptionResponse(ETypeError error, String message) {
			this.error = error;
			this.message.add(new ErrorMessage(error, message));
		}

		public ExceptionResponse(List<ErrorMessage> errors) {
			this.error = getMostError(errors);
			this.message.addAll(errors);
		}

		public ETypeError getError() {

			return this.error;
		}

		public List<ErrorMessage> takeMessage() {
			return this.message;
		}

	}

	@Getter
	public enum ETypeError {

		NOT_FOUND("NOT-FOUND", 404, "Bad Request", "Client request error"),
		FORBIDDEN("FORBIDDEN", 403, "Forbidden Resource", "The client is not authorized."),
		BAD_REQUEST("BAD-REQUEST", 400, "Bad Request", "The request is not valid."),
		INTERNAL_SERVER_ERROR("INTERNAL-SERVER-ERROR", 500, "Internal Server Error", "There was an unexpected error.");

		public static String API_PREFIX = "";

		private String code;
		private int status;
		private String title;
		private String message;

		ETypeError(String code, int status, String title, String message) {
			this.code = code;
			this.status = status;
			this.title = title;
			this.message = message;
		}

		public String getCode() {
			return API_PREFIX + this.code;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public void setCode(String code) {
			this.code = code;
		}
		
		

	}

	@Getter
	@AllArgsConstructor
	public static class ErrorMessage {
		private ETypeError type;
		private String message;
		
		
		public ETypeError getType() {
			return type;
		}


		public void setType(ETypeError type) {
			this.type = type;
		}


		public String getMessage() {
			return message;
		}


		public void setMessage(String message) {
			this.message = message;
		}
		
		
		
	}

	@Getter
	@Setter
	public class ErrorModel {
		private String code;
		private int status;
		private String title;
		private String message;
		private String instance;
		private List<ErrorMessage> details = null;

		public ErrorModel(ETypeError error_type) {
			this.code = error_type.getCode();
			this.status = error_type.getStatus();
			this.title = error_type.getTitle();
			this.message = error_type.getMessage();
		}

		public void addErrorMessage(ErrorMessage error) {
			if (this.details == null)
				this.details = new ArrayList<>();
			this.details.add(error);
		}

		public void addErrorMessage(List<ErrorMessage> errors) {
			if (this.details == null)
				this.details = new ArrayList<>();
			this.details.addAll(errors);
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getInstance() {
			return instance;
		}

		public void setInstance(String instance) {
			this.instance = instance;
		}

		public List<ErrorMessage> getDetails() {
			return details;
		}

		public void setDetails(List<ErrorMessage> details) {
			this.details = details;
		}
		
		
	}

	private ErrorModel error;

	public ErrorResponse(ExceptionResponse e, HttpServletRequest request) {
		this.errorResponse(e.getError(), request);
		this.addErrorMessage(e.takeMessage());
	}

	protected static ETypeError getMostError(List<ErrorMessage> e) {
		ErrorMessage exception = null;
		for (ErrorMessage ex : e) {
			if (exception == null) {
				exception = ex;
			} else if (ex.getType().getStatus() > exception.getType().getStatus())
				exception = ex;
		}
		return (exception != null) ? exception.getType() : ETypeError.INTERNAL_SERVER_ERROR;
	}

	public ErrorResponse(List<ErrorMessage> e, HttpServletRequest request) {
		this.errorResponse(getMostError(e), request);
		this.addErrorMessage(e.stream().map(ex -> new ErrorMessage(ex.getType(), ex.getMessage())).toList());
	}

	private void errorResponse(ETypeError error_type, HttpServletRequest request) {
		this.error = new ErrorModel(error_type);
		if (request != null)
			this.error.setInstance(request.getMethod() + " " + request.getContextPath());
	}

	private void addErrorMessage(List<ErrorMessage> errors) {
		this.error.addErrorMessage(errors);
	}

	public ErrorModel getError() {
		return error;
	}

	public void setError(ErrorModel error) {
		this.error = error;
	}

	
}
