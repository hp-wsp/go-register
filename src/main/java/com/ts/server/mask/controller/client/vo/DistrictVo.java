package com.ts.server.mask.controller.client.vo;

import com.ts.server.mask.domain.District;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 行政区域输出
 *
 * @author <a href="mailto:hhywangwei@gmail.com">WangWei</a>
 */
public class DistrictVo {
    private final String id;
    private final String name;

    public DistrictVo(District t) {
        this.id = t.getId();
        this.name = t.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .toString();
    }
}
