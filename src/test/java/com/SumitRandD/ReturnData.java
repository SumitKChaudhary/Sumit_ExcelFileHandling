package com.SumitRandD;

public class ReturnData {
	private String name;
	private String gender;
	private String add;
	private String extra;
	public ReturnData(String name, String gender, String add, String extra) {
		this.add=add;
		this.gender=gender;
		this.name=name;
		this.extra=extra;
	}
		public static ReturnData storeDetail() {
			String name="Sumit";
			String gender="Male";
			String add="Guru";
			String extra="";
			return new ReturnData(name, add, gender,extra);
		}
		
		public static ReturnData storeSecondDetail() {
			String name="Amit";
			String gender="Male";
			String add = "Noida";
			String extra="Sof";
			return new ReturnData(name, gender, add,extra);
		}
		
		public static void main(String[] args) {
			System.out.println("First Stored Data return value");
			System.out.println(ReturnData.storeDetail().name);
			System.out.println(ReturnData.storeDetail().add);
			System.out.println(ReturnData.storeDetail().gender);
			
			System.out.println("second stored data");
			System.out.println(ReturnData.storeSecondDetail().name);
			System.out.println(ReturnData.storeSecondDetail().gender);
			System.out.println(ReturnData.storeSecondDetail().add);
			System.out.println(ReturnData.storeSecondDetail().extra);
		}
}
