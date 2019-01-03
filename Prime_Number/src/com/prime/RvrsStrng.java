package com.prime;

public class RvrsStrng {
public static void main(String[] args) {
	String s="surya is cool";
	String rev="";
	for(int i=s.length()-1;i>=0;i--){
		rev+=s.charAt(i);
	}
	System.out.println(rev);
}
}
