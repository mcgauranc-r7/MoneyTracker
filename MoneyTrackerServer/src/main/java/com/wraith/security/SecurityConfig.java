package com.wraith.security;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.wraith.authentication.AjaxAuthenticationSuccessHandler;

/**
 * User: rowan.massey Date: 14/08/2014 Time: 23:39
 */
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Inject
	MoneyUserDetailsService moneyUserDetailsService;

	@Inject
	AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(moneyUserDetailsService).passwordEncoder(new StandardPasswordEncoder());
//        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and().withUser("admin")
//				.password("password").roles("ADMIN", "USER");
	}

	public void configure(WebSecurity web) throws Exception {
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
	            .antMatchers("/accounts/**").hasRole("ADMIN")
	    	    .antMatchers("/accountTypes/**").hasRole("ADMIN")
	            .antMatchers("/addresses/**").hasRole("ADMIN")
	            .antMatchers("/authorities/**").hasRole("ADMIN")
		        .antMatchers("/countries/**").hasRole("ADMIN")
			    .antMatchers("/currencies/**").hasRole("ADMIN")
		        .antMatchers("/groups/**").hasRole("ADMIN")
                .antMatchers("/**").hasRole("USER")
                .and()
            .httpBasic()
                .realmName("MoneyTracker Realm via Basic Authentication")
                .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .csrf()
                .disable(); //Disabled CSRF, as this REST service won't exclusively be for browsers.

	}

	//    <security:http-basic entry-point-ref="basicEntryPoint"/>
	//    <security:form-login authentication-success-handler-ref="ajaxAuthenticationSuccessHandler"
	//    login-page="/WEB-INF/pages/login/login.jsp"/>
	//    <security:logout logout-url="/j_spring_security_logout"/>
	//    <security:remember-me data-source-ref="dataSource"/>
	//    <!--<security:custom-filter ref="digestFilter" after="BASIC_AUTH_FILTER"/>-->
	//    </security:http>
	//
	//    <security:authentication-manager alias="authenticationManager">
	//    <security:authentication-provider user-service-ref="moneyUserDetailsService">
	//    <security:password-encoder hash="md5">
	//    <security:salt-source user-property="username"/>
	//    </security:password-encoder>
	//    </security:authentication-provider>
	//    </security:authentication-manager>
	//
	//
	//    <!--<bean id="digestFilter" class="org.springframework.security.web.authentication.www.DigestAuthenticationFilter">-->
	//    <!--<property name="userDetailsService" ref="moneyUserDetailsService"/>-->
	//    <!--<property name="authenticationEntryPoint" ref="digestEntryPoint"/>-->
	//    <!--</bean>-->

}
