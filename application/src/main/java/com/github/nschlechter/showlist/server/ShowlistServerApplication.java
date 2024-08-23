package com.github.nschlechter.showlist.server;

import com.github.nschlechter.showlist.server.dal.entity.ArtistEntity;
import com.github.nschlechter.showlist.server.dal.entity.VenueEntity;
import com.github.nschlechter.showlist.server.dal.repository.ArtistRepo;
import com.github.nschlechter.showlist.server.dal.repository.VenueRepo;
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
	// adding beans here just to ensure that app startup is finding them correctly
	@Autowired
	VenueRepo venueRepo;

	@Autowired
	ArtistRepo artistRepo;

	public static void main(String[] args) {
		SpringApplication.run(ShowlistServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Hello world!");
			venueRepo.save(new VenueEntity("Red rocks"));
			List<VenueEntity> venues = (List<VenueEntity>) venueRepo.findAll();
			log.info("Venue added: {}", venues.get(0).getName());

			artistRepo.save(new ArtistEntity("Flume"));
			log.info("Artist added: {}", artistRepo.findAll().iterator().next().getName());
		};
	}
}
