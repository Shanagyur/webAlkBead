package hu.iit.uni.miskolc.RequestRegistry.controller.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select username, password, enabled from users where username=?")
			.authoritiesByUsernameQuery("select username, role from userroles where username=?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/student/**").access("hasRole('ROLE_STUDENT')")
			.antMatchers("/teacher/**").access("hasRole('ROLE_TEACHER')")
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.and()
				.formLogin().loginProcessingUrl("/login")
				.usernameParameter("username")
				.passwordParameter("password")
			.and()
				.logout().permitAll()
			.and()
				.csrf().disable();
	}
}
