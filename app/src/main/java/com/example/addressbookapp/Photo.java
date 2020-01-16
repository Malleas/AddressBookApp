package com.example.addressbookapp;

public class Photo {

    public int photoId;
    public String fileName;
    public String dateOfPhoto;
    public String description;


    public Photo(int photoId, String fileName, String dateOfPhoto, String description) {
        this.photoId = photoId;
        this.fileName = fileName;
        this.dateOfPhoto = dateOfPhoto;
        this.description = description;
    }

    public Photo(){}

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDateOfPhoto() {
        return dateOfPhoto;
    }

    public void setDateOfPhoto(String dateOfPhoto) {
        this.dateOfPhoto = dateOfPhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "photoId=" + photoId +
                ", fileName='" + fileName + '\'' +
                ", dateOfPhoto='" + dateOfPhoto + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
