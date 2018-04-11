package com.dcq.serviceMeta;

public enum HttpTypeEnum {

    GET(1,"get"),
    POST(2,"post");

    private int type;

    private String typeStr;

    HttpTypeEnum(int type,String typeStr) {
        this.type = type;
        this.typeStr = typeStr;
    }

    public int getType() {
        return type;
    }

    public String getTypeStr() {
        return typeStr;
    }
}
