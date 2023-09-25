package com.calibraint.project.entity;

import java.time.LocalDateTime;

public class CommonException {
	
	private String msg;

	private LocalDateTime dateTime;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getLocalDateTime() {
		return dateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.dateTime = localDateTime;
	}

	public CommonException(String msg, LocalDateTime localDateTime) {
		super();
		this.msg = msg;
		this.dateTime = localDateTime;
	}
	
}
