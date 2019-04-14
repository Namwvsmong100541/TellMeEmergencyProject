package tellmeemergency.demo.model;
import java.util.Objects;

public class FirstAid {
    private int firstAidId;
    private String typeOfEmergency;
    private String Description;


    public FirstAid() {
    }

    public FirstAid(int firstAidId, String typeOfEmergency, String Description) {
        this.firstAidId = firstAidId;
        this.typeOfEmergency = typeOfEmergency;
        this.Description = Description;
    }

    public int getFirstAidId() {
        return this.firstAidId;
    }

    public void setFirstAidId(int firstAidId) {
        this.firstAidId = firstAidId;
    }

    public String getTypeOfEmergency() {
        return this.typeOfEmergency;
    }

    public void setTypeOfEmergency(String typeOfEmergency) {
        this.typeOfEmergency = typeOfEmergency;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public FirstAid firstAidId(int firstAidId) {
        this.firstAidId = firstAidId;
        return this;
    }

    public FirstAid typeOfEmergency(String typeOfEmergency) {
        this.typeOfEmergency = typeOfEmergency;
        return this;
    }

    public FirstAid Description(String Description) {
        this.Description = Description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof FirstAid)) {
            return false;
        }
        FirstAid firstAid = (FirstAid) o;
        return firstAidId == firstAid.firstAidId && Objects.equals(typeOfEmergency, firstAid.typeOfEmergency) && Objects.equals(Description, firstAid.Description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstAidId, typeOfEmergency, Description);
    }

    @Override
    public String toString() {
        return "{" +
            " firstAidId='" + getFirstAidId() + "'" +
            ", typeOfEmergency='" + getTypeOfEmergency() + "'" +
            ", Description='" + getDescription() + "'" +
            "}";
    }

}