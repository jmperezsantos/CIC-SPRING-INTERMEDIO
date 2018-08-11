package mx.ipn.cic.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.ipn.cic.store.entities.SellDetailEntity;
import mx.ipn.cic.store.entities.SellEntity;
import mx.ipn.cic.store.repository.SellDetailRepository;
import mx.ipn.cic.store.repository.SellRepository;

@RestController
@RequestMapping(path = "/sells")
public class SellController {

	@Autowired
	private SellRepository sellRepository;

	@Autowired
	private SellDetailRepository sellDetailRepository;

	@GetMapping(path = "/all")
	public ResponseEntity<List<SellEntity>> all() {

		List<SellEntity> sells = this.sellRepository.findAll();
		
		for(SellEntity sell : sells) {
			
			List<SellDetailEntity> details = 
					this.sellDetailRepository.findBySell_Id(sell.getId());
			
			sell.setDetail(details);
		}

		return new ResponseEntity<List<SellEntity>>(sells, HttpStatus.OK);
	}

}
