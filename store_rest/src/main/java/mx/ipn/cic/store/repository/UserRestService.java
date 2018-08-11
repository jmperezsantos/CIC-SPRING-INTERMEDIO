package mx.ipn.cic.store.repository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.ipn.cic.store.entities.UserEntity;

@Service
public class UserRestService {

	public List<UserEntity> findAll() {

		UserEntity[] users = null;

		try {

			String strUri = "http://localhost:8080/rest/user/all";
			RestTemplate restTemplate = new RestTemplate();

			URI uri = new URI(strUri);

			RequestEntity<Object> requestEntity = new RequestEntity<Object>(HttpMethod.GET, uri);
			ResponseEntity<UserEntity[]> response = restTemplate.exchange(requestEntity, UserEntity[].class);

			users = response.getBody();

		} catch (URISyntaxException e) {

			e.printStackTrace();
		}

		return Arrays.asList(users);

	}

	public UserEntity save(UserEntity user) {

		try {
		
			String strUri = "http://localhost:8080/rest/user/save";
			RestTemplate restTemplate = new RestTemplate();

			URI uri = new URI(strUri);

			RequestEntity<UserEntity> requestEntity = new RequestEntity<UserEntity>(user, HttpMethod.POST, uri);

			ResponseEntity<UserEntity> response = restTemplate.exchange(requestEntity, UserEntity.class);

			user = response.getBody();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public UserEntity findById(Integer id) {
		return null;
	}

	public void deleteById(Integer userId) {

	}

}
