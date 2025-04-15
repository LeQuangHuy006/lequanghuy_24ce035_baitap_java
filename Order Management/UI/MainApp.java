package UI;

import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quản lý đơn hàng");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Thêm đơn hàng", new AddOrderPanel());
        tabs.add("Lịch sử đơn hàng", new OrderHistoryPanel());

        frame.add(tabs);
        frame.setVisible(true);
    }
}

