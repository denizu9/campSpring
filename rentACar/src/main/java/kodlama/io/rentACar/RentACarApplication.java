package kodlama.io.rentACar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	// Uygulama çalıştığı anda anatasyonları tarar. Ve @Bean'i gördüğü anda da bu bir nesne daha sonrasında buna biri
	// constructor'ında ihtiyaç duyabilir der ve bu yüzden IOC referansını ekler. Yani bir tane ModelMapper üretir ve ihtiyacı
	// olan yerde kullanır.
	 @Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}
