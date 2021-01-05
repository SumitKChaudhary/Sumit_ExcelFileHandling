package com.SumitRandD;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.Mul;

public class MultipleData {
	
	public String name;
	public String mobileNo;
	public String add;
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
	
	public static void main(String[] args) {
		MultipleData one=MultipleData.one(1);
		System.out.println("One Return");
		System.out.println(one.getName());
		System.out.println(one.getMobileNo());
		System.out.println(one.getAdd());
		
		MultipleData two=MultipleData.one(2);
		System.out.println("Two Return");
		System.out.println(two.getName());
		System.out.println(two.getMobileNo());
		System.out.println(two.getAdd());
		
	}
}
