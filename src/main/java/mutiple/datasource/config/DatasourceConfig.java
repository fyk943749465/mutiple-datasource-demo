package mutiple.datasource.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 创建数据源：如果是一个数据源,springboot在启动时候，自动创建。
 * 如果多个数据源，需要自己手动自动配置，创建数据源，放入容器中
 */
@Slf4j
@Configuration
public class DatasourceConfig {

    @Primary
    @Bean(name = "primaryDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secondaryDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDatasource() {
        return DataSourceBuilder.create().build();
    }

    public static void logDS(DataSource dataSource) {
        HikariDataSource hds = (HikariDataSource) dataSource;
        String info = "\n\n\tHikariCP连接池配置\n\t连接池名称：" +
                hds.getPoolName() +
                "\n\t最小空虚连接数：" +
                hds.getMinimumIdle() +
                "\n\t最大连接数：" +
                hds.getMaximumPoolSize() +
                "\n\t连接超时时间：" +
                hds.getConnectionTimeout() +
                "ms\n\t空虚连接超时时间：" +
                hds.getIdleTimeout() +
                "ms\n\t连接最长生命周期：" +
                hds.getMaxLifetime() +
                "ms\n";
        log.info(info);
    }
}
