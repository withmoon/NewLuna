package com.study.luna.mg.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryBean {
	private static SqlSessionFactory sessionfactory = null;
	static {
		try {
			if(sessionfactory == null){
				Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
				System.out.println(reader.toString());
				sessionfactory = new SqlSessionFactoryBuilder().build(reader);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSqlSessionInstance() {
		return sessionfactory.openSession();
	}
}
