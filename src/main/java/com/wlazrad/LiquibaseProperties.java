package com.wlazrad;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;

import java.io.File;
import java.util.Map;

@ConfigurationProperties(
        prefix = "spring.liquibase",
        ignoreUnknownFields = false
)
@Getter
@Setter
public class LiquibaseProperties {
    private String changeLog = "classpath:/db/changelog/db.changelog-master.yaml";
    private boolean clearChecksums;
    private String contexts;
    private String defaultSchema;
    private String liquibaseSchema;
    private String liquibaseTablespace;
    private String databaseChangeLogTable = "DATABASECHANGELOG";
    private String databaseChangeLogLockTable = "DATABASECHANGELOGLOCK";
    private boolean dropFirst;
    private boolean enabled = true;
    private String user;
    private String password;
    private String url;
    private String labels;
    private Map<String, String> parameters;
    private File rollbackFile;
    private boolean testRollbackOnUpdate;
    private String tag;

    public LiquibaseProperties() {
    }

    public String getChangeLog() {
        return this.changeLog;
    }

    public void setChangeLog(String changeLog) {
        Assert.notNull(changeLog, "ChangeLog must not be null");
        this.changeLog = changeLog;
    }
}
