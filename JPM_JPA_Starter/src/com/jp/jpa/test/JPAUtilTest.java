package com.jp.jpa.test;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import com.jp.jpa.util.JPAUtil;

public class JPAUtilTest {

	@Test
	public void testEntityManager() {
		EntityManager em = JPAUtil.getEntityManager();
		Assert.assertNotNull("Entity Manager is null", em);
	}

}
