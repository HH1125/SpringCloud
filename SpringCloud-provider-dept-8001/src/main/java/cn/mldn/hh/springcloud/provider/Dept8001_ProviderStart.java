package cn.mldn.hh.springcloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//如果要想将此为服务注册到Eureka之中 则需要添加此注解@EnableEurekaClient
@EnableEurekaClient
public class Dept8001_ProviderStart {
	public static void main(String[] args) {
		SpringApplication.run(Dept8001_ProviderStart.class, args) ;
	}
}
