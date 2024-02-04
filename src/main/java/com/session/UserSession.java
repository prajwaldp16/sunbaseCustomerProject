// UserSession.java
package com.session;

import com.modules.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserSession {
    public static final String USER_SESSION_KEY = "user";

    public static void loginUser(HttpSession session, User user) {
        session.setAttribute(USER_SESSION_KEY, user);
    }

    public static User getLoggedInUser(HttpSession session) {
        return (User) session.getAttribute(USER_SESSION_KEY);
    }

    public static void logoutUser(HttpSession session) {
        session.removeAttribute(USER_SESSION_KEY);
        session.invalidate();
    }

    public static boolean isLoggedIn(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute(USER_SESSION_KEY) != null;
    }
}
