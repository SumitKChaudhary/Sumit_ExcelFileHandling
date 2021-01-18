package com.SumitRandD;


public class MultipleData {
	
	private String name;
	private String mobileNo;
	private String add;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	
	public static MultipleData one(int one) {
		MultipleData mulOne = new MultipleData();
		if(one==1) {
			mulOne.name="Sumit";
			mulOne.mobileNo="12345";
			mulOne.add="Gurugram";
		}else if (one==2) {
			mulOne.setName("Shashi");
			mulOne.setMobileNo("7845");
			mulOne.setAdd("Noida");
		}
		return mulOne;
	}
	
}
