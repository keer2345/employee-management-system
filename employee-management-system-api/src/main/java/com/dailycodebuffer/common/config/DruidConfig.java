package com.dailycodebuffer.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Druid数据源连接池配置
 *
 * @author keer
 */
@Slf4j
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DruidConfig {
  public DruidConfig() {
    log.info(">>> Using Druid ...");
  }

  private String url;
  private String username;
  private String password;
  private String driverClassName;
  private int initialSize;
  private int minIdle;
  private int maxActive;
  private int maxWait;
  private int timeBetweenEvictionRunsMillis;
  private int minEvictableIdleTimeMillis;
  private String validationQuery;
  private boolean testWhileIdle;
  private boolean testOnBorrow;
  private boolean testOnReturn;
  private boolean poolPreparedStatements;
  private int maxPoolPreparedStatementPerConnectionSize;
  private String filters;
  private String connectionProperties;

  /**
   * 解决 spring.datasource.filters=stat,wall,log4j
   *
   * <p>无法正常注册 在同样的DataSource中，首先使用被标注的DataSource
   *
   * @return DataSource
   */
  @Bean
  @Primary
  public DataSource dataSource() {
    DruidDataSource datasource = new DruidDataSource();
    datasource.setUrl(url);
    datasource.setUsername(username);
    datasource.setPassword(password);
    datasource.setDriverClassName(driverClassName);

    // configuration
    datasource.setInitialSize(initialSize);
    datasource.setMinIdle(minIdle);
    datasource.setMaxActive(maxActive);
    datasource.setMaxWait(maxWait);
    datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
    datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
    datasource.setValidationQuery(validationQuery);
    datasource.setTestWhileIdle(testWhileIdle);
    datasource.setTestOnBorrow(testOnBorrow);
    datasource.setTestOnReturn(testOnReturn);
    datasource.setPoolPreparedStatements(poolPreparedStatements);
    datasource.setMaxPoolPreparedStatementPerConnectionSize(
        maxPoolPreparedStatementPerConnectionSize);
    try {
      datasource.setFilters(filters);
    } catch (SQLException e) {
      System.err.println("druid configuration initialization filter: " + e);
    }
    datasource.setConnectionProperties(connectionProperties);
    return datasource;
  }
}
