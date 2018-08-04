package mx.ipn.cic.store.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class ProductEntity {

	@Id
	private String id;

	private String name;

	private String description;

	private double price;

	private long upc;

	public ProductEntity(String name, String description, double price, long upc) {
		super();

		this.name = name;
		this.description = description;
		this.price = price;
		this.upc = upc;
	}

	public ProductEntity(String id, String name, String description, double price, long upc) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.upc = upc;
	}

	public ProductEntity() {
		super();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getUpc() {
		return upc;
	}

	public void setUpc(long upc) {
		this.upc = upc;
	}

	@Override
	public String toString() {
		return String.format("ProductEntity [id=%s, name=%s, description=%s, price=%s, upc=%s]", id, name, description,
				price, upc);
	}

}
