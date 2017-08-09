package com.cms.utils;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static{
        try{
            reader = Resources.getResourceAsReader("com/cms/config/Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){
    	return sqlSessionFactory;
    }
}
