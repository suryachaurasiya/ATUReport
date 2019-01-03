package com.authentication;

class StrSplit {
	 public static CardDetails splitStr() throws Exception{
//	public static void main(String[] args) throws Exception {

		Unfold de = new Unfold();
		CardDetails card1 = new CardDetails();
		CardDetails cardData = SqlConnection.getCardDetails();
		String strMain = de.unravel(cardData.getCardNumber1());
		String digits1 = String.valueOf(strMain).substring(0, 4);
		String digits2 = String.valueOf(strMain).substring(4, 8);
		String digits3 = String.valueOf(strMain).substring(8, 12);
		String digits4 = String.valueOf(strMain).substring(12, 16);
		System.out.println(digits1);
		System.out.println(digits2);
		System.out.println(digits3);
		System.out.println(digits4);
		 card1.setCardNumber1(digits1);
		 return card1;
	}
}