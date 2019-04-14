package tellmeemergency.demo.model;

import java.util.Objects;

public class LocationDetail {
    private String nameOfLocationDetail;
    private int locationDetailId;
    private int floor;

    public LocationDetail() {
    }

    public LocationDetail(String nameOfLocationDetail, int locationDetailId, int floor) {
        this.nameOfLocationDetail = nameOfLocationDetail;
        this.locationDetailId = locationDetailId;
        this.floor = floor;
    }

    public String getNameOfLocationDetail() {
        return this.nameOfLocationDetail;
    }

    public void setNameOfLocationDetail(String nameOfLocationDetail) {
        this.nameOfLocationDetail = nameOfLocationDetail;
    }

    public int getLocationDetailId() {
        return this.locationDetailId;
    }

    public void setLocationDetailId(int locationDetailId) {
        this.locationDetailId = locationDetailId;
    }

    public int getFloor() {
        return this.floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public LocationDetail nameOfLocationDetail(String nameOfLocationDetail) {
        this.nameOfLocationDetail = nameOfLocationDetail;
        return this;
    }

    public LocationDetail locationDetailId(int locationDetailId) {
        this.locationDetailId = locationDetailId;
        return this;
    }

    public LocationDetail floor(int floor) {
        this.floor = floor;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LocationDetail)) {
            return false;
        }
        LocationDetail locationDetail = (LocationDetail) o;
        return Objects.equals(nameOfLocationDetail, locationDetail.nameOfLocationDetail) && locationDetailId == locationDetail.locationDetailId && floor == locationDetail.floor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfLocationDetail, locationDetailId, floor);
    }

    @Override
    public String toString() {
        return "{" +
            " nameOfLocationDetail='" + getNameOfLocationDetail() + "'" +
            ", locationDetailId='" + getLocationDetailId() + "'" +
            ", floor='" + getFloor() + "'" +
            "}";
    }
    
}