package com.kei.dao;

import com.kei.jdbcUtils.JDBCUtils;
import com.kei.pojo.Piano;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PianoDao {

    public void addPiano(Piano piano) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into piano(name, type, price, manufacturer) values(?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, piano.getName());
        preparedStatement.setString(2, piano.getType());
        preparedStatement.setBigDecimal(3, piano.getPrice());
        preparedStatement.setString(4, piano.getManufacturer());

        int result = preparedStatement.executeUpdate();
        System.out.println(result > 0 ? "添加成功！" : "添加失败！");

        preparedStatement.close();
        connection.close();
    }

    public void deletePiano(int id) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from piano where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int result = preparedStatement.executeUpdate();
        System.out.println(result > 0 ? "删除成功！" : "删除失败或ID不存在！");

        preparedStatement.close();
        connection.close();
    }

    public void updatePiano(Piano piano) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "update piano set name = ?, type = ?, price = ?, manufacturer = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, piano.getName());
        preparedStatement.setString(2, piano.getType());
        preparedStatement.setBigDecimal(3, piano.getPrice());
        preparedStatement.setString(4, piano.getManufacturer());
        preparedStatement.setInt(5, piano.getId());

        int result = preparedStatement.executeUpdate();
        System.out.println(result > 0 ? "更新成功！" : "更新失败或ID不存在！");

        preparedStatement.close();
        connection.close();
    }

    public void selectAllPianos() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from piano";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        boolean found = false;
        while (resultSet.next()) {
            found = true;
            Piano piano = new Piano(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("type"),
                    resultSet.getBigDecimal("price"),
                    resultSet.getString("manufacturer")
            );
            System.out.println(piano);
        }

        if (!found) {
            System.out.println("库存中没有任何琴的信息。");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}