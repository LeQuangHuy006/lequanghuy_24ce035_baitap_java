package UI;
import DAO.CustomerDAO;
import DAO.OrderDAO;
import MODER.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class OrderHistoryPanel extends JPanel {
    private JComboBox<Customer> customerCombo;
    private DefaultListModel<String> orderListModel;

    public OrderHistoryPanel() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        try {
            customerCombo = new JComboBox<>(new CustomerDAO().getAllCustomers().toArray(new Customer[0]));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tải khách hàng: " + e.getMessage());
            return;
        }

        JButton viewBtn = new JButton("Xem lịch sử");
        viewBtn.addActionListener(this::viewHistory);

        topPanel.add(new JLabel("Chọn KH:"));
        topPanel.add(customerCombo);
        topPanel.add(viewBtn);

        orderListModel = new DefaultListModel<>();
        JList<String> orderList = new JList<>(orderListModel);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(orderList), BorderLayout.CENTER);
    }

    private void viewHistory(ActionEvent e) {
        Customer selected = (Customer) customerCombo.getSelectedItem();
        try {
            List<String> history = new OrderDAO().getOrderHistoryByCustomer(selected.getId());
            orderListModel.clear();
            for (String s : history) orderListModel.addElement(s);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi truy xuất: " + ex.getMessage());
        }
    }
}

