package jswings;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inventory1 extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField searchBar;
    private JTextField addCategoryField, addProductField;

    public Inventory1() {

        setTitle("Inventory Frame");
        setSize(808, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        String[] columnNames = {"Category", "Product","Price", "Stock"};
        Object[][] initialData = {
                {"NOVEL", "Crime and Punishment", 0, 0},
                {"NOVEL", "The Songs of Achilles", 0, 0},
                {"NOVEL", "Dune", 0, 0},
                {"SELF-HELP/PHILOSOPHY", "Ego is the Enemy", 0, 0},
                {"SELF-HELP/PHILOSOPHY", "Meditations", 0, 0},
                {"SELF-HELP/PHILOSOPHY", "The Mountain is You", 0, 0},
                {"HISTORY", "The Diary of a Girl", 0, 0},
                {"HISTORY", "Noli me Tangere", 0, 0},
                {"HISTORY", "The First Voyage", 0, 0}
        };
        tableModel = new DefaultTableModel(initialData, columnNames) {
            
            public boolean isCellEditable(int row, int column) {
                
                return column == 2 || column == 3;
            }

          
            public Class<?> getColumnClass(int columnIndex) {
               
                if (columnIndex == 2) return Double.class;
                if (columnIndex == 3) return Integer.class;
                return super.getColumnClass(columnIndex);
            }
        };
        getContentPane().setLayout(null);

        
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 30, 791, 335);
        getContentPane().add(scrollPane);

        
        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 791, 30);
        topPanel.setLayout(new FlowLayout());
        searchBar = new JTextField(20);
        topPanel.add(new JLabel("Search:"));
        topPanel.add(searchBar);
        getContentPane().add(topPanel);

    
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBounds(0, 364, 791, 80);

        addCategoryField = new JTextField(10);
        addCategoryField.setBounds(65, 6, 128, 20);
        addProductField = new JTextField(10);
        addProductField.setBounds(263, 6, 160, 20);
        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        addButton.setBounds(144, 37, 160, 32);
        JButton removeButton = new JButton("Remove Product");
        removeButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        removeButton.setBounds(344, 37, 170, 32);
        bottomPanel.setLayout(null);

        JLabel label = new JLabel("Category:");
        label.setBounds(5, 9, 91, 14);
        bottomPanel.add(label);
        bottomPanel.add(addCategoryField);
        JLabel label_1 = new JLabel("Product:");
        label_1.setBounds(212, 9, 79, 14);
        bottomPanel.add(label_1);
        bottomPanel.add(addProductField);
        bottomPanel.add(addButton);
        bottomPanel.add(removeButton);

        getContentPane().add(bottomPanel);
        
        JButton addButton_1 = new JButton("Request Re-stock");
        addButton_1.setBounds(609, 37, 160, 32);
        bottomPanel.add(addButton_1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
        
            public void run() {
                new Inventory1().setVisible(true);
            }
        });
    }
}
