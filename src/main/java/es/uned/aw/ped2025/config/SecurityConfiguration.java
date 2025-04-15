package es.uned.aw.ped2025.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import es.uned.aw.ped2024.model.repository.UsuarioRepository;

@Configuration
public class SecurityConfiguration {
	
	@Autowired
    private UserDetailsService userDetailsService;
	
    @Autowired
	private AuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private LogoutSuccessHandler myLogoutSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .authenticationProvider(autenticationProvider())
            .build();
    }
	@Bean 
	public AuthenticationProvider autenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
     
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		//.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home", "/registro/**", "/webjars/**", "/login","/img","/contenido/novedades").permitAll()
				.requestMatchers("/gestor/**").hasRole("GESTOR")
				.requestMatchers("/user/**").hasRole("USER")
				.requestMatchers("/**").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
		//.formLogin(Customizer.withDefaults())
		.formLogin(formLogin -> formLogin
				.loginPage("/login")
				//.loginProcessingUrl("/login")
				.successHandler(myAuthenticationSuccessHandler)
				.failureHandler(authenticationFailureHandler)
				//.defaultSuccessUrl("/home.html")
				.permitAll()
         )
        .logout((logout) -> logout.logoutSuccessHandler(myLogoutSuccessHandler)
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login?logout")
                .deleteCookies("JSESSIONID")
                .permitAll())
		/*
        .formLogin((formLogin) -> formLogin.loginPage("/login")
                .defaultSuccessUrl("/home.html")
                .failureUrl("/login?error=true")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .permitAll())
        .sessionManagement((sessionManagement) -> sessionManagement.invalidSessionUrl("/invalidSession.html")
                .maximumSessions(1)
                .sessionRegistry(sessionRegistry()))
*/
			
		/*
		 .passwordManagement((management) -> management
			        .changePasswordPage("/update-password"))
		 .sessionManagement((sessionManagement) ->
			  				sessionManagement
			  					.sessionConcurrency((sessionConcurrency) ->
			  						sessionConcurrency
			  							.maximumSessions(1)
			  							.expiredUrl("/login?expired")
			  					)
             )
             */
		 ;
		return http.build();
	}
	@Bean
	    public LogoutSuccessHandler logoutSuccessHandler() {
	        return new CustomLogoutSuccessHandler();
	    }
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

}
