package com.prime;

public class ReverseWordsInStringOnSamePlace {
public static void main(String[] args) {
	String str="I am indian";
	String sentence="";
	String words="";
	for(int i=0; i<str.length();i++){
		if(str.charAt(i)!=' '){
			words+=str.charAt(i);		
		}else{
			sentence+=words+" ";
			words=" ";
		}
	}
	sentence=sentence+words;
	System.out.println(sentence);
}
}
