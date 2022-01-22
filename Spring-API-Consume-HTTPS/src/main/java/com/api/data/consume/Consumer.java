package com.api.data.consume;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class Consumer {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/todo/{id}")
	public ResponseEntity<String> getTodos(@PathVariable int id) {

		ResponseEntity<String> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/" + id,
				String.class);
		return response;
	}

	// *** produces -> is important will sending data to the client as JSON format
	// it very useful
	@GetMapping(path = "/{name}/http/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getTodosHttp(@PathVariable int id, @PathVariable String name) {
		// HttpURLConnection conn = null;
		URL url = null;
		ResponseEntity<String> res = null;
		HttpsURLConnection conn = null;
		try {
			System.out.println(name + "::" + id);
			url = new URL("https://jsonplaceholder.typicode.com/" + name + "/" + id);

			conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setConnectTimeout(5000);

			if (conn.getResponseCode() == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String inputLine;
				StringBuffer contant = new StringBuffer();
				while ((inputLine = reader.readLine()) != null) {
					contant.append(inputLine);
				}
				System.out.println(contant);
				return (String) contant.toString();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.disconnect();
		}
		return null;
	}

}
