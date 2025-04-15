package UI;
import DAO.CustomerDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import MODER.Customer;
import MODER.Order;
import MODER.OrderItem;
import MODER.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AddOrderPanel extends JPanel {
    private JComboBox<Customer> customerCombo;
    private JComboBox<Product> productCombo;
    private JTextField quantityField;
    private DefaultListModel<String> itemListModel;
    private List<OrderItem> items = new ArrayList<>();

    public AddOrderPanel() {
        setLayout(new BorderLayout());

        // Top panel
        JPanel topPanel = new JPanel();
        try {
            customerCombo = new JComboBox<>(new CustomerDAO().getAllCustomers().toArray(new Customer[0]));
            productCombo = new JComboBox<>(new ProductDAO().getAllProducts().toArray(new Product[0]));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải dữ liệu: " + e.getMessage());
            return;
        }
        quantityField = new JTextField(5);
        JButton addItemBtn = new JButton("Thêm SP");

        addItemBtn.addActionListener(_ -> addItem());

        topPanel.add(new JLabel("Khách hàng:"));
        topPanel.add(customerCombo);
        topPanel.add(new JLabel("Sản phẩm:"));
        topPanel.add(productCombo);
        topPanel.add(new JLabel("SL:"));
        topPanel.add(quantityField);
        topPanel.add(addItemBtn);

        // Center panel - hiển thị danh sách sản phẩm đã chọn
        itemListModel = new DefaultListModel<>();
        JList<String> itemList = new JList<>(itemListModel);

        // Bottom panel - nút lưu
        JButton saveBtn = new JButton("Lưu đơn hàng");
        saveBtn.addActionListener(this::saveOrder);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(itemList), BorderLayout.CENTER);
        add(saveBtn, BorderLayout.SOUTH);
    }

    private void addItem() {
        Product selectedProduct = (Product) productCombo.getSelectedItem();
        int quantity;
        try {
            quantity = Integer.parseInt(quantityField.getText());
            if (quantity <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "SL không hợp lệ!");
            return;
        }

        items.add(new OrderItem(selectedProduct.getId(), quantity));
        itemListModel.addElement(selectedProduct.getName() + " x" + quantity);
        quantityField.setText("");
    }

    private void saveOrder(ActionEvent e) {
        if (items.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm!");
            return;
        }

        Customer customer = (Customer) customerCombo.getSelectedItem();
        Order order = new Order(customer.getId(), LocalDateTime.now(), items);

        try {
            new OrderDAO().addOrder(order);
            JOptionPane.showMessageDialog(this, "Đã lưu đơn hàng!");
            itemListModel.clear();
            items.clear();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi lưu đơn hàng: " + ex.getMessage());
        }
    }
}