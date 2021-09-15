package coms.softra.RestfulWebService.FundTransferV1;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository(value = "FTjparepository")
public interface FundtransferJPARepository extends IFTDao,JpaRepository<Fundtransfer, Integer>{
	@Query(value = "SELECT * FROM fundtransfer WHERE date_of_transfer BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Fundtransfer> findBydates(Date start, Date end);
}
