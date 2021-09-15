package coms.softra.RestfulWebService.FundTransfer;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import coms.softra.RestfulWebService.User;

@Repository(value = "FTjparepository")
public interface FundtransferJPARepository extends IFTDao,JpaRepository<Fundtransfer, Integer>{
	@Query(value = "SELECT * FROM fundtransfer WHERE date_of_transfer BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Fundtransfer> findBydates(Date start, Date end);
	
	@Transactional
	@Modifying // Modifying queries can only use void or int/Integer as return type!
	@Query(value="update user set account_balance = account_balance-?1 where account_id = ?2", nativeQuery = true)
	int setAccountBalanceForPayer(Double amount, int accountId);
	
	@Transactional
	@Modifying // Modifying queries can only use void or int/Integer as return type!
	@Query(value="update user set account_balance = account_balance+?1 where account_id = ?2", nativeQuery = true)
	int setAccountBalanceForPayee(Double amount, int accountId);
	
	// Returns the user id
	@Query(value = "SELECT * FROM user WHERE account_id=?1", nativeQuery = true)
	Integer findById(int id);
	
	@Query(value = "SELECT account_balance FROM user WHERE account_id=?1", nativeQuery = true)
	Double checkBalance(int id);

}
