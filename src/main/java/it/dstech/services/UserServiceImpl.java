package it.dstech.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.dstech.models.User;

public class UserServiceImpl implements UserService{
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
	
	@Override
	public User saveUser(User user) {
		try {
			URL url = new URL("http://localhost:8082/register");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(user);
			OutputStream os = conn.getOutputStream();
			os.write(jsonInString.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuffer response = new StringBuffer();
			while ((output = br.readLine()) != null) {
				logger.info(output);
				response.append(output);
			}
			String risposta = response.toString();
			ObjectMapper responseMapper = new ObjectMapper();
			return responseMapper.readValue(risposta, User.class);
		} catch (Exception e) {
			logger.warning(e.getMessage());
			return null;
		}
	}

	
	@Override
	public User deleteUser(int id) {
		try {
			URL url = new URL("http://localhost:8082/delete/{id}");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("DELETE");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuffer response = new StringBuffer();
			while ((output = br.readLine()) != null) {
				logger.info(output);
				response.append(output);
			}
			String risposta = response.toString();
			ObjectMapper responseMapper = new ObjectMapper();
			JavaType type = responseMapper.getTypeFactory().constructCollectionType(ArrayList.class, User.class);
			return responseMapper.readValue(risposta, type);
		} catch (Exception e) {
			logger.warning(e.getMessage());
			return null;
		}
	}
	@Override
	public User login(String username, String password) {
		try {
			URL url = new URL("http://localhost:8082/login");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("username", username);
			conn.setRequestProperty("password", password);

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			StringBuffer response = new StringBuffer();
			while ((output = br.readLine()) != null) {
				logger.info(output);
				response.append(output);
			}
			String risposta = response.toString();
			ObjectMapper responseMapper = new ObjectMapper();
			return responseMapper.readValue(risposta, User.class);
		} catch (Exception e) {
			logger.warning(e.getMessage());
			return null;
		}
	}
	
	

	

}
