package com.finn.blog.id.datasource.hikaricp;

import com.baomidou.dynamic.datasource.creator.DataSourceCreator;
import com.baomidou.dynamic.datasource.creator.DataSourceProperty;
import com.baomidou.dynamic.datasource.creator.hikaricp.HikariCpConfig;
import com.baomidou.dynamic.datasource.toolkit.ConfigMergeCreator;
import com.baomidou.dynamic.datasource.toolkit.DsStrUtils;
import com.finn.blog.id.constants.Constants;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Configuration
public class HikariDataSourceCreator implements DataSourceCreator {

    private static final ConfigMergeCreator<HikariCpConfig, HikariConfig> MERGE_CREATOR =
            new ConfigMergeCreator<>("HikariCp", HikariCpConfig.class, HikariConfig.class);

    private HikariCpConfig gConfig;
    private static Method configCopyMethod = null;


    static {
        fetchMethod();
    }

    private static void fetchMethod() {
        Class<HikariConfig> hikariConfigClass = HikariConfig.class;
        try {
            configCopyMethod = hikariConfigClass.getMethod("copyStateTo", HikariConfig.class);
            return;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("HikariConfig not found copyStateTo method");
    }

    @Override
    @Bean
    public DataSource createDataSource(DataSourceProperty dataSourceProperty) {
        HikariConfig config = MERGE_CREATOR.create(gConfig, dataSourceProperty.getHikari());
        config.setJdbcUrl(dataSourceProperty.getUrl());
        config.setUsername(dataSourceProperty.getUsername());
        config.setPassword(dataSourceProperty.getPassword());
        String driverClassName = dataSourceProperty.getDriverClassName();
        if (DsStrUtils.hasText(driverClassName)) {
            config.setDriverClassName(driverClassName);
        }
        if (Boolean.FALSE.equals(dataSourceProperty.getLazy())) {
            return new HikariDataSource(config);
        }
        config.validate();
        HikariDataSource hikariDataSource = new HikariDataSource();
        try {
            configCopyMethod.invoke(config, hikariDataSource);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("HikariConfig failed to copy to HikariDataSource", e);
        }
        return hikariDataSource;
    }

    @Override
    public boolean support(DataSourceProperty dataSourceProperty) {
        Class<? extends DataSource> type = dataSourceProperty.getType();
        return type == null || Constants.HIKARI_DATASOURCE.equals(type.getName());
    }
}
