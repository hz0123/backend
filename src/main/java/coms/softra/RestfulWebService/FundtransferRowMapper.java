package coms.softra.RestfulWebService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.persistence.Column;
import org.springframework.jdbc.core.RowMapper;

public class FundtransferRowMapper implements RowMapper<Fundtransfer> {

	@Override
	public Fundtransfer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Fundtransfer ft = new Fundtransfer(); 
		System.out.println("Inside mapRow of UserRowMapper with row number "+rowNum);
		int fundTransferId = rs.getInt("fundTransferId");
		int accountId = rs.getInt("accountId");
		int payeeAccountId = rs.getInt("payeeAccountId");
		Date date = rs.getDate("date");
		Double amount = rs.getDouble("amount");
		

		Fundtransfer fundtransfer= new Fundtransfer(fundTransferId, accountId, 
				payeeAccountId, date, amount);
		
		System.out.println(fundtransfer.toString());
		return fundtransfer;
	}

}

