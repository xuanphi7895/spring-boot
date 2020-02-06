package phitx.example.warehourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories()
public class WarehourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarehourseApplication.class, args);
	}

}
