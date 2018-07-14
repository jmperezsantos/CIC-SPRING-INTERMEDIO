package mx.ipn.cic.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ipn.cic.store.entities.UserEntity;
import mx.ipn.cic.store.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> all() {

		return this.userRepository.findAll();

	}

	public UserEntity save(UserEntity user) {

		return this.userRepository.save(user);

	}

	public UserEntity findById(Integer id) {

		Optional<UserEntity> user = this.userRepository.findById(id);

		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}

	}

	public boolean delete(Integer userId) {

		this.userRepository.deleteById(userId);

		return true;
	}

	public List<UserEntity> findByName(String name) {
		
		return this.userRepository.findByNameContaining(name);
		
	}

}
