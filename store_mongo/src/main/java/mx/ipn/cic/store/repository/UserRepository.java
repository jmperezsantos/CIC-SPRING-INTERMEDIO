
package mx.ipn.cic.store.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.store.entities.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

	List<UserEntity> findByNameContaining(String name);

	List<UserEntity> findByLastnameLike(String lastname);

	List<UserEntity> findByGivenNameLike(String givenName);

}
