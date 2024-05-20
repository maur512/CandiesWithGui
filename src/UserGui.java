import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class UserGui {

    private JPanel MainPanel;
    private JButton exit_button;
    private JTable table1;
    private JButton sortButton;
    DefaultTableModel tableModel;

    public UserGui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640,480);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(MainPanel);
        frame.setVisible(true);
        showCandies();
        exit_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Auth auth = new Auth();
                frame.dispose();
            }
        });
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            SortCandyDialog a = new SortCandyDialog();
            a.setVisible(true);
            showCandies();
            }
        });
    }

    private void showCandies() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Weight");
        tableModel.addColumn("Shugar");
        for(Candy i : Main.present)
        {
            Vector<Object> a = new Vector<Object>();
            a.add(i.getName());
            a.add(i.getWeight());
            a.add(i.getShugar());
            tableModel.addRow(a);

        }
        table1.setModel(tableModel);
    }
}
