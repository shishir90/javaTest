package jcg.sgupta.demo.spring.service;

import jcg.sgupta.demo.spring.entity.Account;

public interface AccountService {
	Account findByUsername(String username);
	Account save(Account accout);
}
