package com.huan.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author <a href="mailto:jean@eastcode.org">Jean Seurin</a>
 * @since 24/11/15 - 19:15
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:datasource.properties")
@MapperScan("com.huan.**.mapper") //扫描跑mapper包下的所有接口，作为mybatis接口类，并注册为spring的bean
public class MybatisConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);

    @Value("${jdbc.driverClass}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.user}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${jdbc.maximumPoolSize}")
    private Integer maximumPoolSize;

    /**
     * 数据库连接配置
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource() {
        logger.debug("Configuring Datasource");

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setMaxActive(maximumPoolSize);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setMinIdle(1);
        druidDataSource.setValidationQuery("SELECT 1");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        /**
         * configuration exception handling
         * */
        druidDataSource.setQueryTimeout(15); //查询超时时间15s
        //通过datasource.getConnontion() 取得的连接必须在removeAbandonedTimeout这么多秒内调用close(),要不强制关闭.(就是conn不能超过指定的租期)
        druidDataSource.setRemoveAbandoned(true);
        druidDataSource.setRemoveAbandonedTimeout(600); //一个连接的租期10分钟，超时会被强制关闭
        druidDataSource.setLogAbandoned(true);
        return druidDataSource;
    }


    /**
     * 将mybatis的sqlSessionFactory交给spring管理
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));
        sessionFactory.setTypeAliasesPackage("com.huan.**.model");
        return sessionFactory;
    }

}
