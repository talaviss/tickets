package com.amdocs.ticket;
import static org.assertj.core.api.Assertions.*;

import com.amdocs.ticket.repository.TicketRepository;
import com.amdocs.ticket.model.Ticket;
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

	Ticket dave, oliver, carter;

	@Before
	public void setUp() {

		repository.deleteAll();

		dave = repository.save(new Ticket("Dave", "Matthews", true));
		oliver = repository.save(new Ticket("Oliver August", "Matthews", true));
		carter = repository.save(new Ticket("Carter", "Beauford", true));
	}

	@Test
	public void setsIdOnSave() {

		Ticket dave = repository.save(new Ticket("Dave", "Matthews", true));

		assertThat(dave.getId()).isNotNull();
	}

	@Test
	public void findsByLastName() {

		List<Ticket> result = repository.findByDescription("Beauford");

		assertThat(result).hasSize(1).extracting("firstName").contains("Carter");
	}

	/*@Test
	public void findsByExample() {

		Ticket probe = new Ticket(null, "Matthews", true);

		List<Ticket> result = repository.findAll(Example.of(probe));

		assertThat(result).hasSize(2).extracting("firstName").contains("Dave", "Oliver August");
	}*/

}
