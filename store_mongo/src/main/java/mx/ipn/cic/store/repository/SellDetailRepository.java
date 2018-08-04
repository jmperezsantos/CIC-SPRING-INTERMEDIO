package mx.ipn.cic.store.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.ipn.cic.store.entities.SellDetailEntity;

public interface SellDetailRepository extends MongoRepository<SellDetailEntity, String> {

	List<SellDetailRepository> findBySell_Id(String sellId);

}
