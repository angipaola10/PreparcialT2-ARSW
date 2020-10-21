package edu.eci.arsw.coronavirusStats.Model;

/**
 * The type Latlng.
 */
public class Latlng {

    private double lat;
    private double lng;

    /**
     * Instantiates a new Latlng.
     *
     * @param lat the lat
     * @param lng the lng
     */
    public Latlng(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * Gets lat.
     *
     * @return the lat
     */
    public double getLat() {
        return lat;
    }

    /**
     * Sets lat.
     *
     * @param lat the lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * Gets lng.
     *
     * @return the lng
     */
    public double getLng() {
        return lng;
    }

    /**
     * Sets lng.
     *
     * @param lng the lng
     */
    public void setLng(double lng) {
        this.lng = lng;
    }
}
