package tellmeemergency.demo.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User{

    private int id;
    private String name;
    private String surname;
    private long stdId;
    private String gender;
    private String faculty;
    private String email;
    private String username;
    private String password;
    private int position;


    public User() {
    }

    public User(int id, String name, String surname, long stdId, String gender, String faculty, String email, String username, String password, int position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.stdId = stdId;
        this.gender = gender;
        this.faculty = faculty;
        this.email = email;
        this.username = username;
        this.password = password;
        this.position = position;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getStdId() {
        return this.stdId;
    }

    public void setStdId(long stdId) {
        this.stdId = stdId;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public User id(int id) {
        this.id = id;
        return this;
    }

    public User name(String name) {
        this.name = name;
        return this;
    }

    public User surname(String surname) {
        this.surname = surname;
        return this;
    }

    public User stdId(long stdId) {
        this.stdId = stdId;
        return this;
    }

    public User gender(String gender) {
        this.gender = gender;
        return this;
    }

    public User faculty(String faculty) {
        this.faculty = faculty;
        return this;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public User position(int position) {
        this.position = position;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && stdId == user.stdId && Objects.equals(gender, user.gender) && Objects.equals(faculty, user.faculty) && Objects.equals(email, user.email) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && position == user.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, stdId, gender, faculty, email, username, password, position);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", stdId='" + getStdId() + "'" +
            ", gender='" + getGender() + "'" +
            ", faculty='" + getFaculty() + "'" +
            ", email='" + getEmail() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", position='" + getPosition() + "'" +
            "}";
    }
    public boolean addUser() {
        try {
            Connection conn = ConnectionBuilder.getConnection();
           // String sqlCmd = "INSERT INTO member(member_name, member_surname, member_stdId, member_gender, member_faculty, member_email,"
           //         + " member_username, member_password, member_position) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            pstm.setString(1, name);
            pstm.setString(2, surname);
            pstm.setLong(3, stdId);
            pstm.setString(4, gender);
            pstm.setString(5, faculty);
            pstm.setString(6, email);
            pstm.setString(7, username);
            pstm.setString(8, password);
            pstm.setInt(9, position);
            int result = pstm.executeUpdate();
            if (result != 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return false;
    }


    public static User getUser(int user_id) {
        User u = null;
        try {
            Connection conn = ConnectionBuilder.getConnection();
            Statement stmt = conn.createStatement();
          //  String sqlCmd = "SELECT * FROM member WHERE member_id = " + member_id;
            ResultSet rs = stmt.executeQuery(sqlCmd);
            while (rs.next()) {
                u = new Member();
                ORM(u, rs);
            }
        } catch (SQLException ex) {
         //   Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }
    public static int getIdByUsername(String username) throws SQLException {
     //   String sqlCmd = "SELECT `member_id` FROM `member` WHERE member_username = '" + username + "'";
        Connection conn = ConnectionBuilder.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlCmd);
        int id = 0;
        if(rs.next()){
            id = rs.getInt("member_id");
        }
        return id;
    }
    
    public static int getPositionByUsername(String username) throws SQLException {
       // String sqlCmd = "SELECT `member_position` FROM `member` WHERE member_username = '" + username + "'";
        Connection conn = ConnectionBuilder.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlCmd);
        int id = 0;
        if(rs.next()){
            id = rs.getInt("user_position");
        }
        return id;
    }

    public static boolean isUser(String user_username, String user_password) {
        try {
            Connection conn = ConnectionBuilder.getConnection();
         //   String sqlCmd = "SELECT * FROM member WHERE member_username = '" + member_username + "' AND member_password = '"
         //           + member_password + "'";
            PreparedStatement ps = conn.prepareStatement(sqlCmd);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", stdId=" + stdId + ", gender=" + gender + ", faculty=" + faculty + ", email=" + email + ", username=" + username + ", password=" + password + ", position=" + position + '}';
    }
}
