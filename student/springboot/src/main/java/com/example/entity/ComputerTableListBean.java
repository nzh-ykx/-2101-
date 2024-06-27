package com.example.entity;

import java.util.List;

public class ComputerTableListBean {
        private List<ComputerTableBean> computerList;

    public List<ComputerTableBean> getComputerList() {
        return computerList;
    }

    public void setComputerList(List<ComputerTableBean> computerList) {
        this.computerList = computerList;
    }

    @Override
    public String toString() {
        return "ComputerTableListBean{" +
                "computerList=" + computerList +
                '}';
    }
}
