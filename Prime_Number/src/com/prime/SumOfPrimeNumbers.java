package com.prime;

public class SumOfPrimeNumbers {

	public static void main(String[] args) {
		int count, sum = 0;

		System.out.println(" Prime Numbers from 1 to 100 are : ");
		for (int number = 1; number <= 100; number++) {
			count = 0;
			for (int i = 2; i <= number / 2; i++) {
				if (number % i == 0) {
					count++;
					break;
				}
			}
			if (count == 0 && number != 1) {
				System.out.print(number + " ");
				sum = sum + number;
			}
		}
		System.out.println("\nSum of Prime Numbers from 1 to 100 are : " + sum);
	}
}
