package com.kei.dao;

import com.kei.jdbcUtils.JDBCUtils;
import com.kei.pojo.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {
    public void addCustomer(Customer customer) throws SQLException
    {
        Connection connection = JDBCUtils.getConnection();

        String sql = "insert into customer(name,phone,address) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getPhone());
        preparedStatement.setString(3, customer.getAddress());

        // 执行SQL，获取结果集
        int result = preparedStatement.executeUpdate();
        System.out.println(result > 0 ? "添加成功！" : "添加失败！");
        preparedStatement.close();
        connection.close();
    }

    public void deleteCustomer(int id) throws SQLException{
        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from customer where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int result = preparedStatement.executeUpdate();
        System.out.println(result > 0 ? "删除成功！" : "删除失败！");

        preparedStatement.close();
        connection.close();
    }

    public void updateCustomerName(int id, String name) throws SQLException {
        // 1.获取连接
        Connection connection = JDBCUtils.getConnection();
        // 2.获取SQL执行语句
        String sql = "update customer set name = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, id);
        // 3. 执行语句
        int result = preparedStatement.executeUpdate();
        // 4. 结果处理
        System.out.println(result > 0 ? "更新成功" : "更新失败");
        // 5. 释放资源
        preparedStatement.close();
        connection.close();
    }

    public void updateCustomerPhone(int id, String phone) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        String sql = "update customer set phone = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, phone);
        preparedStatement.setInt(2, id);

        int result = preparedStatement.executeUpdate();
        System.out.println(result > 0 ? "更新成功" : "更新失败");

        preparedStatement.close();
        connection.close();
    }

    public void updateCustomerAddress(int id, String address) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "update customer set address = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, address);
        preparedStatement.setInt(2, id);
        int result = preparedStatement.executeUpdate();
        System.out.println(result > 0 ? "更新成功" : "更新失败");

        preparedStatement.close();
        connection.close();
    }

    public void queryAllCustomerPurchase () throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "SELECT customer.id AS customer_id, customer.name, customer.phone, customer.address, purchase.id AS purchase_id, purchase.purchase_date, purchase.price, purchase.seller_name " +
                "FROM customer LEFT JOIN purchase ON customer.id = purchase.customer_id";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int customerId = resultSet.getInt("customer_id");
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            String address = resultSet.getString("address");

            // 获取 purchase 字段
            Integer purchaseId = resultSet.getObject("purchase_id", Integer.class);
            String date = resultSet.getObject("purchase_date", String.class);
            Integer price = resultSet.getObject("price", Integer.class);
            String sellerName = resultSet.getObject("seller_name", String.class);

            // 如果 purchase_id 为 null，表示没有购买记录
            System.out.printf("%d %s %s %s | %s %s %s%n",
                    customerId, name, phone, address,
                    (date == null ? "无" : date),
                    (price == null ? "无" : String.valueOf(price)), // 如果 price 是 Integer 或 int 都适用
                    (sellerName == null ? "无" : sellerName));

        }
        System.out.println( "\n");
        preparedStatement.close();
        connection.close();
    }
}
