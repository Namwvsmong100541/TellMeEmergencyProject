package tellmeemergency.demo.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Event {

    private int id;
    private String name;
    private String desc;
    private String place;
    private int status;
    private int userId;

    public Event() {
    }
    public Event(String name, String desc, String place) {
        this.id = 0;
        this.name = name;
        this.desc = desc;
        this.place = place;
        this.status = 0;
    }

    public Event(String name, String desc, String place, int userId) throws SQLException {
        this.name = name;
        this.desc = desc;
        this.place = place;
        this.status = 0;
        this.userId = userId;
    }

    public Event(int id, String name, String desc, String place, int status, int userId) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.place = place;
        this.status = status;
        this.userId = userId;
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

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPlace() {
        return this.place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Event id(int id) {
        this.id = id;
        return this;
    }

    public Event name(String name) {
        this.name = name;
        return this;
    }

    public Event desc(String desc) {
        this.desc = desc;
        return this;
    }

    public Event place(String place) {
        this.place = place;
        return this;
    }

    public Event status(int status) {
        this.status = status;
        return this;
    }

    public Event userId(int userId) {
        this.userId = userId;
        return this;
    }
    public static Event getEventById(int id) {
        Event e = null;
        try {
            Connection con = ConnectionBuilder.getConnection();
         //   String sqlCmd = "SELECT * FROM event WHERE event_id = ?";
            PreparedStatement pstm = con.prepareStatement(sqlCmd);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                e = new Event();
                ORM(t, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    private static void ORM(Event e, ResultSet rs) {
        try {
            t.setId(rs.getInt("event_id"));
            t.setName(rs.getString("event_name"));
            t.setDesc(rs.getString("event_desc"));
            t.setPlace(rs.getString("event_place"));
            t.setStatus(rs.getInt("event_status"));
            t.setUserId(rs.getInt("event_user"));
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static List<Ticket> getAllEvents() {
        Event e = null;
        Event<Event> events = null;
        try {
            Connection conn = ConnectionBuilder.getConnection();
            Statement stmt = conn.createStatement();
          //  String sqlCmd = "SELECT * FROM event";
            ResultSet rs = stmt.executeQuery(sqlCmd);
            while (rs.next()) {
                e = new Event();
                ORM(e, rs);
                if (events == null) {
                    events = new ArrayList<Ticket>();
                }
                events.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }
    public static Event<Event> getMyEvents(int userId) {
        Event e = null;
        Event<Event> events = null;
        try {
            Connection conn = ConnectionBuilder.getConnection();
            Statement stmt = conn.createStatement();
         //   String sqlCmd = "SELECT * FROM `event` WHERE event_user = "+userId;
            ResultSet rs = stmt.executeQuery(sqlCmd);
            while (rs.next()) {
                e = new Event();
                ORM(e, rs);
                if (events == null) {
                    events = new ArrayList<Ticket>();
                }
                events.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        return events;
    }
    public boolean addEvent() {
        if (name.length() > 0 && desc.length() > 0 && place.length() > 0) {
            try {
                Connection conn = ConnectionBuilder.getConnection();
            //    String sqlCmd = "INSERT INTO event(event_name, event_desc, event_place,event_status,event_user) VALUES(?,?,?,0,?)";
                PreparedStatement pstm = conn.prepareStatement(sqlCmd);
                pstm.setString(1, name);
                pstm.setString(2, desc);
                pstm.setString(3, place);
                pstm.setInt(4, userId);
                int result = pstm.executeUpdate();
                if (result != 0) {
                    return true;
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return false;
    }
    public static boolean update(int event_id, int event_status) {
        try {
            Connection conn = ConnectionBuilder.getConnection();
         //   String sqlCmd = "UPDATE event SET event_status = " + event_status + " WHERE event_id = " + event_id;
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            int result = pstm.executeUpdate();
            if (result != 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return false;
    }

    public static Event getEvent(int event_id) {
        Event e = null;
        try {
            Connection conn = ConnectionBuilder.getConnection();
            Statement stmt = conn.createStatement();
        //    String sqlCmd = "SELECT * FROM event WHERE event_id = " + event_id;
            ResultSet rs = stmt.executeQuery(sqlCmd);
            while (rs.next()) {
                e = new Event();
                ORM(e, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Event.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    public static boolean delete(int event_id) {
        try {
            Connection conn = ConnectionBuilder.getConnection();
         //   String sqlCmd = "DELETE FROM event WHERE event_id = " + event_id;
            PreparedStatement pstm = conn.prepareStatement(sqlCmd);
            int result = pstm.executeUpdate();
            if (result != 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return false;

    }

    public String getStatusName() {
        if (status == 0) {
            return "Received";
        } else if (status == 1) {
            return "On going";
        } else if (status == 2) {
            return "Finished";
        }
        return "";
    }
}
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", desc='" + getDesc() + "'" +
            ", place='" + getPlace() + "'" +
            ", status='" + getStatus() + "'" +
            ", userId='" + getUserId() + "'" +
            "}";
    }
    
}