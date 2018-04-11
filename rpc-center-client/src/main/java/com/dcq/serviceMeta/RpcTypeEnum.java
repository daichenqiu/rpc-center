package com.dcq.serviceMeta;

/**
 * Demo class
 *
 * @author chenqiudai
 * @date 11/04/2018
 */
public enum RpcTypeEnum {

    HTTP(1,"1"),
    TCP(2,"2");

    private int type;

    private String typeStr;

    RpcTypeEnum(int type,String typeStr) {
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
