package com.northuniversity.model;

import java.util.List;

public class EchartsModel {
    private  String name;
    private  String type;
    private  String stack;
    private List<Integer> data;

    @Override
    public String toString() {
        return "EchartsModel{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", stack='" + stack + '\'' +
                ", data=" + data +
                '}';
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public EchartsModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
