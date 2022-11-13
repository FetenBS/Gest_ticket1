package org.sid;







import org.sid.entities.ClientEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class GestTicket1Application implements CommandLineRunner{

	@Autowired
	//private RepositoryRestConfiguration restConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(GestTicket1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//restConfiguration.exposeIdsFor(ClientEntity.class);
		//clientRepository.save(new ClientEntity(null,"feten","ben slimen",01/12/2021,"sdfg","vbnvb"));
	}

}
