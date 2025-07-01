package com.kei.service;

import java.sql.SQLException;

public interface CustomerService {
    void addCustomer() throws SQLException;

    void deleteCustomer() throws SQLException;

    void updateCustomer() throws SQLException;

    void addCustomerPurchase() throws SQLException;

    void queryCustomerPurchase() throws SQLException;

    void deleteCustomerPurchase() throws SQLException;

    void updateCustomerPurchase() throws SQLException;

    void queryAllCustomerPurchase() throws SQLException;
}
