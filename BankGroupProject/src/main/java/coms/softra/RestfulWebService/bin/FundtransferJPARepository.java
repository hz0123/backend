package coms.softra.RestfulWebService.bin;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ftjparepository")
public interface FundtransferJPARepository extends FundtransferIDao, JpaRepository<Fundtransfer, Integer> {

	 @Query(value = "select * from fundtransfer where DATE > ?1 AND Date < ?2", nativeQuery = true)
	 List<Fundtransfer> findByfundTransferId(String strStartDate, String strEndDate);	 

}
