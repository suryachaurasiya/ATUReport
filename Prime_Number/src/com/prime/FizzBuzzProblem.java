package com.prime;

import java.util.Scanner;

public class FizzBuzzProblem {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter the number till you want fizz buzz: ");
	int number = scan.nextInt();
	for (int i = 1; i <=number; i++) {
		if(i%3==0&&i%15!=0) {
			System.out.print(" Fizz");
			
		}if(i%5==0&&i%15!=0) {
			System.out.print(" Buzz");
			
		}
		if(i%15==0) {
			System.out.print(" FizzBuzz");
			}
		if(i%3!=0&&i%5!=0&&i%15!=0) {
			System.out.print(" "+i);
		}
		
	}	
scan.close();	
}

}
