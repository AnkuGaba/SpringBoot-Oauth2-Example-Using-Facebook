package com.icsd;

import java.security.Principal;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableOAuth2Sso //it is used to enable Oauth2 login single sign out
public class SpringCloudOauth2FandBApplication {
	
	@GetMapping("/")
    public String welcome(Principal principal) {
		//Principal is an object which is used to fetch name and sometimes it will give integer and we have to type cast as follows :-
        Map<String, Object> details = (Map<String, Object>)
                ((OAuth2Authentication) principal).getUserAuthentication().getDetails();
        String userName = (String) details.get("name");
        return "Hi " + userName + " Welcome to my application !!";
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOauth2FandBApplication.class, args);
		System.out.println("server start");
	}

}
