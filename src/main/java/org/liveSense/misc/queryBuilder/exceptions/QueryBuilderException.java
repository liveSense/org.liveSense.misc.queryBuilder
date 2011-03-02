package org.liveSense.misc.queryBuilder.exceptions;

import java.io.Serializable;

public class QueryBuilderException extends Exception implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2373880253277343932L;
	private String msg;


	public QueryBuilderException() {
		super();
	}

	public QueryBuilderException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public QueryBuilderException(Throwable cause) {
		super(cause);
		this.msg = cause.getMessage();
	}

	public QueryBuilderException(String msg, Throwable cause) {
		super(msg, cause);
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}
}
