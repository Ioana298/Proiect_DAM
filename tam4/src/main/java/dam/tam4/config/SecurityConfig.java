package dam.tam4.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 
	final DataSource dataSource;

	public SecurityConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	// logare cu utilizatorii din baza de date
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.eraseCredentials(false).jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("select username, password, active from login where username=?")
		.authoritiesByUsernameQuery("SELECT l.username as username, r.role_name as role FROM users u "
				+ " INNER JOIN users_roles ur ON u.user_id = ur.user_id "
				+ " INNER JOIN roles r ON ur.role_id = r.role_id" 
				+ " INNER JOIN login l ON l.id = u.login_id WHERE l.username = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/candidate/**").hasAnyRole("CANDIDATE", "USER")
		.antMatchers("/common/**").hasAnyRole("USER")
		.antMatchers("/**").hasAnyRole("USER")
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/authenticateTheUser") 
		.defaultSuccessUrl("/landingPage")
		.permitAll()
		.and().csrf().ignoringAntMatchers("/**")
		.and()
		.logout()
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/common/access-denied");
	}
	
	//atunci cand ne vom autentifica cu utilizatori din DB nu va mai fi nevoie de aceasta metoda
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}