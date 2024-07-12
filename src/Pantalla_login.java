import javax.swing.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;


public class Pantalla_login extends JFrame{
    private JTextField usua;
    private JTextField contra;
    private JPanel paneldelogin;
    private JButton ingresarButton;

    public Pantalla_login() {
        super("Pantalla de login ");
        setContentPane(paneldelogin);
        setSize(400,500);



        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    verificardatos();
                }catch (SQLException ex){
                    System.out.println(ex.getMessage());
                }
            }
        });
    }


    public Connection conectar()throws SQLException{
        String url = "jdbc:mysql://localhost:3306/curso";
        String user ="root";
        String password = "12345";
        return DriverManager.getConnection(url,user,password);
    }

    public void ingresar(){
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void verificardatos()throws SQLException{

        Connection connection = conectar();
        String user = usua.getText();
        String pass = new String(contra.getText());

        String sql = "SELECT * FROM usuariosadministrador WHERE nombre = ? AND cedula = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, user);
        stmt.setString(2, pass);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Menu_de_administrador menu =new  Menu_de_administrador();
            menu.ingresar();
            dispose();

        } else {

            JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrectos.");
        }
    }
}
