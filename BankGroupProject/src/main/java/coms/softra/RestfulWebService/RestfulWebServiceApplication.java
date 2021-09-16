package coms.softra.RestfulWebService;

import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestfulWebServiceApplication {

	public static String consumeGetRestApis(RestTemplate restemplate) {
		System.out.println("Inside consumeGetRestApis of RestfulWebServiceApplication");	
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);
		String url = "http://localhost:7777/users";
		String result = restemplate.exchange(url, HttpMethod.GET,entity,String.class).getBody();
		return result;
	}
	
	public static String consumePostRestApis(RestTemplate rt, User user) {
		System.out.println("in consumePostRestApis");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> entity = new HttpEntity<User>(user,headers);
		String url = "http://localhost:7777/users";
		String result = rt.exchange(url, HttpMethod.POST,entity,String.class).getBody();
		return result;
	}
	
	@Bean(name = "resttemplate") 
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RestfulWebServiceApplication.class, args);

	}
}




















