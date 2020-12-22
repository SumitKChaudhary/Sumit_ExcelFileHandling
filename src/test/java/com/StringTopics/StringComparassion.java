package com.StringTopics;

public class StringComparassion
{
	public static void main(String[] args) {
		String expected = "FAILED";
		
		String actual="Failed";
		
		String match="FAILED";
		if(expected.equals(actual) || expected.equals(match)) {
			
			System.out.println("Equal");
		}else {
			System.out.println("Not");
		}
	}

}
