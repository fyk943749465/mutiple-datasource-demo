//package mutiple.datasource.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
//import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
/**
 * 主要原因是tdengine不支持jpa,但是可以用mybatis，
 */
//import javax.annotation.Resource;
//import javax.persistence.EntityManager;
//import javax.sql.DataSource;
//import java.util.Map;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef="entityManagerFactorySecondary",
//        transactionManagerRef="transactionManagerSecondary",
//        basePackages= { "mutiple.datasource.secondary.repository" }) //设置Repository所在位置
//public class SecondaryConfig {
//
//    @Autowired
//    @Qualifier("secondaryDatasource")
//    private DataSource secondaryDataSource;
//
//    @Resource
//    private JpaProperties jpaProperties;
//
//    @Resource
//    private HibernateProperties hibernateProperties;
//
//    private Map<String, Object> getVendorProperties() {
//        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), new HibernateSettings());
//    }
//
//    @Bean(name = "entityManagerSecondary")
//    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
//        return entityManagerFactorySecondary(builder).getObject().createEntityManager();
//    }
//
//    @Bean(name = "entityManagerFactorySecondary")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecondary (EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(secondaryDataSource)
//                .packages("com.didispace.chapter38.s") //设置实体类所在位置
//                .persistenceUnit("secondaryPersistenceUnit")
//                .properties(getVendorProperties())
//                .build();
//    }
//
//    @Bean(name = "transactionManagerSecondary")
//    PlatformTransactionManager transactionManagerSecondary(EntityManagerFactoryBuilder builder) {
//        return new JpaTransactionManager(entityManagerFactorySecondary(builder).getObject());
//    }
//
//}