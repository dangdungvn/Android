package com.example.sqlitetest;

import java.io.Serializable;

public class DuLieu implements Serializable {
    private String ten;
    private int hinh;
    private String mota;
    private boolean vb2;
    private String gioiTinh;

    public DuLieu() {
    }

    public DuLieu(String ten, int hinh, String mota, boolean vb2, String gioiTinh) {
        this.ten = ten;
        this.hinh = hinh;
        this.mota = mota;
        this.vb2 = vb2;
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "DuLieu{" +
                "ten='" + ten + '\'' +
                ", hinh=" + hinh +
                ", mota='" + mota + '\'' +
                ", vb2=" + vb2 +
                ", gioiTinh='" + gioiTinh + '\'' +
                '}';
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public boolean isVb2() {
        return vb2;
    }

    public void setVb2(boolean vb2) {
        this.vb2 = vb2;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
