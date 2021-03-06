package org.iesfm.uiexample.window2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainWindow2 extends JFrame {

    private JPanel bookPanel, createBookPanel, modifyBookPanel, askForIsbnPanel;

    private JButton createBookButton;

    private JButton modifyBookButton;

    private JLabel booksLabel;

    private TextField isbnTextField, titleTextField, authorTextField, yearTextField;

    private JList<String> books;

    private DefaultListModel<String> listModel;

    @Override
    protected void frameInit() {
        super.frameInit();
        setVisible(true);
        setLocationRelativeTo(null);
        setBounds(0, 0, 1080, 720);
        setTitle("Catálogo de biblioteca");
        setLayout(null);
        setLocationRelativeTo(null);
        add(getBookPanel());
        add(getCreateBookButton());
        add(getModifyBookButton());
        //add(getExistingBooksLabel());
        repaint();
        revalidate();
    }

    private JPanel getBookPanel() {
        bookPanel = new JPanel();
        bookPanel.setBorder(BorderFactory.createTitledBorder("Libros disponibles"));
        bookPanel.setBounds(10, 10, 1045, 600);
        bookPanel.setLayout(new GridLayout(1, 1));
        listModel = new DefaultListModel<>();
        books = new JList<>(listModel);
        bookPanel.add(books);
        //bookPanel.add(getBooksLabel(), BorderLayout.CENTER);
        return bookPanel;
    }

    private JButton getCreateBookButton() {
        createBookButton = new JButton("Crear libro");
        createBookButton.setBounds(160, 630, 150, 30);
        createBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                isbnTextField = new TextField(25);
                titleTextField = new TextField(25);
                authorTextField = new TextField(25);
                yearTextField = new TextField(25);

                createBookPanel = new JPanel();

                createBookPanel.setLayout(new GridLayout(4, 2));

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

                    /*System.out.println("ISBN: " + isbn);
                    System.out.println("Título: " + title);
                    System.out.println("Autor: " + author);
                    System.out.println("Año: " + year);*/

                    /*listModel.addElement("ISBN: " + isbn);
                    listModel.addElement("Título: " + title);
                    listModel.addElement("Autor: " + author);
                    listModel.addElement("Año: " + year);
                    //listModel.addElement("----------------");*/

                    String book = String.valueOf("ISBN: " + isbn + "\n" + "Título: " + title + "\n" + "Author: " + author + "\n" + "Año: " + year);

                    JOptionPane.showMessageDialog(null, book);

                    /*OptionPane.showMessageDialog(null, "Libro creado");*/
                } else {
                    JOptionPane.showMessageDialog(null, "Operación cancelada");
                }
            }
        });
        return createBookButton;
    }

    private JButton getModifyBookButton() {
        modifyBookButton = new JButton("Modificar libro");
        modifyBookButton.setBounds(770, 630, 150, 30);
        modifyBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                titleTextField = new TextField(25);
                authorTextField = new TextField(25);
                yearTextField = new TextField(25);

                /*askForIsbnPanel = new JPanel();

                askForIsbnPanel.setLayout(new GridLayout(1,2));

                askForIsbnPanel.add(new JLabel("NIF:"));
                askForIsbnPanel.add(isbnTextField);*/

                modifyBookPanel = new JPanel();

                modifyBookPanel.setLayout(new GridLayout(3, 2));

                modifyBookPanel.add(new Label("Título:"));
                modifyBookPanel.add(titleTextField);

                modifyBookPanel.add(new Label("Autor:"));
                modifyBookPanel.add(authorTextField);

                modifyBookPanel.add(new Label("Año:"));
                modifyBookPanel.add(yearTextField);

                /*int askForIsbn = JOptionPane.showConfirmDialog(null, askForIsbnPanel, "Introducir nif", JOptionPane.OK_CANCEL_OPTION);

                if(askForIsbn == JOptionPane.OK_OPTION) {
                    String isbn = isbnTextField.getText();
                } else {
                    JOptionPane.showMessageDialog(null, "Operación cancelada");
                }*/

                int reply = JOptionPane.showConfirmDialog(null, modifyBookPanel, "Modificar libro", JOptionPane.OK_CANCEL_OPTION);

                if (reply == JOptionPane.OK_OPTION) {
                    String title = titleTextField.getText();
                    String author = authorTextField.getText();
                    String introYear = yearTextField.getText();
                    int year = Integer.parseInt(introYear);

                    listModel.addElement("Título: " + title);
                    listModel.addElement("Autor: " + author);
                    listModel.addElement("Año: " + year);

                    JOptionPane.showMessageDialog(null, "Libro modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Operación cancelada");
                }
            }
        });
        return modifyBookButton;
    }
}
