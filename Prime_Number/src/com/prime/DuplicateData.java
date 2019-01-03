package com.prime;

public class DuplicateData {
	public static void main(String[] args) {
		// int arr[] = {1,2,3,4,4,5,5,10,10,23,23};
		String arr[] = { "Surya", "Surya", "Vipul", "Vivek", "Vipul","Vivek" };
		int duplicate = arr.length;
		for (int i = 0; i < duplicate; i++) {
			for (int j = i + 1; j < duplicate; j++) {
				if (arr[i] == arr[j])
					System.out.print(arr[i] + " ");
			}
		}
	}
}
