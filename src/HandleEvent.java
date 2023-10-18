import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class HandleEvent implements ActionListener {

    //Declaration of variables( instance of JTextField, and JButton)
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
            connect();//This connect()  method connects the database
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
            connect();//This connect()  method connects the database
            String productID = id.getText();
            String productName = name.getText();
            String productPrice = price.getText();
            String productQuantity = quantity.getText();


            try{
                statement = con.prepareStatement("UPDATE products SET productID=?, productName = ?,productPrice = ?,productQty = ? WHERE productID = ?");
                int proID = Integer.parseInt(productID);
                statement.setInt(1,proID);
                statement.setString(2,productName);
                int proPrice = Integer.parseInt(productPrice);
                statement.setInt(3,proPrice);
                int proQuantity = Integer.parseInt(productQuantity);
                statement.setInt(4,proQuantity);
                statement.setInt(5,proID);
                statement.executeUpdate();

                JOptionPane.showMessageDialog(null,"Successfully Updated","Record Updated",JOptionPane.INFORMATION_MESSAGE);

                id.setText("");
                name.setText("");
                price.setText(" ");
                quantity.setText(" ");

                con.close();

            }catch(SQLException ex){
                ex.printStackTrace();
            }



        }

        if(e.getSource() == delete){
            //EVENT_CODE_FOR_DELETE_BUTTON
            connect();
            String productID = id.getText();

            try {
                statement = con.prepareStatement("DELETE FROM products WHERE productID=?");
                int proID = Integer.parseInt(productID);
                statement.setInt(1,proID);
                statement.executeUpdate();

                JOptionPane.showMessageDialog(null,"Successfully Deleted","Record Deleted",JOptionPane.INFORMATION_MESSAGE);

                id.setText(" ");
                name.setText("");
                price.setText("");
                quantity.setText("");

                con.close();

            }catch (SQLException ex){
                ex.printStackTrace();
            }


        }

        if(e.getSource() == search){
            //EVENT_CODE_FOR_SEARCH_BUTTON
            connect();
            String productID = id.getText();
            try {
                statement = con.prepareStatement("SELECT productName,productPrice,productQty FROM products WHERE productID = ?");
                int proID = Integer.parseInt(productID);
                statement.setInt(1,proID);
                ResultSet rs = statement.executeQuery();

                if(rs.next() == true){
                    String proName = rs.getString(1);
                    String proPrice = rs.getString(2);
                    String proQty = rs.getString(3);

                    name.setText(proName);
                    price.setText(proPrice);
                    quantity.setText(proQty);

                }else{
                    name.setText(" ");
                    price.setText(" ");
                    quantity.setText("");
                    JOptionPane.showMessageDialog(null,"Invalid Product ID","Error",JOptionPane.ERROR_MESSAGE);
                }
                con.close();

            }catch (SQLException ex){
                ex.printStackTrace();

            }

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
