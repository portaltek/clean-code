package portaltek.cleancode.api.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@SpringBootApplication
@RestController
public class CleanCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CleanCodeApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
    @PostMapping("/post")
    public String post() {
        return "Hello World. POST";
    }
    @GetMapping("/free")
    public String free() {
        return "Hello World. FREE";
    }


}

@Configuration(proxyBeanMethods = false)
class ApiSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/actuator/shutdown");
        http
                .authorizeRequests()
                .antMatchers("/actuator/**").hasRole("ENDPOINT_ADMIN")
                .antMatchers(POST, "/post").hasRole("ENDPOINT_ADMIN")
                .antMatchers(GET, "/hello").hasRole("ENDPOINT_ADMIN")
                .antMatchers(GET, "/free").permitAll()
                //.antMatchers("/**").denyAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .httpBasic();

    }

}
