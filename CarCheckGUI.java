import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarCheckGUI extends JFrame implements ActionListener {
    JTextField txtId;
    JTextField txtOwner;
    JTextField txtModel;
    JTextField txtService;
    JTextField txtDate;
    JTextField txtCost;
    JButton btnLog;
    JButton btnShow;
    JTextArea txtShowAll;

    public CarCheckGUI() {
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lbTitle = new JLabel("Car Maintenance Manager");
        lbTitle.setBounds(30, 10, 200, 20);
        add(lbTitle);

        JLabel lbId = new JLabel("Car ID:");
        lbId.setBounds(30, 50, 100, 20);
        add(lbId);
        txtId = new JTextField();
        txtId.setBounds(140, 50, 150, 20);
        add(txtId);

        JLabel lbOwner = new JLabel("Owner name:");
        lbOwner.setBounds(30, 80, 100, 20);
        add(lbOwner);
        txtOwner = new JTextField();
        txtOwner.setBounds(140, 80, 150, 20);
        add(txtOwner);

        JLabel lbModel = new JLabel("Car Model:");
        lbModel.setBounds(30, 110, 100, 20);
        add(lbModel);
        txtModel = new JTextField();
        txtModel.setBounds(140, 110, 150, 20);
        add(txtModel);

        JLabel lbService = new JLabel("Service Type:");
        lbService.setBounds(30, 140, 100, 20);
        add(lbService);
        txtService = new JTextField();
        txtService.setBounds(140, 140, 150, 20);
        add(txtService);

        JLabel lbDate = new JLabel("Service Date:");
        lbDate.setBounds(30, 170, 100, 20);
        add(lbDate);
        txtDate = new JTextField();
        txtDate.setBounds(140, 170, 150, 20);
        add(txtDate);

        JLabel lbCost = new JLabel("Cost:");
        lbCost.setBounds(30, 200, 100, 20);
        add(lbCost);
        txtCost = new JTextField();
        txtCost.setBounds(140, 200, 150, 20);
        add(txtCost);

        btnLog = new JButton("Log Service");
        btnLog.setBounds(50, 240, 120, 25);
        add(btnLog);
        btnLog.addActionListener(this);

        btnShow = new JButton("Show All Logs");
        btnShow.setBounds(180, 240, 130, 25);
        add(btnShow);
        btnShow.addActionListener(this);

        txtShowAll = new JTextArea();
        txtShowAll.setText("Output");

        JScrollPane scroll = new JScrollPane(txtShowAll);
        scroll.setBounds(320, 40, 350, 370);
        add(scroll);
        // Display records on load
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLog) {
            logService();
        } else if (e.getSource() == btnShow) {
            showAllLogs();
        }
    }

    private void clearFields() {
        txtId.setText("");
        txtOwner.setText("");
        txtModel.setText("");
        txtService.setText("");
        txtDate.setText("");
        txtCost.setText("");
    }

    private void showAllLogs() {
        CarCheckManager manager = new CarCheckManager();
        MaintenanceRecord[] records = manager.getAllRecords();
        String output = "";
        for (int i = 0; i < records.length; i++) {
            if (records[i] != null) {
                output += records[i].showInfoGUI();
            }
        }
        txtShowAll.setText(output);
    }

    private void logService() {
        String id = txtId.getText();
        String owner = txtOwner.getText();
        String model = txtModel.getText();
        String service = txtService.getText();
        String date = txtDate.getText();
        String cost = txtCost.getText();

        MaintenanceRecord record = new MaintenanceRecord(id, owner, model, service, date, cost);
        CarCheckManager manager = new CarCheckManager();
        manager.writeRecord(record);

        JOptionPane.showMessageDialog(null, "Service Logged!");
        clearFields();
        showAllLogs();
    }
}