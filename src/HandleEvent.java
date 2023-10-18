import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class HandleEvent implements ActionListener {
    JTextField id,name,price,quantity;
    JButton add,update,delete,search;

    //INITIAL DATABASE CONNECTIONS CUSTOMIZATIONS
    public static Connection con;
    public static PreparedStatement statement;

    public HandleEvent(JTextField id,JTextField name,JTextField price,JTextField quantity,JButton add,JButton update,JButton delete,JButton search){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.add = add;
        this.update = update;
        this.delete = delete;
        this.search = search;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == add){
            //EVENT_CODE_FOR_ADD_BUTTON
            connect();//Connects the database
            String productID = id.getText();
            String productName = name.getText();
            String productPrice = price.getText();
            String productQuantity = quantity.getText();

            try{
                statement = con.prepareStatement("INSERT INTO products(productID,productName,productPrice,productQty)values(?,?,?,?)");
                int proID = Integer.parseInt(productID);
                statement.setInt(1,proID);
                statement.setString(2,productName);
                int proPrice = Integer.parseInt(productPrice);
                statement.setInt(3,proPrice);
                int proQuantity = Integer.parseInt(productQuantity);
                statement.setInt(4,proQuantity);
                statement.executeUpdate();

                JOptionPane.showMessageDialog(null,"Successfully Added","Record Added",JOptionPane.INFORMATION_MESSAGE);

                id.setText("");
                name.setText("");
                price.setText(" ");
                quantity.setText(" ");

                con.close();

            }catch (SQLException ex){
                ex.printStackTrace();

            }

        }

        if(e.getSource() == update){
            //EVENT_CODE_FOR_UPDATE_BUTTON

        }

        if(e.getSource() == delete){
            //EVENT_CODE_FOR_DELETE_BUTTON

        }

        if(e.getSource() == search){
            //EVENT_CODE_FOR_SEARCH_BUTTON

        }
    }

    public void connect(){
        String URL = "jdbc:mysql://localhost:3306/ProductData";
        String username = "root";
        String password = "[/Ados*$2";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL,username,password);
            System.out.println("Connected to Database...");

        }catch (SQLException e){
            e.printStackTrace();

        }catch (ClassNotFoundException e){
            e.printStackTrace();

        }
    }

}
