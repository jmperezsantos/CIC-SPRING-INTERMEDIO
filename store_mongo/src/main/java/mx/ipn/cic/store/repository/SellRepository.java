package mx.ipn.cic.store.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.ipn.cic.store.entities.SellEntity;

public interface SellRepository extends MongoRepository<SellEntity, String> {

	List<SellRepository> findByUser_Id(String userId);

}
