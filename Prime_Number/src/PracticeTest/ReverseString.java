package PracticeTest;

public class ReverseString {
public static void main(String[] args) {
	String sentence = "I am happy";
	String rev = "";
	int line = sentence.length();
	for (int i = line-1; i>= 0; i--) {
		rev = rev+sentence.charAt(i);
	}
	System.out.println(rev);
	revString();
	revStr1();
}
public static void revString() {
	String line = " I am happy";
	StringBuffer buffer = new StringBuffer(line);
	StringBuffer rev = buffer.reverse();
	System.out.println(rev);
}
public static void revStr1() {
	String line = " I am happy";
	StringBuilder builder = new StringBuilder(line);
	StringBuilder rev = builder.reverse();
	System.out.println(rev);
			
}
}
