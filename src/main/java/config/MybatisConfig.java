package config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * mybatis配置
 */
public class MybatisConfig {

    private static final SqlSessionFactory sqlSessionFactory = buildSessionFactory();

    private static SqlSessionFactory buildSessionFactory() {
    	SqlSessionFactory sessionFactory = null;
		try {
			sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionFactory;
    }

    public static SqlSessionFactory getSessionFactory() {
        return sqlSessionFactory;
    }
    
    public static SqlSession getSession() {
    	return sqlSessionFactory.openSession();
    }

    
}