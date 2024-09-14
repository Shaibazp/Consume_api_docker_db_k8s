package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/items")
public class itemController 
{
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${app.url}")
	private String urlValue;
	
	@GetMapping("/category/{name}")
	public ResponseEntity<String> getItem(@PathVariable String name)
	{
		ResponseEntity<String> resp = null;
		String urls = urlValue+"{category}";
		System.out.println(urls);
		ResponseEntity<String> resps = restTemplate.exchange(urls, HttpMethod.GET,  null , String.class, name);
		System.out.println(resps);
		resp = new ResponseEntity<String>(resps.getBody(), HttpStatus.OK);
		return resp;
	}
}
