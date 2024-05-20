import javax.swing.*;
import java.awt.event.*;

public class addCandyDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField name;
    private JTextField weight;
    private JTextField shugar;
    private JCheckBox SourCheckBox;

    public addCandyDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setSize(640,480);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        if (SourCheckBox.isSelected()) {
            Main.present.add(new SweetCandy(name.getText(),Double.valueOf(weight.getText()),Integer.valueOf(shugar.getText())));
        }else {
            Main.present.add(new SourCandy(name.getText(),Double.valueOf(weight.getText()),Integer.valueOf(shugar.getText())));
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        addCandyDialog dialog = new addCandyDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
