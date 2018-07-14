
package mx.ipn.cic.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.store.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	List<UserEntity> findByNameContaining(String name);

	List<UserEntity> findByLastnameLike(String lastname);

	List<UserEntity> findByGivenNameLike(String givenName);

}
