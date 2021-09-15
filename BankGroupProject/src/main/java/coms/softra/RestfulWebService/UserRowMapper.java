package coms.softra.RestfulWebService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("Inside mapRow of UserRowMapper with row number "+rowNum);
		int accountId = rs.getInt("accountId");
		int userId = rs.getInt("userId");
		String loginPassword = rs.getString("loginPassword");
		String secretQuestion = rs.getString("secretQuestion");
		String transactionPassword = rs.getString("transactionPassword");
		String lockStatus = rs.getString("lockStatus");
		String accountType = rs.getString("accountType");
		Double AccountBalance = rs.getDouble("AccountBalance");
		Date openDate = rs.getDate("openDate");

		User user = new User(accountId, userId, loginPassword, 
				secretQuestion, transactionPassword, lockStatus, 
				accountType, AccountBalance, openDate);
		
		System.out.println("**** MP : " +user.toString());
		return user;
	}

}
