package tellmeemergency.demo.servlet;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tellmeemergency.demo.model.Event;

public class AddEvent extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String target = "/Notify.jsp";
        String code = null;
        String alert = null;
        String message = null;
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("user_id") != null && session.getAttribute("isLoged").equals("yes")) {
                try{
                String name = request.getParameter("name");
                String desc = request.getParameter("desc");
                String place = request.getParameter("place");
                int id = Integer.parseInt((String) session.getAttribute("user_id"));
                Event e = new Event(name, desc, place,id);
                if (e.addEvent()) {
                    code = "success";
                    alert = "Success!";
                    message = "The event is now notified.";
                } else {
                    code = "warning";
                    alert = "Warning!";
                    message = "Cannot notify the event.";
                }
                } catch (Exception ex) {
                    System.out.println("AddEvent.ex: "+ex);
                    
                }
            } else {
                code = "Error";
                alert = "Error!";
                message = "Re-Login Pleased.";
                target = "/Login.jsp";
            }
        } else {
            code = "Error";
            alert = "Error!";
            message = "Re-Login1 Pleased.";
        }
        
        request.setAttribute("code", code);
        request.setAttribute("alert", alert);
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher(target).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}