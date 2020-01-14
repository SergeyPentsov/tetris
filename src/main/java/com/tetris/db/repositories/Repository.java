package com.tetris.db.repositories;

import com.tetris.db.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;

public interface Repository {

    default Connection getConnection() {
        return ConnectionFactory.getConnection();
    }

}
