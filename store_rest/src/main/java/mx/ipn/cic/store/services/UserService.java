package mx.ipn.cic.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.store.entities.UserEntity;
import mx.ipn.cic.store.repository.UserRestService;

@Service
public class UserService {

	@Autowired
	private UserRestService userService;

	public List<UserEntity> all() {

		return this.userService.findAll();

	}

	public UserEntity save(UserEntity user) {

		if(user.getId() != null && user.getId().length() > 0) {
			return this.userService.update(user);	
		} else {
			return this.userService.save(user);	
		}		
		

	}

	public UserEntity findById(String id) {

		UserEntity user = this.userService.findById(id);

		return user;

	}

	public boolean delete(String userId) {

		this.userService.deleteById(userId);

		return true;
	}

}
