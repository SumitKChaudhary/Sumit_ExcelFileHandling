package com.SumitRandD;

public class ReturnData {
	private static String name;
	private static String gender;
	private static String add;
	private static String extra;
	public ReturnData(String name, String gender, String add, String extra) {
		this.add=add;
		this.gender=gender;
		this.name=name;
		this.extra=extra;
	}
		public static ReturnData storeDetail() {
			name="Sumit";
			gender="Male";
			add="Guru";
			extra="";
			return new ReturnData(name, add, gender,extra);
		}
		
		public static ReturnData storeSecondDetail() {
			name="Amit";
			gender="Male";
			add = "Noida";
			extra="Sof";
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
