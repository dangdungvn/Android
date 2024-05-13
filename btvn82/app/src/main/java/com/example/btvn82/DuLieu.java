package com.example.btvn82;

import java.io.Serializable;

public class DuLieu implements Serializable {
    String hoTen;
    String gioiTinh;
    String queQuan;

    public DuLieu() {
    }

    public DuLieu(String hoTen, String gioiTinh, String queQuan) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    @Override
    public String toString() {
        return "DuLieu{" +
                "hoTen='" + hoTen + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", queQuan='" + queQuan + '\'' +
                '}';
    }
}
