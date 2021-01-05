package com.SumitRandD;

import javax.xml.crypto.Data;

public class DataStoreControler {
	public static  String name;
	public static String gender;
	public static String add;
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		DataStoreControler.name = name;
	}
	public static String getGender() {
		return gender;
	}
	public static void setGender(String gender) {
		DataStoreControler.gender = gender;
	}
	public static String getAdd() {
		return add;
	}
	public static void setAdd(String add) {
		DataStoreControler.add = add;
	}
	
	public static DataStoreControler one(int one) {
		DataStoreControler obj=new DataStoreControler();
		if(one==1) {

			DataStoreControler.name="Sumit";
			DataStoreControler.gender="Male";
			DataStoreControler.add="dsfsd";
		}else if (one==2) {
			DataStoreControler.name="Shashi";
			DataStoreControler.gender="Feale";
			DataStoreControler.add="dsfsd";
		}
		return obj;
	}
	public static void main(String[] args) {
		DataStoreControler.one(1);
		System.out.println(DataStoreControler.getName());
		DataStoreControler.one(2);
		System.out.println(DataStoreControler.getName());
	}
}
