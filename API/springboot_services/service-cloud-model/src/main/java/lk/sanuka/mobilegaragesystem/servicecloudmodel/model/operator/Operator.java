package lk.sanuka.mobilegaragesystem.servicecloudmodel.model.operator;



import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "operator")
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double longitude;
    private double latitude;
    private boolean isReport;
    private boolean isApproved;
    private float rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public BigDecimal getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(BigDecimal longitude) {
//        this.longitude = longitude;
//    }
//
//    public BigDecimal getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(BigDecimal latitude) {
//        this.latitude = latitude;
//    }


    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isReport() {
        return isReport;
    }

    public void setReport(boolean report) {
        isReport = report;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
