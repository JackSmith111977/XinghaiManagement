package com.kei.dao;

import com.kei.jdbcUtils.JDBCUtils;
import com.kei.pojo.Purchase;
import com.kei.pojo.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


/**
 * 王俊锡
 */

public class PurchaseDao {

    public void addCustomerPurchase(Purchase purchase) throws SQLException
    {
        Connection connection = JDBCUtils.getConnection();
        if(!judgeId(purchase.getCustomerId())){
            return;
        }
        String sql = "INSERT INTO purchase (customer_id, purchase_date, price, seller_name) " +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1, purchase.getCustomerId());

        LocalDate localDate = purchase.getPurchaseDate(); // 你的 LocalDate 对象
        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate); // 转换为 SQL Date
        preparedStatement.setDate(2, sqlDate);

        preparedStatement.setInt(3, purchase.getPrice());
        preparedStatement.setString(4, purchase.getSellerName());

        // 3.执行SQL，获取结果集
        int result = preparedStatement.executeUpdate();
        System.out.println(result > 0 ? "添加成功！" : "添加失败！");

        preparedStatement.close();
        connection.close();
    }

    public void queryCustomerPurchase( int customerId) throws SQLException {

        if(!judgeId(customerId))return;

        Connection connection = JDBCUtils.getConnection();

        String sql = "select p.id,p.purchase_date,p.price,p.seller_name\n" +
                "from customer c join purchase p " +
                "on c.id = p.customer_id " +
                "where c.id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customerId);
        ResultSet resultSet = preparedStatement.executeQuery();

        int count = 0;
        /*if(!resultSet.next()){
            System.out.println("未找到该顾客的购买记录");
            return;
        }*/

        while (resultSet.next()) {
            int id = resultSet.getInt("p.id");
            LocalDate purchaseDate = resultSet.getObject("purchase_date", LocalDate.class);
            int price = resultSet.getInt("price");
            String sellerName = resultSet.getString("seller_name");

            System.out.println(
                    "id：" + id +
                    ", purchase_date: " + purchaseDate +
                    ", price: " + price +
                    ", seller_name: " + sellerName);
            count++;
        }

        if(count == 0){
            System.out.println("未找到该顾客的购买记录");
            return;
        }

        preparedStatement.close();
        connection.close();
    }


    public void deleteCustomerPurchase( int customerId, int purchaseId) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        if(!judgeId(customerId))return;

        String sql = "delete from purchase where customer_id = ? and id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customerId);
        preparedStatement.setInt(2, purchaseId);
        int result = preparedStatement.executeUpdate();

        System.out.println(result > 0 ? "删除成功！" : "删除失败！");
        preparedStatement.close();
        connection.close();

    }

    public void updatePurchaseDate(int customerId, int purchaseId, LocalDate purchaseDate)
            throws SQLException {
            Connection connection = JDBCUtils.getConnection();

            if(!judgeId(customerId))return;

            String sql = "update purchase set purchase_date = ? where customer_id = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(purchaseDate));
            preparedStatement.setInt(2, customerId);
            preparedStatement.setInt(3, purchaseId);
            int result = preparedStatement.executeUpdate();
            System.out.println(result > 0 ? "更新成功！" : "更新失败！");
            preparedStatement.close();
            connection.close();

    }

    public void updatePrice(int customerId, int purchaseId, int price)
            throws SQLException {
            Connection connection = JDBCUtils.getConnection();

            if(!judgeId(customerId))return;

            String sql = "update purchase set price = ? where customer_id = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, price);
            preparedStatement.setInt(2, customerId);
            preparedStatement.setInt(3, purchaseId);
            int result = preparedStatement.executeUpdate();
            System.out.println(result > 0 ? "更新成功！" : "更新失败！");
            preparedStatement.close();
            connection.close();

    }

    public void updateSellerName(int customerId, int purchaseId, String sellerName)
            throws SQLException {
            Connection connection = JDBCUtils.getConnection();

            if(!judgeId(customerId))return;

            String sql = "update purchase set seller_name = ? where customer_id = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sellerName);
            preparedStatement.setInt(2, customerId);
            preparedStatement.setInt(3, purchaseId);
            int result = preparedStatement.executeUpdate();
            System.out.println(result > 0 ? "更新成功！" : "更新失败！");
            preparedStatement.close();
            connection.close();

    }

    public boolean judgeId(Integer customerId) throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "select c.id from customer c where c.id = ? ";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, customerId);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            System.out.println("未找到该顾客");
            preparedStatement.close();
            resultSet.close();
            return false;
        }
        preparedStatement.close();
        connection.close();
        return true;
    }
}
