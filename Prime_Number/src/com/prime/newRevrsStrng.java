package com.prime;

public class newRevrsStrng {
public static void main(String[] args) {
	String[] words="My name is surya".split(" ");
	String rev=" ";
	for(int i=0;i<words.length;i++){
		String word=words[i];
		String revWord="";
		for(int j=word.length()-1;j>=0;j--){
			revWord+=word.charAt(j);
		}
		rev+=revWord+" ";
		
	}
	System.out.println(rev);
}
}
