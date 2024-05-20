import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

public class AdminGui {
    private JPanel MainPanel;
    private JButton exit_button;
    private JTable table1;
    private JButton addButton;
    private JButton deleteButton;
    private JLabel stonesLabel;
    DefaultTableModel tableModel;

    public AdminGui() {

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
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCandy();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCandy();

            }
        });

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                Main.saveSer();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

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
    private void addCandy() {
        addCandyDialog a = new addCandyDialog();
        a.setVisible(true);

        showCandies();
    }
    private void deleteCandy() {
        DeleteCandyDialog a = new DeleteCandyDialog();
        a.setVisible(true);
        showCandies();

    }


}
