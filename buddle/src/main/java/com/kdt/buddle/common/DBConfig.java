package com.kdt.buddle.common;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DBConfig implements WebMvcConfigurer {


  @Bean
  public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
//    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    Resource configLocation = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");

    sessionFactory.setConfigLocation(configLocation);
    return sessionFactory.getObject();
  }

  @Bean
  public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
    return new SqlSessionTemplate(sqlSessionFactory);
  }
}
