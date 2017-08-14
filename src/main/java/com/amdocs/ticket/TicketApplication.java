package com.amdocs.ticket;

import com.amdocs.ticket.model.Ticket;
import com.amdocs.ticket.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.amdocs.ticket.repository.TicketRepository;

//import com.amdocs.ticket.repository.TicketRepository;
@SpringBootApplication
public class TicketApplication  implements CommandLineRunner {

	@Autowired
	private TicketRepository repository;


	private static final Logger logger = LoggerFactory.getLogger(TicketApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketApplication.class, args);
	}



	/*@Bean
	public CommandLineRunner setup(TicketRepository ticketRepository) {
		return (args) -> {
			ticketRepository.save(new Ticket("Gustavo", "Ponce", true));
			ticketRepository.save(new Ticket("John", "Smith", true));
			ticketRepository.save(new Ticket("Jim ", "Morrison", false));
			ticketRepository.save(new Ticket("David", "Gilmour", true));
			logger.info("The sample data has been generated");
		};
	}*/


	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Ticket("aaa", "bbb", true));
		repository.save(new Ticket("ccc", "ddd", true));

		// fetch all customers
		System.out.println("tickets found with findAll():");
		System.out.println("-------------------------------");
		for (Ticket ticket : repository.findAll()) {
			System.out.println(ticket);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByDescription('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByDescription("aaa"));

		System.out.println("Customers found with findByTitle('ddd'):");
		System.out.println("--------------------------------");
		for (Ticket ticket : repository.findByTitle("Smith")) {
			System.out.println(ticket);
		}

	}

}
