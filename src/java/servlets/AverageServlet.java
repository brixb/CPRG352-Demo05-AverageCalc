
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author brixa
 */
public class AverageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Establishes a new session, if one does not already exists
        // Also will retrieve current session, if a session already exists
        HttpSession session = request.getSession();
        
        
        String action = request.getParameter("action");
        // if user has reset average
        if (action != null && action.equals("reset")) {
            // destroy session
            session.invalidate();
            // create a new sesion
            session = request.getSession();
        }
        
        // get the list of numbers from the session
        ArrayList<Integer> numberList = (ArrayList<Integer>)session.getAttribute("numberList");
        // ensure that the number list is a singleton pattern
        if (numberList == null) 
            numberList = new ArrayList<>();
        
        // get the number that the user entered
        // if there is a number, add it to the list
        if (request.getParameter("number") != null) {
            int number = Integer.parseInt(request.getParameter("number"));
            numberList.add(number);
            // store the list back in to the session
            session.setAttribute("numberList", numberList);
        }
        // math time
        // calculate the average
        double average = 0.0;
        for( int number: numberList) {
            average += number;
        }
        if (numberList.size() > 0) {
        average /= numberList.size();
        }
        // store the average in the request
        // the average will need to be recalculated for each request (page view)
        request.setAttribute("average", average);
        
        getServletContext().getRequestDispatcher("/WEB-INF/average.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


}
