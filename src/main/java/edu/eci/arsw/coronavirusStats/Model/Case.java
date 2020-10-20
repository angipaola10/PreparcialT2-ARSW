package edu.eci.arsw.coronavirusStats.Model;

import java.io.Serializable;

public class Case implements Serializable {

    private String city;
    private String province;
    private String country;
    private String lastUpdate;
    private String keyId;
    private int confirmed;
    private int deaths;
    private int recovered;
    private Latlng latlng;

    public Case(){}

    public Case(String city, String province, String country, String lastUpdate, String keyId, int confirmed, int deaths, int recovered) {
        this.city = city;
        this.province = province;
        this.country = country;
        this.lastUpdate = lastUpdate;
        this.keyId = keyId;
        this.confirmed = confirmed;
        this.deaths = deaths;
        this.recovered = recovered;
        this.latlng = new Latlng(0,0);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public Latlng getLatlng() {
        return latlng;
    }

    public void setLatlng(Latlng latlng) {
        this.latlng = latlng;
    }
}
