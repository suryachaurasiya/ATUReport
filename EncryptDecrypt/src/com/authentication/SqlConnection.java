package com.authentication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnection {
	static Connection conn = null;
	static Statement stmt = null;

	public static CardDetails getCardDetails() throws Exception {
		CardDetails card = new CardDetails();
		Unfold de =new Unfold();
		ResultSet resultSet = null;
		String driver = de.unravel(GetPropertyValues.getPropertyValue("jdbc.driver"));
		if (driver != null) {
		    Class.forName(driver) ;
		}
		String url = de.unravel(GetPropertyValues.getPropertyValue("jdbc.url"));
		String username = de.unravel(GetPropertyValues.getPropertyValue("jdbc.username"));
		String password = de.unravel(GetPropertyValues.getPropertyValue("jdbc.password"));
		conn = DriverManager.getConnection(url, username, password);
		stmt = conn.createStatement();
		resultSet = stmt.executeQuery(
				"select CardHolderName, CardNumber,ExpiryMonth, ExpiryYear,CVVNumber,Password, CardNumber1, ExpiryMnth1, ExpiryYear1, CVVNum1 from BotCardDetails");
		
		while (resultSet.next()) {

			card.setPassword(resultSet.getString(6));
			card.setCardNumber(resultSet.getString(2));
			card.setCardNumber1(resultSet.getString(7));
		}
		return card;
	}

}
