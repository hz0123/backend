package coms.softra.RestfulWebService.FundTransferV1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import coms.softra.RestfulWebService.User;

@RestController
@CrossOrigin("*")
public class FundtransferController {

	@Autowired
	private IFTService ftservice;
	
	public FundtransferController() {
		System.out.println("Inside default constructor of FundtransferController");
	}
	
	@PostMapping(path="/fundtransfer") 
	public Fundtransfer saveFT(@Valid @RequestBody Fundtransfer ft) {
		System.out.println("Inside saveFT of FundtransferController");
		// Need to get payee & payer user details from database 
		Connection con = null;
		User payer = null;
		User payee = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","root");
			
			String sql = "SELECT * FROM user WHERE account_id = ?";	
			// For getting payer
			PreparedStatement pstate1 = con.prepareStatement(sql);
			pstate1.setInt(1, ft.getPayerId());
			ResultSet rs = pstate1.executeQuery();
			rs.next();
			payer = new User(rs.getInt("account_id"), rs.getInt("user_id"),  rs.getString("login_password"),  rs.getString("secret_question"),  rs.getString("transaction_password"),  rs.getString("lock_status"),  rs.getString("account_type"), rs.getDouble("account_balance"), rs.getDate("open_date"));
			// For getting payee
			PreparedStatement pstate2 = con.prepareStatement(sql);
			pstate2.setInt(1, ft.getPayeeId());
			ResultSet rs2 = pstate2.executeQuery();
			rs2.next();
			payee = new User(rs2.getInt("account_id"), rs2.getInt("user_id"),  rs2.getString("login_password"),  rs2.getString("secret_question"),  rs2.getString("transaction_password"),  rs2.getString("lock_status"),  rs2.getString("account_type"), rs2.getDouble("account_balance"), rs2.getDate("open_date"));
			
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		ft.setPayer(payer);
		ft.setPayee(payee);
		return ftservice.save(ft);
	}
	
	@GetMapping(path="/fundtransfer/{start}/{end}") 
	public List<Fundtransfer> findBydates(@PathVariable Date start, @PathVariable Date end) {
		System.out.println("Inside findBydates of FundtransferController");
		return ftservice.findBydates(start, end);
	}
}
