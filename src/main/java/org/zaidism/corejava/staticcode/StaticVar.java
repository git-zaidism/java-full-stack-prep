package org.zaidism.corejava.staticcode;


// A static field is shared by every instance. Only one copy exists, stored in the class’s memory area.
//When to Use: Tracking global state (e.g., connection pool size).

class UserSession {
    private static int activeSessions = 0;

    public UserSession() {
        activeSessions++;
    }

    public static int getActiveSessions() {
        return activeSessions;
    }

    public void close() {
        activeSessions--;
    }
}

public class StaticVar {
    public static void main(String[] args) {
        // Usage:
        UserSession s1 = new UserSession();
        UserSession s2 = new UserSession();
        System.out.println(UserSession.getActiveSessions()); // 2
        s1.close();
        System.out.println(UserSession.getActiveSessions()); // 1
    }
}


