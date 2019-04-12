package java.tellmeemergency.demo.model;
public class status {
    private int statusID;
    private String statusWord;

    public status() {
    }

    public status(int statusID, String statusWord) {
        this.statusID = statusID;
        this.statusWord = statusWord;
    }

    public int getStatusID() {
        return this.statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getStatusWord() {
        return this.statusWord;
    }

    public void setStatusWord(String statusWord) {
        this.statusWord = statusWord;
    }

    public status statusID(int statusID) {
        this.statusID = statusID;
        return this;
    }

    public status statusWord(String statusWord) {
        this.statusWord = statusWord;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof status)) {
            return false;
        }
        status status = (status) o;
        return statusID == status.statusID && Objects.equals(statusWord, status.statusWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusID, statusWord);
    }

    @Override
    public String toString() {
        return "{" +
            " statusID='" + getStatusID() + "'" +
            ", statusWord='" + getStatusWord() + "'" +
            "}";
    }
}



