package app;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringCloudApplication
@EnableHystrixDashboard
public class SimpleApplication {

	public static void main(final String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}

}
