package com.guanshan.phoenix.enums;

public enum CloudwareTypeEnum {
    RSTUDIO(1, "type 1", "第一个类型");

    private int code;
    private String en;
    private String zh;

    public int getCode() {
        return code;
    }

    public String getEn() {
        return en;
    }

    public String getZh() {
        return zh;
    }

    CloudwareTypeEnum(int index, String en, String zh) {
        this.code = index;
        this.en = en;
        this.zh = zh;
    }

    public static String getEnFromCode(int code) {
        for (CloudwareTypeEnum cloudwareTypeEnum : CloudwareTypeEnum.values()) {
            if (cloudwareTypeEnum.getCode() == code) {
                return cloudwareTypeEnum.getEn();
            }
        }
        return "null";
    }

    public static String getZhFromCode(int code) {
        for (CloudwareTypeEnum cloudwareTypeEnum : CloudwareTypeEnum.values()) {
            if (cloudwareTypeEnum.getCode() == code) {
                return cloudwareTypeEnum.getZh();
            }
        }
        return "null";
    }

    @Override
    public String toString(){
        return super.toString().toLowerCase();
    }

    public static CloudwareTypeEnum fromInt(int i){
        if(i >= CloudwareTypeEnum.values().length){
            return null;
        }

        return CloudwareTypeEnum.values()[i-1];
    }
}
