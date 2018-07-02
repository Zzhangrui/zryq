package com.zryq.cms.common.data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Rui
 * Date: 2018/6/21
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */
public class EChartsData {

    private Object[] xAxisData;

    private Object[] yAxisData;

    public Object[] getxAxisData() {
        return xAxisData;
    }

    public void setxAxisData(Object[] xAxisData) {
        this.xAxisData = xAxisData;
    }

    public Object[] getyAxisData() {
        return yAxisData;
    }

    public void setyAxisData(Object[] yAxisData) {
        this.yAxisData = yAxisData;
    }
}
