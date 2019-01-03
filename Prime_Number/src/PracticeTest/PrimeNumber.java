package PracticeTest;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number till you want prime: ");
		int m = scan.nextInt();
		scan.close();
		int flag = 0;
		for (int i = 1; i < m; i++) {
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					flag = 1;
					break;
				} else {
					flag = 0;
				}
			}
			if (flag == 0&&i!=1)
			System.out.print(" " + i);
		}
	}
}
