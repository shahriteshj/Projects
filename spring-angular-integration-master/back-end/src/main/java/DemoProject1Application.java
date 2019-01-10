import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.jpm.association.controllers")
public class DemoProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoProject1Application.class, args);
	}
}

