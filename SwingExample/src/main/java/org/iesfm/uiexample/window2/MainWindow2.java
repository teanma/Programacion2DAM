package org.iesfm.uiexample.window2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow2 extends JFrame {

    private JPanel bookPanel, createBookPanel, modifyBookPanel;

    private JButton createBookButton;

    private JButton modifyBookButton;

    private JLabel existingBooksLabel;

    private TextField isbnTextField, titleTextField, authorTextField, yearTextField;

    @Override
    protected void frameInit() {
        super.frameInit();
        setVisible(true);
        setLocationRelativeTo(null);
        setBounds(0, 0, 500, 450);
        setTitle("Catálogo de biblioteca");
        setLayout(null);
        setLocationRelativeTo(null);
        add(getBookPanel());
        add(getCreateBookButton());
        add(getModifyBookButton());
        add(getExistingBooksLabel());
        repaint();
        revalidate();
    }

    private JPanel getBookPanel() {
        bookPanel = new JPanel();
        bookPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bookPanel.setBounds(60, 50, 370, 250);
        return bookPanel;
    }

    private JButton getCreateBookButton() {
        createBookButton = new JButton("Crear libro");
        createBookButton.setBounds(60, 330, 150, 20);
        createBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                isbnTextField = new TextField(10);
                titleTextField = new TextField(10);
                authorTextField = new TextField(10);
                yearTextField = new TextField(10);

                createBookPanel = new JPanel();

                FlowLayout f = new FlowLayout(FlowLayout.LEFT);

                createBookPanel.setLayout(f);

                createBookPanel.add(new Label("ISBN:"));
                createBookPanel.add(isbnTextField);

                createBookPanel.add(new Label("Título:"));
                createBookPanel.add(titleTextField);

                createBookPanel.add(new Label("Autor:"));
                createBookPanel.add(authorTextField);

                createBookPanel.add(new Label("Año:"));
                createBookPanel.add(yearTextField);

                int reply = JOptionPane.showConfirmDialog(null, createBookPanel, "Crear libro", JOptionPane.OK_CANCEL_OPTION);

                if (reply == JOptionPane.OK_OPTION) {
                    String isbn = isbnTextField.getText();
                    String title = titleTextField.getText();
                    String author = authorTextField.getText();
                    String introYear = yearTextField.getText();
                    int year = Integer.parseInt(introYear);

                    System.out.println("ISBN: " + isbn);
                    System.out.println("Título: " + title);
                    System.out.println("Autor: " + author);
                    System.out.println("Año: " + year);
                } else {
                    JOptionPane.showMessageDialog(null, "Operación cancelada");
                }
            }
        });
        return createBookButton;
    }

    private JButton getModifyBookButton() {
        modifyBookButton = new JButton("Modificar libro");
        modifyBookButton.setBounds(280, 330, 150, 20);
        modifyBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                titleTextField = new TextField(10);
                authorTextField = new TextField(10);
                yearTextField = new TextField(10);

                modifyBookPanel = new JPanel();

                FlowLayout f2 = new FlowLayout(FlowLayout.LEFT);

                modifyBookPanel.setLayout(f2);

                modifyBookPanel.add(new Label("Título:"));
                modifyBookPanel.add(titleTextField);

                modifyBookPanel.add(new Label("Autor:"));
                modifyBookPanel.add(authorTextField);

                modifyBookPanel.add(new Label("Año:"));
                modifyBookPanel.add(yearTextField);

                int reply = JOptionPane.showConfirmDialog(null, modifyBookPanel, "Modificar libro", JOptionPane.OK_CANCEL_OPTION);

                if (reply == JOptionPane.OK_OPTION) {
                    String title = titleTextField.getText();
                    String author = authorTextField.getText();
                    String introYear = yearTextField.getText();
                    int year = Integer.parseInt(introYear);

                    System.out.println("Título: " + title);
                    System.out.println("Autor: " + author);
                    System.out.println("Año: " + year);
                } else {
                    JOptionPane.showMessageDialog(null, "Operación cancelada");
                }
            }
        });
        return modifyBookButton;
    }

    private JLabel getExistingBooksLabel() {
        existingBooksLabel = new JLabel("Libros disponibles");
        existingBooksLabel.setBounds(60, 20, 150, 20);
        return existingBooksLabel;
    }
}
