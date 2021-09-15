package coms.softra.RestfulWebService.Payee_;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value="payeerepository")
public interface PayeeJPARepository extends PayeeIDao, JpaRepository<Payee, Integer> {

}
