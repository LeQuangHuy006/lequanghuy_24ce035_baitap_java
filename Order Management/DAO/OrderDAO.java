package DAO;

import MODER.Order;
import MODER.OrderItem;
import UTILS.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public void addOrder(Order order) throws Exception {
        Connection conn = DBConnection.getConnection();
        conn.setAutoCommit(false);

        try {
            String sqlOrder = "INSERT INTO orders(customer_id, order_date) VALUES (?, ?)";
            PreparedStatement psOrder = conn.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
            psOrder.setInt(1, order.getCustomerId());
            psOrder.setString(2, order.getOrderDate().toString());
            psOrder.executeUpdate();

            ResultSet generatedKeys = psOrder.getGeneratedKeys();
            int orderId = -1;
            if (generatedKeys.next()) {
                orderId = generatedKeys.getInt(1);
            }

            for (OrderItem item : order.getItems()) {
                String sqlItem = "INSERT INTO order_items(order_id, product_id, quantity) VALUES (?, ?, ?)";
                PreparedStatement psItem = conn.prepareStatement(sqlItem);
                psItem.setInt(1, orderId);
                psItem.setInt(2, item.getProductId());
                psItem.setInt(3, item.getQuantity());
                psItem.executeUpdate();
            }

            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    public List<String> getOrderHistoryByCustomer(int customerId) throws Exception {
        List<String> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();

        String sql = """
                SELECT o.id AS order_id, o.order_date, p.name, p.price, oi.quantity
                FROM orders o
                JOIN order_items oi ON o.id = oi.order_id
                JOIN products p ON oi.product_id = p.id
                WHERE o.customer_id = ?
                ORDER BY o.order_date DESC
                """;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, customerId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int orderId = rs.getInt("order_id");
            String productName = rs.getString("name");
            double price = rs.getDouble("price");
            int quantity = rs.getInt("quantity");
            double total = price * quantity;

            list.add("Đơn #" + orderId + " | " + productName + " x" + quantity + " = " + total + " đ");
        }

        rs.close(); ps.close(); conn.close();
        return list;
    }

    public double getTotalAmount(int orderId) throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = """
            SELECT SUM(p.price * oi.quantity) as total
            FROM order_items oi
            JOIN products p ON oi.product_id = p.id
            WHERE oi.order_id = ?
        """;

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, orderId);
        ResultSet rs = ps.executeQuery();

        double total = 0;
        if (rs.next()) {
            total = rs.getDouble("total");
        }

        rs.close(); ps.close(); conn.close();
        return total;
    }
}