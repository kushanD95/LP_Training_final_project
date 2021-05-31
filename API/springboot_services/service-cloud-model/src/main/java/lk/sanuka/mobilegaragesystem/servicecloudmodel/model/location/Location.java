package lk.sanuka.mobilegaragesystem.servicecloudmodel.model.location;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

public class Location {
    
    private BigDecimal longitude;
    private BigDecimal latitude;

    public Location() {
    }

    public Location(BigDecimal longitude, BigDecimal latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }
}
