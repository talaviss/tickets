package com.amdocs.ticket;
import static org.assertj.core.api.Assertions.*;

import com.amdocs.ticket.repository.TicketRepository;
import com.amdocs.ticket.model.Ticket;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketApplicationTests {

	@Autowired
	TicketRepository repository;



	@Before
	public void setUp() {

		repository.deleteAll();

		repository.save(new Ticket("problem with phone lg4", "phone problem", true));
		repository.save(new Ticket("Renew SLA", "SLA phone", true));
		repository.save(new Ticket("Wrong number on call", "phone problem", true));
	}

	@Test
	public void setsIdOnSave() {

		Ticket ticket = repository.save(new Ticket("the cat is on fire", "firecat", true));

		assertThat(ticket.getId()).isNotNull();
	}

	@Test
	public void findsByDescription() {

		List<Ticket> result = repository.findByDescription("Renew SLA");

		assertThat(result).hasSize(1).extracting("description").contains("Renew SLA");
	}

	@Test
	public void findsByExample() {

		Ticket probe = new Ticket(null, "phone problem", true);

		List<Ticket> result = repository.findAll(Example.of(probe));

		assertThat(result).hasSize(2).extracting("description").contains("problem with phone lg4", "Wrong number on call");
	}

	@After
	public void tearDown() {

		repository.deleteAll();


	}

}
