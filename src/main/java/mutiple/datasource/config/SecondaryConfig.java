package mutiple.datasource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 第二数据源dengine，用于mybatis
 */
@Configuration
@MapperScan(basePackages = { SecondaryConfig.PACKAGE }, sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondaryConfig {

    static final String PACKAGE = "mutiple.datasource.secondary.dao";
    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";


    @Bean(name = "secondTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager(@Qualifier("secondaryDatasource") DataSource clusterDataSource) {
        return new DataSourceTransactionManager(clusterDataSource);
    }

    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("secondaryDatasource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SecondaryConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
