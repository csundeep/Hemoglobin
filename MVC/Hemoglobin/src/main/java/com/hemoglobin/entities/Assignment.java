package com.hemoglobin.entities;

public class Assignment {

	private int donorId;
	private int requestId;

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	@Override
	public String toString() {
		return "Assignment [donorId=" + donorId + ", requestId=" + requestId + "]";
	}

}
