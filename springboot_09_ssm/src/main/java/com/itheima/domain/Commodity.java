package com.itheima.domain;

public class Commodity {
    private int comNo;

    @Override
    public String toString() {
        return "Commodity{" +
                "comNo=" + comNo +
                ", comName='" + comName + '\'' +
                ", comDes='" + comDes + '\'' +
                ", comPrice=" + comPrice +
                '}';
    }

    public int getComNo() {
        return comNo;
    }

    public void setComNo(int comNo) {
        this.comNo = comNo;
    }

    private String comName;
    private String comDes;
    private double comPrice;

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComDes() {
        return comDes;
    }

    public void setComDes(String comDes) {
        this.comDes = comDes;
    }

    public double getComPrice() {
        return comPrice;
    }

    public void setComPrice(double comPrice) {
        this.comPrice = comPrice;
    }


}
