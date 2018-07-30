package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import javax.persistence.EntityManager;
import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaytmapp.util.JPAUtil;
import com.sun.xml.internal.stream.Entity;

public class WalletRepoImpl implements WalletRepo {

	private EntityManager entityManager;

	public WalletRepoImpl() {
		super();
		entityManager = JPAUtil.getEntityManager();

	}

	@Override
	public Customer findOne(String mobileNo) {

		Customer customer = entityManager.find(Customer.class, mobileNo);

		if (customer != null)
			return customer;

		return null;
	}

	@Override
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub

		try {
			entityManager.persist(customer);

		} catch (Exception e) {

			return false;
		}

		return true;

	}

	@Override
	public boolean update(Customer customer) {

		entityManager.merge(customer);

		return true;
	}

	@Override
	public void startTransaction() {
		entityManager.getTransaction().begin();

	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();

	}

}
