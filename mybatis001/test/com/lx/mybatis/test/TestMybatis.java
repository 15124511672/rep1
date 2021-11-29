package com.lx.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lx.mybatis.pojo.Emp;

public class TestMybatis {

	public static void main(String[] args) throws IOException {
		//1、读取mybatis配置文件(得到数据源和可以调用SQL映射文件信息)
		Reader reader = Resources.getResourceAsReader("mybatis.xml");//读取mybatis配置文件
		//2、根据读取到的信息创建SqlSessionFactory
		SqlSessionFactory  ssf = new SqlSessionFactoryBuilder().build(reader);
		//3、创建SqlSession对象
		SqlSession sqlSession = ssf.openSession();
		//4、通过SqlSession对象调用SQL映射文件中的信息
		List<Emp> empList = sqlSession.selectList("aa.queryAllEmp");
		
		System.out.println(empList);
	}
}
