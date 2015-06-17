package com.mydomain.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.mydomain.data.SimpleExample;
import com.mydomain.domain.Account;

public class SimpleExampleTest {

	@Test
	public void testSelectAllAccounts() {
		try {
			List<Account> list = SimpleExample.selectAllAccounts();
			System.out.println(list.size());
			for(Account a : list) {
				System.out.println(a.getId() + "," + a.getFirstName()+ "," + a.getLastName() + "," + a.getEmailAddress());
			}
			//System.out.println(Arrays.toString(list.toArray()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectAccountById() {
		try {
			Account a = SimpleExample.selectAccountById(1);
			System.out.println(a.getFirstName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*@Test
	public void testInsertAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateAccount() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAccount() {
		fail("Not yet implemented");
	}*/

}
