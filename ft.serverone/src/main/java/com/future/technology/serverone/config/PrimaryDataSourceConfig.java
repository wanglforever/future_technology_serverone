package com.future.technology.serverone.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by wangl on 2017/3/9.
 */
@Configuration
@EnableTransactionManagement
public class PrimaryDataSourceConfig {

    @Bean(name = "udbsDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource bedServerDataSource(){
        return DruidDataSourceBuilder.create()
                .build();
    }

    @Bean(name = "udbsTranscationManager")
    @Primary
    public DataSourceTransactionManager bedServerTranscationManager(@Qualifier("udbsDataSource") DataSource bedServerDataSource){
        return new DataSourceTransactionManager(bedServerDataSource);
    }

    @Bean(name = "udbsSqlSessionFactory")
    @Primary
    public SqlSessionFactory bedServerSqlSessionFactory(@Qualifier("udbsDataSource") DataSource bedServerDataSource)throws Exception{
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(bedServerDataSource);
        return sessionFactory.getObject();
    }

    @Bean
    @Scope("prototype")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("udbsSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public MapperScannerConfigurer primaryScannerConfigurer(){
        MapperScannerConfigurer configur = new MapperScannerConfigurer();
        configur.setSqlSessionFactoryBeanName("udbsSqlSessionFactory");
        configur.setBasePackage("com.future.technology.serverone.*.dao");
        return configur;
    }
}
