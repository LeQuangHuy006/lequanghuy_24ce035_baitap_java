package GUI.library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class QuanLyThuVien extends JFrame {
    private JTextField txtTenSach, txtTacGia, txtNam, txtNXB, txtSoTrang, txtTheLoai, txtGia, txtISBN;
    private DefaultTableModel modelBang;
    private JTable bang;
    private static final String TEN_FILE = "books.xml";

    public QuanLyThuVien() {
        setTitle("Quan Ly Thu Vien");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        String[] tenCot = {"Ten sach", "Tac gia", "Nam", "NXB", "So trang", "The loai", "Gia", "ISBN"};
        modelBang = new DefaultTableModel(tenCot, 0);
        bang = new JTable(modelBang);
        add(new JScrollPane(bang), BorderLayout.CENTER);

        JPanel panelNhap = new JPanel(new GridLayout(8, 2));
        txtTenSach = new JTextField(); txtTacGia = new JTextField(); txtNam = new JTextField();
        txtNXB = new JTextField(); txtSoTrang = new JTextField(); txtTheLoai = new JTextField();
        txtGia = new JTextField(); txtISBN = new JTextField();
        panelNhap.add(new JLabel("Ten sach:")); panelNhap.add(txtTenSach);
        panelNhap.add(new JLabel("Tac gia:")); panelNhap.add(txtTacGia);
        panelNhap.add(new JLabel("Nam:")); panelNhap.add(txtNam);
        panelNhap.add(new JLabel("NXB:")); panelNhap.add(txtNXB);
        panelNhap.add(new JLabel("So trang:")); panelNhap.add(txtSoTrang);
        panelNhap.add(new JLabel("The loai:")); panelNhap.add(txtTheLoai);
        panelNhap.add(new JLabel("Gia:")); panelNhap.add(txtGia);
        panelNhap.add(new JLabel("ISBN:")); panelNhap.add(txtISBN);
        add(panelNhap, BorderLayout.NORTH);

        JPanel panelNut = new JPanel();
        JButton btnThem = new JButton("Them");
        JButton btnXoa = new JButton("Xoa");
        panelNut.add(btnThem);
        panelNut.add(btnXoa);
        add(panelNut, BorderLayout.SOUTH);

        btnThem.addActionListener(e -> {
            themSach();
            docSachTuXML();
        });
        
        btnXoa.addActionListener(e -> {
            xoaSach();
            docSachTuXML();
        });
        
        docSachTuXML();
        setVisible(true);
    }

    private void docSachTuXML() {
        modelBang.setRowCount(0);
        try {
            File file = new File(TEN_FILE);
            if (!file.exists()) return;

            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            NodeList danhSachSach = doc.getElementsByTagName("book");

            for (int i = 0; i < danhSachSach.getLength(); i++) {
                Element sach = (Element) danhSachSach.item(i);
                modelBang.addRow(new Object[]{
                    sach.getElementsByTagName("title").item(0).getTextContent(),
                    sach.getElementsByTagName("author").item(0).getTextContent(),
                    sach.getElementsByTagName("year").item(0).getTextContent(),
                    sach.getElementsByTagName("publisher").item(0).getTextContent(),
                    sach.getElementsByTagName("pages").item(0).getTextContent(),
                    sach.getElementsByTagName("genre").item(0).getTextContent(),
                    sach.getElementsByTagName("price").item(0).getTextContent(),
                    sach.getElementsByTagName("isbn").item(0).getTextContent()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Loi khi doc file XML!", "Loi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void themSach() {
        if (txtTenSach.getText().isEmpty() || txtTacGia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ten sach va tac gia khong duoc de trong!", "Loi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            File file = new File(TEN_FILE);
            Document doc;
            if (file.exists()) {
                doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
            } else {
                doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
                doc.appendChild(doc.createElement("books"));
            }

            Element root = doc.getDocumentElement();
            Element sachMoi = doc.createElement("book");
            sachMoi.appendChild(taoPhanTu(doc, "title", txtTenSach.getText()));
            sachMoi.appendChild(taoPhanTu(doc, "author", txtTacGia.getText()));
            sachMoi.appendChild(taoPhanTu(doc, "year", txtNam.getText()));
            sachMoi.appendChild(taoPhanTu(doc, "publisher", txtNXB.getText()));
            sachMoi.appendChild(taoPhanTu(doc, "pages", txtSoTrang.getText()));
            sachMoi.appendChild(taoPhanTu(doc, "genre", txtTheLoai.getText()));
            sachMoi.appendChild(taoPhanTu(doc, "price", txtGia.getText()));
            sachMoi.appendChild(taoPhanTu(doc, "isbn", txtISBN.getText()));
            root.appendChild(sachMoi);
            luuXML(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void xoaSach() {
        int hangChon = bang.getSelectedRow();
        if (hangChon == -1) {
            JOptionPane.showMessageDialog(this, "Chon sach can xoa!", "Thong bao", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String tenSach = modelBang.getValueAt(hangChon, 0).toString();
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(TEN_FILE));
            NodeList danhSachSach = doc.getElementsByTagName("book");
            for (int i = 0; i < danhSachSach.getLength(); i++) {
                Element sach = (Element) danhSachSach.item(i);
                if (sach.getElementsByTagName("title").item(0).getTextContent().equals(tenSach)) {
                    sach.getParentNode().removeChild(sach);
                    luuXML(doc);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Element taoPhanTu(Document doc, String the, String giaTri) {
        Element e = doc.createElement(the);
        e.appendChild(doc.createTextNode(giaTri));
        return e;
    }

    private void luuXML(Document doc) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(doc), new StreamResult(new File(TEN_FILE)));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuanLyThuVien::new);
    }
}
