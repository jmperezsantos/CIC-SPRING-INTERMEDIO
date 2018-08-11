package mx.ipn.cic.store.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Document(collection = "sellDetail")
public class SellDetailEntity {

	@Id
	private String id;

	@JsonBackReference
	@DBRef
	private SellEntity sell;

	@DBRef
	private ProductEntity product;

	private double quantity;

	public SellDetailEntity() {
		super();

	}

	public SellDetailEntity(SellEntity sell, ProductEntity product, double quantity) {
		super();
		this.sell = sell;
		this.product = product;
		this.quantity = quantity;
	}

	public SellDetailEntity(String id, SellEntity sell, ProductEntity product, double quantity) {
		super();
		this.id = id;
		this.sell = sell;
		this.product = product;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SellEntity getSell() {
		return sell;
	}

	public void setSell(SellEntity sell) {
		this.sell = sell;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("SellDetailEntity [id=%s, sell=%s, product=%s, quantity=%s]", id, sell, product, quantity);
	}

}
