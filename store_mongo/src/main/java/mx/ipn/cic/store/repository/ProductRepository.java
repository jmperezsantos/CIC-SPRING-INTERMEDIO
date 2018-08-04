package mx.ipn.cic.store.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import mx.ipn.cic.store.entities.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {

	List<ProductEntity> findByNameContaining(String name);

	ProductEntity findByUpc(long upc);

}
