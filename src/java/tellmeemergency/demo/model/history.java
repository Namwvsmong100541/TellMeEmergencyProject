package tellmeemergency.demo.model;
import java.util.Objects;

public class History{
    private int historyId;
    private Event eventId;


    public History() {
    }

    public History(int historyId, Event eventId) {
        this.historyId = historyId;
        this.eventId = eventId;
    }

    public int getHistoryId() {
        return this.historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public Event getEventId() {
        return this.eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

    public History historyId(int historyId) {
        this.historyId = historyId;
        return this;
    }

    public History eventId(Event eventId) {
        this.eventId = eventId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof History)) {
            return false;
        }
        History history = (History) o;
        return historyId == history.historyId && Objects.equals(eventId, history.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historyId, eventId);
    }

    @Override
    public String toString() {
        return "{" +
            " historyId='" + getHistoryId() + "'" +
            ", eventId='" + getEventId() + "'" +
            "}";
    }


}