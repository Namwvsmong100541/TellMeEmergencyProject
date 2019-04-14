package tellmeemergency.demo.model;
import java.sql.Time;
public class ReportEvent{
    private String DescriptionEmergency;
    private Time time;
    private map location;

    public reportEvent() {
    }

    public reportEvent(String DescriptionEmergency, Time time, map location) {
        this.DescriptionEmergency = DescriptionEmergency;
        this.time = time;
        this.location = location;
    }

    public String getDescriptionEmergency() {
        return this.DescriptionEmergency;
    }

    public void setDescriptionEmergency(String DescriptionEmergency) {
        this.DescriptionEmergency = DescriptionEmergency;
    }

    public Time getTime() {
        return this.time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public map getLocation() {
        return this.location;
    }

    public void setLocation(map location) {
        this.location = location;
    }

    public reportEvent DescriptionEmergency(String DescriptionEmergency) {
        this.DescriptionEmergency = DescriptionEmergency;
        return this;
    }

    public reportEvent time(Time time) {
        this.time = time;
        return this;
    }

    public reportEvent location(map location) {
        this.location = location;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof reportEvent)) {
            return false;
        }
        reportEvent reportEvent = (reportEvent) o;
        return Objects.equals(DescriptionEmergency, reportEvent.DescriptionEmergency) && Objects.equals(time, reportEvent.time) && Objects.equals(location, reportEvent.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DescriptionEmergency, time, location);
    }

    @Override
    public String toString() {
        return "{" +
            " DescriptionEmergency='" + getDescriptionEmergency() + "'" +
            ", time='" + getTime() + "'" +
            ", location='" + getLocation() + "'" +
            "}";
    }

}