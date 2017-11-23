package cn.mldn.hh.springcloud.provider.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@Configuration
@EnableWebSecurity	// 启用WEB安全配置
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * 此方法中添加认证信息，在调用业务层方法时需要进行一次认证，认证之后不再需要重新认证
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 定义两个用户的信息，一个是hh/1125、admin/1125
		auth.inMemoryAuthentication().withUser("hh").password("1125").roles("USER").and().withUser("admin")
				.password("1125").roles("USER", "ADMIN");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 进行WEB认证启用，由Spring内部负责实现认证处理机制，所有的访问都需要进行认证处理
//		http.httpBasic(); 
		http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated() ; 
		// 采用无状态的形式来定义Session的管理
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) ;
	}
}
