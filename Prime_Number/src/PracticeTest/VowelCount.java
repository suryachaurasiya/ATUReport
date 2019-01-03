package PracticeTest;

public class VowelCount {
public static void main(String[] args) {
	String line = "qwertyuytfdsszxcvbhgfAA aaaa99 99";
	int vowels=0, constant=0, digit=0, space=0;
	for (int i = 0; i < line.toLowerCase().length(); i++) {
		char ch = line.charAt(i);
		if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
			vowels++;
		}else if(ch>='a'&&ch<='z') {
			++constant;
		}else if(ch>='0'&&ch<='9') {
			digit++;
		}else if(ch ==' ') {
			space++;
		}
	}
	System.out.println("Number of vowels are: "+vowels+"\nNumber of constants are: "+constant+"\nNumber of digits are: "+digit+"\nNumber of space are: "+space);
}
}
	