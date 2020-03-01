package com.ts.server.mask.controller.client.vo;

/**
 * 初始化输出对象
 *
 * @author TS Group
 */
public class InitVo {
    private final String notice;
    private final String[] goDates;

    public InitVo(String notice, String[] goDates) {
        this.notice = notice;
        this.goDates = goDates;
    }

    public String getNotice() {
        return notice;
    }

    public String[] getGoDates() {
        return goDates;
    }

}
