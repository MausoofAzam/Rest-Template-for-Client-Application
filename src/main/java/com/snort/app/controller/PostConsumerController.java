package com.snort.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.snort.app.entity.Posts;

@RestController
@RequestMapping("posts/api/v1")
public class PostConsumerController {

	// call your Producer API
	@Autowired
	private RestTemplate restTemplate;

//	@GetMapping("/findAll")
//	public String FindAll() {
//		String url = "https://jsonplaceholder.typicode.com/posts";
//		HttpHeaders headers = new HttpHeaders();
//
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity = new HttpEntity<>(headers);
//
//		String response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
//		return response;
//	}
	@GetMapping("/findAll")  //getting String response
	public List<Posts> FindAll() {
		String url = "https://jsonplaceholder.typicode.com/posts";
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<List<Posts>> entity = new HttpEntity<>(headers);

		List<Posts> response = restTemplate.exchange(url, HttpMethod.GET, entity, List.class).getBody();
		return response;
	}

	@PostMapping("/new") //getting json response
	public String newPosts(@RequestBody Posts postBody) {
		String url = "https://jsonplaceholder.typicode.com/posts";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Posts> entity = new HttpEntity<>(postBody, headers); // we have to give body so

		String response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();

		return response;

	}

	@PutMapping("/updates")
	public String updates(@RequestBody Posts postBody) {
		String url = "https://jsonplaceholder.typicode.com/posts/" + postBody.getId();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Posts> entity = new HttpEntity<>(postBody, headers); // we have to give body so

		String response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class).getBody();

		return response;

	}

	@DeleteMapping("/delete/{id}")
	public String deletePost(@PathVariable int id) {
		String url = "https://jsonplaceholder.typicode.com/posts/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML)); // we can select
																										// multiple
		HttpEntity<String> entity = new HttpEntity<>(headers);
		String response = restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class).getBody();
		return response;
	}

//
//	@GetMapping("/find/{id}")  //get string string response
//	public String findPostsById(@PathVariable int id) {
//		String url = "https://jsonplaceholder.typicode.com/posts/" + id;
//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML)); // we can select
//		// multiple
//		HttpEntity<String> entity = new HttpEntity<>(headers);//for json string 
//		String response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
//		return response;
//	}
	@GetMapping("/find/{id}") // get json object
	public Posts findPostsById(@PathVariable int id) {
		String url = "https://jsonplaceholder.typicode.com/posts/" + id;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML)); // we can select
		// multiple
//		HttpEntity<String> entity = new HttpEntity<>(headers);//for json string 
		HttpEntity<Posts> entity = new HttpEntity<>(headers); // for json object
//		String response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
		Posts response = restTemplate.exchange(url, HttpMethod.GET, entity, Posts.class).getBody();
		return response;
	}

}
