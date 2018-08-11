package mx.ipn.cic.store.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mx.ipn.cic.store.entities.SellDetailEntity;
import mx.ipn.cic.store.entities.SellEntity;

@Repository
public interface SellDetailRepository extends MongoRepository<SellDetailEntity, String> {

	List<SellDetailEntity> findBySell_Id(String sellId);

}
