package com.github.nschlechter.showlist_server;

import com.github.nschlechter.data.entity.VenueEntity;
import com.github.nschlechter.data.repository.VenueRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Slf4j
@SpringBootApplication
public class ShowlistServerApplication {

	private static final Logger log = LoggerFactory.getLogger(ShowlistServerApplication.class);
	@Autowired
	VenueRepo venueRepo;

	public static void main(String[] args) {
		SpringApplication.run(ShowlistServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");
			venueRepo.save(new VenueEntity("Red rocks"));
			List<VenueEntity> venues = (List<VenueEntity>) venueRepo.findAll();
			log.info("Venue added: {}", venues.get(0).getName());
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}

		};
	}
}
