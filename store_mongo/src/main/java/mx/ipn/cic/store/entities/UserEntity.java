package mx.ipn.cic.store.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class UserEntity {

	// El id en mongoDB se maneja como un string
	@Id
	private String id;

	private String name;

	private String lastname;

	private String givenName;

	private String address;

	private String clientId;

	@DBRef
	private List<SellEntity> sells;

	public UserEntity() {
		super();
	}

	public UserEntity(String name, String lastname, String givenName, String address, String clientId) {
		this(name, lastname, givenName, address, clientId, new ArrayList<>());
	}

	public UserEntity(String name, String lastname, String givenName, String address, String clientId,
			List<SellEntity> sells) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.givenName = givenName;
		this.address = address;
		this.clientId = clientId;
		this.sells = sells;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public List<SellEntity> getSells() {
		return sells;
	}

	public void setSells(List<SellEntity> sells) {
		this.sells = sells;
	}

	@Override
	public String toString() {
		return String.format("UserEntity [id=%s, name=%s, lastname=%s, givenName=%s, address=%s, clientId=%s]", id,
				name, lastname, givenName, address, clientId);
	}

}
