package com.amdocs.ticket;

import com.amdocs.ticket.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.amdocs.ticket.model.Ticket;
@SpringBootApplication
public class TicketApplication {


	private static final Logger logger = LoggerFactory.getLogger(TicketApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketApplication.class, args);
	}



	@Bean
	public CommandLineRunner setup(TicketRepository ticketRepository) {
		return (args) -> {
			ticketRepository.save(new Ticket("Gustavo", "Ponce", true));
			ticketRepository.save(new Ticket("John", "Smith", true));
			ticketRepository.save(new Ticket("Jim ", "Morrison", false));
			ticketRepository.save(new Ticket("David", "Gilmour", true));
			logger.info("The sample data has been generated");
		};
	}
}
