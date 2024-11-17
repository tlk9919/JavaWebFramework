package com.example.lession12springconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author admin
 * @classnam ProjectConfig
 * @time 16:34
 * @date 2024/11/12
 */
@Component
@ConfigurationProperties(prefix = "projectconfig")
public class ProjectConfig {

    private String projectName;

    private String javaVersion;

    private String desc;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ProjectConfig{" +
                "projectName='" + projectName + '\'' +
                ", javaVersion='" + javaVersion + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
