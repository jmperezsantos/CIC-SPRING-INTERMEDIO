package mx.ipn.cic.store.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.ipn.cic.store.entities.ProductEntity;
import mx.ipn.cic.store.entities.SellDetailEntity;
import mx.ipn.cic.store.entities.SellEntity;
import mx.ipn.cic.store.entities.UserEntity;
import mx.ipn.cic.store.repository.ProductRepository;
import mx.ipn.cic.store.repository.SellDetailRepository;
import mx.ipn.cic.store.repository.SellRepository;
import mx.ipn.cic.store.repository.UserRepository;

@RestController()
@RequestMapping(path = "/test")
public class TestController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SellRepository sellRepository;

	@Autowired
	private SellDetailRepository sellDetailRepository;

	@GetMapping(path = "/test")
	public ResponseEntity<Object> test() {

		List<ProductEntity> products = this.products();

		//UserEntity user = this.userRepository.findById("5b65e7f81293950afab8cdeb").get();
		UserEntity user = new UserEntity("Juan Manuel", "Pérez", "Santos", "Mi casa","RFC");
		this.userRepository.save(user);

		// SellEntity sell =
		// this.sellRepository.findById("5b65e9901293950b0d6922a7").get();
		SellEntity sell = new SellEntity(new Date(), user);
		this.sellRepository.save(sell);

		SellDetailEntity sellDetail = new SellDetailEntity(sell, products.get(0), 2);
		SellDetailEntity sellDetail2 = new SellDetailEntity(sell, products.get(1), 3);
		SellDetailEntity sellDetail3 = new SellDetailEntity(sell, products.get(2), 5);

		List<SellDetailEntity> details = Arrays.asList(sellDetail, sellDetail2, sellDetail3);
		this.sellDetailRepository.saveAll(details);

		sell.setDetail(details);

		return new ResponseEntity<Object>(HttpStatus.OK);

	}

	private List<ProductEntity> products() {

		List<ProductEntity> products = this.productRepository.findAll();

		if (products.size() == 0) {

			for (int x = 1; x <= 10; x++) {

				ProductEntity product = new ProductEntity("Product " + x, "Desc " + x, x, x);

				this.productRepository.save(product);

			}

			products = this.productRepository.findAll();

		}

		return products;
	}

}
