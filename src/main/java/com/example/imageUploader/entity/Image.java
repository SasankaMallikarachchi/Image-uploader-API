package com.example.imageUploader.entity;

import javax.persistence.*;

@Table(name = "image")
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imageName;

    private String fileType;

    @Lob
    private byte[] data;

    public Image() {
    }

    public Image(String imageName, String fileType, byte[] data) {
        this.imageName = imageName;
        this.fileType = fileType;
        this.data = data;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }
}
