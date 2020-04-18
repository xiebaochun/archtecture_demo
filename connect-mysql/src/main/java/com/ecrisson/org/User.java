package com.ecrisson.org;

import org.springframework.stereotype.Service;

@Service
public class User {

    public String getUser() {
        String result;
        Application.makeJDBCConnection();
        result = Application.getDataFromDB();

        Application.closeConn();

        return result;
    }
}
