package lk.sanuka.mobilegaragesystem.servicecloudmodel.model.task;

public class Task {
    public Task() {
    }

    public Task(int driver_id, int vehicle_id, int operator_id, int location, String reason, boolean is_done, String[] images) {
        this.driver_id = driver_id;
        this.vehicle_id = vehicle_id;
        this.operator_id = operator_id;
        this.location = location;
        this.reason = reason;
        this.is_done = is_done;
        this.images = images;
    }

    private int driver_id;

    private int vehicle_id;

    private int operator_id;

    private int location;

    private String reason;

    private boolean is_done;

    private String[] images;

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(int operator_id) {
        this.operator_id = operator_id;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isIs_done() {
        return is_done;
    }

    public void setIs_done(boolean is_done) {
        this.is_done = is_done;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
