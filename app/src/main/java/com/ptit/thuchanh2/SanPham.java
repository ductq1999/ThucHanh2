package com.ptit.thuchanh2;

public class SanPham {
    private String name;
    private String image;
    private String gia;
    private String loai;
    public SanPham(String name, String gia, String image) {
        this.name = name;
        this.image = image;
        this.gia = gia;
    }

    public SanPham(String name, String image, String gia, String loai) {
        this.name = name;
        this.image = image;
        this.gia = gia;
        this.loai = loai;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
