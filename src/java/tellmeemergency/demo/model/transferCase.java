package tellmeemergency.demo.model;
import java.util.Objects;

public class Transfercase {
    public int transfercaseId;
    public String timeAlert;

    public Transfercase() {
    }

    public Transfercase(int transfercaseId, String timeAlert) {
        this.transfercaseId = transfercaseId;
        this.timeAlert = timeAlert;
    }

    public int getTransfercaseId() {
        return this.transfercaseId;
    }

    public void setTransfercaseId(int transfercaseId) {
        this.transfercaseId = transfercaseId;
    }

    public String getTimeAlert() {
        return this.timeAlert;
    }

    public void setTimeAlert(String timeAlert) {
        this.timeAlert = timeAlert;
    }

    public Transfercase transfercaseId(int transfercaseId) {
        this.transfercaseId = transfercaseId;
        return this;
    }

    public Transfercase timeAlert(String timeAlert) {
        this.timeAlert = timeAlert;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transfercaseId, timeAlert);
    }

    @Override
    public String toString() {
        return "{" +
            " transfercaseId='" + getTransfercaseId() + "'" +
            ", timeAlert='" + getTimeAlert() + "'" +
            "}";
    }
    
}