package java.tellmeemergency.demo.model;
public class transfercase {
    private int transfercaseId;
    private String timeAlert;

    public transfercase() {
    }

    public transfercase(int transfercaseId, String timeAlert) {
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

    public transfercase transfercaseId(int transfercaseId) {
        this.transfercaseId = transfercaseId;
        return this;
    }

    public transfercase timeAlert(String timeAlert) {
        this.timeAlert = timeAlert;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof transfercase)) {
            return false;
        }
        transfercase transfercase = (transfercase) o;
        return transfercaseId == transfercase.transfercaseId && Objects.equals(timeAlert, transfercase.timeAlert);
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