package com.fourth.dao;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// Done By Prashant Singh
// Date 01-Dec-2024

@WebServlet("/LoginServlet")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Constants for user roles
//    private static final String JOB_SEEKER = "jobseeker";
//    private static final String RECRUITER = "recruiter";
 // Constants for user roles
    private static final String JOB_SEEKER = "jobseeker";
    private static final String RECRUITER = "recruiter";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Logging the first step (should replace System.out with a proper logging framework)
        System.out.println("Login Servlet: Processing login");

        // Retrieving parameters from the request
        String email = request.getParameter("uname");
        String pass = request.getParameter("pass");
        String loginAs = request.getParameter("LoginAs");

        // Initializing the DAO class
        LoginDAO check = new LoginDAO();
        HttpSession session = request.getSession();

        try {
            // Verifying login details
            if (check.check(email, pass, loginAs, session)) {
                // Setting session attribute for the user
                session.setAttribute("username", email);

                // Redirecting based on user role
                if (JOB_SEEKER.equals(loginAs)) {
                    response.sendRedirect("welcomeJS.jsp");
                } else if (RECRUITER.equals(loginAs)) {
                    response.sendRedirect("welcomeRE.jsp");
                } else {
//                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                    response.sendRedirect("welcome.jsp");
                }
            } else {
                // If login fails, set error message and forward back to login page
                request.setAttribute("errorMessage", "Invalid username, password, or role");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            // Logging the exception and redirecting to a generic error page
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}

