import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class Pantallamostrartodoslosdatos extends JFrame {
    private JTextField nom;
    private JButton button1;
    private JPanel pantalladatos;
    private JButton button2;

    public Pantallamostrartodoslosdatos() {
        super("pantalla de datos");
        setContentPane(pantalladatos);
        Pantalla_login pa = new Pantalla_login();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    mostrardatos();
                }catch (SQLException ex){
                    System.out.println(ex.getMessage());
                }


            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu_de_administrador menu=new Menu_de_administrador();
                pa.ingresar();




            }
        });
    }

    public void mostrardatos()throws SQLException {
        Connection connection = conectar();
        String sql="select * from estudiantes";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet RS = pstmt.executeQuery();


        while(RS.next()){
            String Edad = RS.getString("edad");
            String nombre = RS.getString("nombre_apellido");
            String id = RS.getString("codigo_matricula");
            String direccion = RS.getString("direccion");
            String edad = RS.getString("edad");
            String telefono = RS.getString("telefono");
            String correo = RS.getString("correo");
            String nota1 = RS.getString("nota1");
            String nota2 = RS.getString("nota2");
            JOptionPane.showMessageDialog(null, "ID: "+ id+"\n"+"nombre: "+nombre+"\n"+ "direccion: "+direccion+"\n"+ "Edad: "+edad+"\n"+"Telefono: "+ telefono+"\n"+ "Correo: "+correo+"\n"+ "Nota1: "+nota1+"\n"+ "Nota2: "+nota2);
        }
        RS.close();
        pstmt.close();
        connection.close();






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


}
