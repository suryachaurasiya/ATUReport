package com.prime;

public class RvrsByUsingStrngBldr {
public static void main(String[] args) {
	StringBuilder rev=new StringBuilder();
	String s="surya";
	for(int i=s.length()-1;i>=0;i--){
		rev=rev.append(s.charAt(i));
	}
	System.out.println(rev);
}
}
