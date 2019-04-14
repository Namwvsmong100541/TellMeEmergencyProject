package tellmeemergency.demo.model;
import java.sql.Time;
import java.util.Map;
import java.util.Objects;

public class ReportEvent{
    private String DescriptionEmergency;
    private Time time;
    private Map location;

    public ReportEvent() {
    }

    public ReportEvent(String DescriptionEmergency, Time time, Map location) {
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

    public Map getLocation() {
        return this.location;
    }

    public void setLocation(Map location) {
        this.location = location;
    }

    public ReportEvent DescriptionEmergency(String DescriptionEmergency) {
        this.DescriptionEmergency = DescriptionEmergency;
        return this;
    }

    public ReportEvent time(Time time) {
        this.time = time;
        return this;
    }

    public ReportEvent location(Map location) {
        this.location = location;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ReportEvent)) {
            return false;
        }
        ReportEvent reportEvent = (ReportEvent) o;
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