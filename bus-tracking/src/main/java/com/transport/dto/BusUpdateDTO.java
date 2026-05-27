package com.transport.dto;

public class BusUpdateDTO {

    private String numberPlate;
    private double latitude;
    private double longitude;
    private double speed;
    private String status;

    public String getNumberPlate() {
        return numberPlate;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getSpeed() {
        return speed;
    }

    public String getStatus() {
        return status;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}