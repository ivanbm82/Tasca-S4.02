package cat.itacademy.barcelonactiva.BuenoMartinIvan.s04.t02.n02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application-secrets.properties")
@ConfigurationPropertiesScan("cat.itacademy.barcelonactiva.BuenoMartinIvan.s04.t02.n02")
@SpringBootApplication
public class S04T02N02BuenoMartinIvanApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N02BuenoMartinIvanApplication.class, args);
	}

}
