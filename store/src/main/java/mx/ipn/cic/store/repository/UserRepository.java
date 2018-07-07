package mx.ipn.cic.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.store.entities.UserEntity;

@Repository
public interface UserRepository 
		extends JpaRepository<UserEntity, Integer> {

}
