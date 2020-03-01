package com.ts.server.mask.config;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置属性
 *
 * @author TS Group
 */
@ConfigurationProperties(prefix = "go")
public class GoProperties {
    private String notice;
    private String[] goDates;

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String[] getGoDates() {
        return goDates;
    }

    public void setGoDates(String[] goDates) {
        this.goDates = goDates;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("notice", notice)
                .append("goDates", goDates)
                .toString();
    }
}
