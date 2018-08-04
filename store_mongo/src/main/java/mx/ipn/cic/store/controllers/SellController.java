package mx.ipn.cic.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.ipn.cic.store.entities.SellEntity;
import mx.ipn.cic.store.repository.SellRepository;

@RestController
@RequestMapping(path = "/sells")
public class SellController {

	@Autowired
	private SellRepository sellRepository;

	@GetMapping(path = "/all")
	public ResponseEntity<List<SellEntity>> all() {

		List<SellEntity> sells = this.sellRepository.findAll();

		return new ResponseEntity<List<SellEntity>>(sells, HttpStatus.OK);
	}

}
