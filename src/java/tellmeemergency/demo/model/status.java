package tellmeemergency.demo.model;

import java.util.Objects;

public class Status {
    private int statusID;
    private String statusWord;

    public Status() {
    }

    public Status(int statusID, String statusWord) {
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

    public Status statusID(int statusID) {
        this.statusID = statusID;
        return this;
    }

    public Status statusWord(String statusWord) {
        this.statusWord = statusWord;
        return this;
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



