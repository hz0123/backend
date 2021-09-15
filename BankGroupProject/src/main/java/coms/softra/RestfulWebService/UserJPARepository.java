package coms.softra.RestfulWebService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository(value = "jparepository")
public interface UserJPARepository extends IDao, JpaRepository<User, Integer> {
	
}
