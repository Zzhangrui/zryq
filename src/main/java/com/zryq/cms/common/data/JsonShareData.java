package com.zryq.cms.common.data;

/**
 * Created by Lollipop on 2017/4/13.
 */
public class JsonShareData {
    private String name;
    private Integer num;
    private String hotelName;

    public JsonShareData(String name, Integer num) {
        this.name = name;
        this.num = num;
    }

    public JsonShareData(String name, Integer num, String hotelName) {
        this.name = name;
        this.num = num;
        this.hotelName = hotelName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
}
