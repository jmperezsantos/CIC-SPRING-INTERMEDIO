package mx.ipn.cic.store.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Document(collection = "sell")
public class SellEntity {

	@Id
	private String id;

	private Date date;

	@DBRef
	private UserEntity user;

	@Transient
	private List<SellDetailEntity> detail;

	public SellEntity() {
		super();
	}

	public SellEntity(Date date, UserEntity user) {
		super();

		this.date = date;
		this.user = user;
	}

	public SellEntity(String id, Date date, UserEntity user) {
		super();
		this.id = id;
		this.date = date;
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<SellDetailEntity> getDetail() {
		return detail;
	}

	public void setDetail(List<SellDetailEntity> detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return String.format("SellEntity [id=%s, date=%s, user=%s]", id, date, user);
	}

}
