package com.example.uts;

public class GaleriClass {
    private int id;
    private String name;
    private String photo;
    private String isi;

    public GaleriClass(int id, String name, String photo, String isi) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.isi = isi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
