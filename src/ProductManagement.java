import javax.swing.*;
import java.awt.*;

public class ProductManagement {
    public static void main(String[] args){
        JFrame frame = new JFrame("Product Management Application");

        JLabel label = new JLabel("AdoTech Solutions Product Management System");
        label.setBounds(70,10,500,30);
        label.setFont(new Font("Serif",Font.BOLD,20));
        label.setForeground(Color.BLUE);

        //Label and TextField for the productID
        JLabel productID = new JLabel("ProductID:");
        productID.setBounds(30,60,100,30);
        productID.setFont(new Font("Serif",Font.PLAIN,16));
        JTextField productIDField = new JTextField();
        productIDField.setBounds(140,60,100,30);

        //Label and TextField for the product name
        JLabel productName = new JLabel("Product Name:");
        productName.setBounds(30,100,100,30);
        productName.setFont(new Font("Serif",Font.PLAIN,16));
        JTextField productNameField = new JTextField();
        productNameField.setBounds(140,100,210,30);

        //Label and TextField for the product price
        JLabel productPrice = new JLabel("Product Price:");
        productPrice.setBounds(30,140,100,30);
        productPrice.setFont(new Font("Serif",Font.PLAIN,16));
        JTextField productPriceField = new JTextField();
        productPriceField.setBounds(140,140,210,30);

        //Label and TextField for the product quantity
        JLabel productQty = new JLabel("Quantity:");
        productQty.setBounds(30,180,100,30);
        productQty.setFont(new Font("Serif",Font.PLAIN,16));
        JTextField productQtyField = new JTextField();
        productQtyField.setBounds(140,180,210,30);

        //Add Button customizations
        JButton addButton = new JButton("Add");
        addButton.setBounds(90,230,100,30);
        addButton.setBackground(Color.BLUE);
        addButton.setForeground(Color.WHITE);

        //Update Button customizations
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(210,230,100,30);
        updateButton.setBackground(Color.BLUE);
        updateButton.setForeground(Color.WHITE);

        //Delete Button customizations
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(90,270,100,30);
        deleteButton.setBackground(Color.BLUE);
        deleteButton.setForeground(Color.WHITE);

        //Search Button customizations
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(210,270,100,30);
        searchButton.setBackground(Color.BLUE);
        searchButton.setForeground(Color.WHITE);

        //Copyright label customization
        JLabel copyright = new JLabel("Copyright @AdoTech Solutions Ltd");
        copyright.setBounds(80,310,300,30);
        copyright.setFont(new Font("Serif",Font.ITALIC,16));
        copyright.setForeground(Color.BLUE);





        frame.setLayout(null);// Set the default layout of the JFrame to null, hence removed the default layout of "BorderLayout"

        //Add components to the JFrame
        frame.add(label);
        frame.add(productID);
        frame.add(productIDField);
        frame.add(productName);
        frame.add(productNameField);
        frame.add(productPrice);
        frame.add(productPriceField);
        frame.add(productQty);
        frame.add(productQtyField);
        frame.add(addButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(searchButton);
        frame.add(copyright);

        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }


}