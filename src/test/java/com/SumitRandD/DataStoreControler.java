package com.SumitRandD;

import javax.xml.crypto.Data;

public class DataStoreControler {
	public String name;
	public String gender;
	public String add;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	
	public static DataStoreControler storeOne(int no) {
		DataStoreControler obj=new DataStoreControler();
		if(no==1) {
			
			obj.name="Sumit";
			obj.gender="Male";
			obj.add="Gurugram";
		}
		return obj;
		
	}
	public static DataStoreControler storeTwo (int no) {
		DataStoreControler obj=new DataStoreControler();
		if(no==1) {
			
			obj.name="Amit";
			obj.gender="Female";
			obj.add="Noida";
		}
		return obj;
		
	}
	public static void main(String[] args) {
		System.out.println("One");
		System.out.println(DataStoreControler.storeOne(1).getName());
		System.out.println(DataStoreControler.storeOne(1).getGender());
		System.out.println(DataStoreControler.storeOne(1).getAdd());
		
		System.out.println("Two");
		System.out.println(DataStoreControler.storeTwo(1).getName());
		System.out.println(DataStoreControler.storeTwo(1).getGender());
		System.out.println(DataStoreControler.storeTwo(1).getAdd());
	}
}
