package com.practice.demo;

import java.util.Arrays;

public class Misc {
	public static void main(String[] args) {
		String[] strs = new String[] {"aa","aa","aa","aa"};
//		["flower","flow","flight"]
		boolean isAllSame = true;
		for(int i=1; i< strs.length; i++) {
			if(!strs[i].equals(strs[i-1])) {
				isAllSame = false;
				break;
			}
		}
		
		if(isAllSame) {
			System.out.println(String.valueOf(strs[0].charAt(0)));
		}
		StringBuilder commonString = new StringBuilder();
		if(strs.length==1)
			commonString = new StringBuilder(strs[1]);
		else {
			int smallLength = strs[0].length() < strs[1].length() ? strs[0].length() : strs[1].length();
			int count=0;
			while(smallLength!=count) {
				if(Character.compare(strs[0].charAt(count), strs[1].charAt(count)) == 0) {
					commonString.append(strs[0].charAt(count));
					count++;
				}else {
					break;
				}
			}
			if(strs.length>2) {
				for(int i=2; i<strs.length; i++) {
					while(true) {
						if(commonString.length()==0 || strs[i].equals(commonString.toString()) || 
								(strs[i].length() >= commonString.length() && commonString.toString().equals(strs[i].substring(0, commonString.length())))) {
							break;
						}else if(strs[i].length() < commonString.length() && strs[i].equals(commonString.substring(0, strs[i].length()))){
							commonString.deleteCharAt(commonString.length()-1);
							break;
						}else {
							commonString.deleteCharAt(commonString.length()-1);
						}
					}
				}
			}
		}
		System.out.println(commonString);
	}
}
//
//ix = 10-1
//xi = 10+1

//MCMXCIV
//1000 