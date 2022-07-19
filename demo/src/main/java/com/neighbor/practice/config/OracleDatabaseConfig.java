package com.neighbor.practice.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableEncryptableProperties
@EnableTransactionManagement
public class OracleDatabaseConfig {

	/**
	 * MyBatis Mapper File 이 저장된 경로를 추출한다.
	 */
	private @Value("${spring.datasource.mapper.path}") String mapperPath;

	/**
	 * Oracle DataSource 를 생성하여 Spring Bean 으로 등록한다.
	 * 
	 * @return
	 */
	@Bean(name = "oracleDataSource")
	@ConfigurationProperties("spring.datasource.hikari")
	public DataSource oracleDataSource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

	/**
	 * Oracle DataSource Factory 를 생성하여 Spring Bean 으로 등록한다.
	 * 
	 * @param oracleDataSource
	 * @param applicationContext
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "oracleSessionFactory")
	@Primary
	public SqlSessionFactory oracleSessionFactory(@Qualifier("oracleDataSource") DataSource oracleDataSource,
			ApplicationContext applicationContext) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(oracleDataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mapperPath));
		
		sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	
	/*@Bean(name = "oracleSessionTemplate", destroyMethod = "clearCache")
	@Primary
	public SqlSessionTemplate oracleSessionTemplate(SqlSessionFactory oracleSessionFactory) throws SQLException {
		return new SqlSessionTemplate(oracleSessionFactory);
	}*/
	
	// -------------------
	
	 @Bean(name = "oracleSessionTemplate", destroyMethod="clearCache")
	    public SqlSessionTemplate oracleSessionTemplate(SqlSessionFactory oracleSessionFactory) throws SQLException, DataAccessException {
	        return new SqlSessionTemplate(oracleSessionFactory);
	    }
	    
	    /**
		 * Oracle Session Batch.
		 * @param oracleBatchTemplate
		 * @return
		 * @throws SQLException
		 */
	    @Bean(name = "OracleBatchTemplate", destroyMethod="clearCache")
	    public SqlSessionTemplate oracleBatchTemplate(SqlSessionFactory oracleSessionFactory) throws SQLException, DataAccessException {
	        return new SqlSessionTemplate(oracleSessionFactory, ExecutorType.BATCH);
	    }
}
