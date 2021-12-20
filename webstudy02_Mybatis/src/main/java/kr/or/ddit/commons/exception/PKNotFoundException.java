package kr.or.ddit.commons.exception;

/**
 * 식별자로 상세조회할 대상이 존재하지 않을때 발생.
 * @author PC22
 *
 */
public class PKNotFoundException extends RuntimeException{

	public PKNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PKNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PKNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PKNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PKNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
