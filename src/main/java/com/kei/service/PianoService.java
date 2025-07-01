package com.kei.service;

import java.sql.SQLException;

public interface PianoService {
    void addPiano() throws SQLException;
    void deletePiano() throws SQLException;
    void updatePiano() throws SQLException;
    void selectAllPianos() throws SQLException;
}
