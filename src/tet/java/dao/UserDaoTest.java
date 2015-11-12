package dao;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import config.MybatisConfig;
import entity.User;

public class UserDaoTest {
	
	private SqlSession sqlSession;
	private UserDao userDao;

	@Before
	public void setUp() throws Exception {
		sqlSession = MybatisConfig.getSession();
		userDao = sqlSession.getMapper(UserDao.class);
	}

	@After
	public void tearDown() throws Exception {
		sqlSession.commit();
		sqlSession.close();
	}

	@Test
	public void testSelect() {
		assertNotNull(userDao.select(1));
	}

	@Test@Ignore
	public void testInsert() {
		User user = new User();
		user.setUsername("mybatis");
		user.setPassword("mybatis");
		userDao.insert(user);
		assertNotNull(user.getUserid());
	}

	@Test@Ignore
	public void testDelete() {
		userDao.delete(7);
	}

	@Test@Ignore
	public void testUpdate() {
		User user = userDao.select(1);
		user.setUsername("mybatis");
		userDao.update(user);
	}

}
