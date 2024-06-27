package com.example.entity;

public class ComputerTableBean {
    private String planID;
    private String cpu;
    private String cpuPrice;
    private String motherBorad;
    private String motherBoradPrice;
    private String case1;
    private String case1Price;
    private String cooler;
    private String coolerPrice;
    private String graphics_card;
    private String graphics_cardPrice;
    private String hardDisk;
    private String hardDiskPrice;
    private String memory;
    private String memoryPrice;
    private String monitor;
    private String monitorPrice;
    private String powersupply;
    private String powersupplyPrice;
    private String totalPrice;

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCpuPrice() {
        return cpuPrice;
    }

    public void setCpuPrice(String cpuPrice) {
        this.cpuPrice = cpuPrice;
    }

    public String getMotherBorad() {
        return motherBorad;
    }

    public void setMotherBorad(String motherBorad) {
        this.motherBorad = motherBorad;
    }

    public String getMotherBoradPrice() {
        return motherBoradPrice;
    }

    public void setMotherBoradPrice(String motherBoradPrice) {
        this.motherBoradPrice = motherBoradPrice;
    }

    public String getCase1() {
        return case1;
    }

    public void setCase1(String case1) {
        this.case1 = case1;
    }

    public String getCase1Price() {
        return case1Price;
    }

    public void setCase1Price(String case1Price) {
        this.case1Price = case1Price;
    }

    public String getCooler() {
        return cooler;
    }

    public void setCooler(String cooler) {
        this.cooler = cooler;
    }

    public String getCoolerPrice() {
        return coolerPrice;
    }

    public void setCoolerPrice(String coolerPrice) {
        this.coolerPrice = coolerPrice;
    }

    public String getGraphics_card() {
        return graphics_card;
    }

    public void setGraphics_card(String graphics_card) {
        this.graphics_card = graphics_card;
    }

    public String getGraphics_cardPrice() {
        return graphics_cardPrice;
    }

    public void setGraphics_cardPrice(String graphics_cardPrice) {
        this.graphics_cardPrice = graphics_cardPrice;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getHardDiskPrice() {
        return hardDiskPrice;
    }

    public void setHardDiskPrice(String hardDiskPrice) {
        this.hardDiskPrice = hardDiskPrice;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMemoryPrice() {
        return memoryPrice;
    }

    public void setMemoryPrice(String memoryPrice) {
        this.memoryPrice = memoryPrice;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getMonitorPrice() {
        return monitorPrice;
    }

    public void setMonitorPrice(String monitorPrice) {
        this.monitorPrice = monitorPrice;
    }

    public String getPowersupply() {
        return powersupply;
    }

    public void setPowersupply(String powersupply) {
        this.powersupply = powersupply;
    }

    public String getPowersupplyPrice() {
        return powersupplyPrice;
    }

    public void setPowersupplyPrice(String powersupplyPrice) {
        this.powersupplyPrice = powersupplyPrice;
    }

    public String getPlanID() {
        return planID;
    }

    public void setPlanID(String planID) {
        this.planID = planID;
    }
    @Override
    public String toString() {
        return "ComputerTableBean{" +
                "planID='" + planID + '\'' +
                ", cpu='" + cpu + '\'' +
                ", cpuPrice='" + cpuPrice + '\'' +
                ", motherBorad='" + motherBorad + '\'' +
                ", motherBoradPrice='" + motherBoradPrice + '\'' +
                ", case1='" + case1 + '\'' +
                ", case1Price='" + case1Price + '\'' +
                ", cooler='" + cooler + '\'' +
                ", coolerPrice='" + coolerPrice + '\'' +
                ", graphics_card='" + graphics_card + '\'' +
                ", graphics_cardPrice='" + graphics_cardPrice + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", hardDiskPrice='" + hardDiskPrice + '\'' +
                ", memory='" + memory + '\'' +
                ", memoryPrice='" + memoryPrice + '\'' +
                ", monitor='" + monitor + '\'' +
                ", monitorPrice='" + monitorPrice + '\'' +
                ", powersupply='" + powersupply + '\'' +
                ", powersupplyPrice='" + powersupplyPrice + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                '}';
    }
}
