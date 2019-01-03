package com.prime;

import java.util.Scanner;

public class Swapping {
public static void main(String[] args) {
	int temp;
	Scanner scan=new Scanner(System.in);
	System.out.println("Enter the first no you want to swap = ");
	int x=scan.nextInt();
	System.out.println("Enter the 2nd no you want to swap = ");
	int y=scan.nextInt();
	scan.close();
	
	System.out.println("Before swapping  "+x+"  "+y);
	temp=x;
	x=y;
	y=temp;
	System.out.println("After swapping  "+x+"  "+y);

}
}
