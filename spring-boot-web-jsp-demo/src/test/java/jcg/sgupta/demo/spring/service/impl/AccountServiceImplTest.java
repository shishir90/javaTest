package jcg.sgupta.demo.spring.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import jcg.sgupta.demo.spring.TestConfig;
import jcg.sgupta.demo.spring.TestData;
import jcg.sgupta.demo.spring.entity.Account;
import jcg.sgupta.demo.spring.repository.AccountRepository;
import jcg.sgupta.demo.spring.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class AccountServiceImplTest {

	@Autowired
	private AccountService classToTest;
	
	@Autowired
	private AccountRepository acctRepo;

	@Test
	public void findByUsername_not_found() {
		Account foundAcct = classToTest.findByUsername("testUser");
		assertNull(foundAcct);
	}

	@Test
	public void findByUsername_found() {
		
		acctRepo.save(TestData.createDummy("Marysgupta", "Mary", "sgupta"));
		Account foundAcct = classToTest.findByUsername("Marysgupta");
		assertNotNull(foundAcct);
		assertEquals(1, foundAcct.getId().intValue());
	}
}
