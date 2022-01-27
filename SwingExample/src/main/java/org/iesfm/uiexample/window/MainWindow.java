package org.iesfm.uiexample.window;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private JPanel buttonPanel;
    private JPanel inputPanel;

    private JButton registerButton;

    private JPanel mainPanel;

    private JTextField nameField;

    @Override
    protected void frameInit() {
        super.frameInit();
        setVisible(true);
        setLocationRelativeTo(null);
        setBounds(0, 0, 500, 500);
        setTitle("Mi ventana");
        setLayout(new BorderLayout());
        add(getMainPanel());
        repaint();
        revalidate();
    }

    private JPanel getMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainPanel.setLayout((new BorderLayout()));
        mainPanel.add(getInputPanel(), BorderLayout.CENTER);
        mainPanel.add(getButtonPanel(), BorderLayout.PAGE_END);
        return mainPanel;
    }

    private JPanel getButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.add(getRegisterButton());
        buttonPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
        return buttonPanel;
    }

    private JButton getRegisterButton() {
        registerButton = new JButton("Registrar");
        return registerButton;
    }

    private JPanel getInputPanel() {
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(new TitledBorder("Datos personales"));
        inputPanel.add(new JLabel("Nombre"));
        inputPanel.add(getNameField());
        inputPanel.add(new JLabel("Apellidos"));
        inputPanel.add(new JLabel("Email"));
        inputPanel.add(new JLabel("Password"));
        return inputPanel;
    }

    private JTextField getNameField() {
        nameField =  new JTextField();
        return nameField;
    }
}
