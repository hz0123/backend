package coms.softra.RestfulWebService.Transaction;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "Tjparepository")
public interface TransactionJPARepository extends ITDao,JpaRepository<Transaction, Integer>{

	@Transactional
	@Modifying // Modifying queries can only use void or int/Integer as return type!
	@Query(value="update user set account_balance = account_balance+?1 where account_id = ?2", nativeQuery = true)
	int setAccountBalanceForDeposit(Double amount, int accountId);
	
	@Transactional
	@Modifying // Modifying queries can only use void or int/Integer as return type!
	@Query(value="update user set account_balance = account_balance-?1 where account_id = ?2", nativeQuery = true)
	int setAccountBalanceForWithdrawal(Double amount, int accountId);
	
	@Query(value = "SELECT * FROM transaction WHERE date_of_transaction BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Transaction> findBydates(Date start, Date end);
	
	@Query(value = "SELECT * FROM transaction WHERE account_id=?1 AND date_of_transaction BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Transaction> findByDatesForUser(int id, Date start, Date end);
	
	@Query(value = "SELECT account_balance FROM user WHERE account_id=?1", nativeQuery = true)
	public Double checkBalance(int id);
}
