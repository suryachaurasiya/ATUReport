package PracticeTest;

import java.util.Scanner;

public class FibonnacciSeries {
public static int fibonnacciSeries(int number) {
	if(number==1||number==2) {
		return 1;
	}
	return fibonnacciSeries(number-1) + fibonnacciSeries(number-2);
}
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.print("Enter the no till you want fibonacci Series: ");
	int number = scan.nextInt();
	System.out.print("Fibonacci series of "+ number +" is: ");
	for(int i=1; i<=number; i++) {
	System.out.print(fibonnacciSeries(i)+" ");
	}
	scan.close();
}
}
