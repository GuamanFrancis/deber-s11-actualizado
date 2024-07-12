import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Datospersonalizados extends JFrame{
    private JTextField nombreabuscar;
    private JButton buscarButton;
    private JPanel pantalladatosper;
    private JButton regresarButton;
    private JLabel mostrar_datos;

    public Datospersonalizados()  {
        super("Pantalla de datos personalizados");
        setContentPane(pantalladatosper);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    mostrardatos();
                }catch (SQLException ex){
                    System.out.println(ex.getMessage());


                }


            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu_de_administrador menu = new Menu_de_administrador();
                menu.ingresar();
                dispose();
            }
        });
    }
    public void ingresar(){
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
    public Connection conectar()throws SQLException{
        String url = "jdbc:mysql://localhost:3306/curso";
        String user ="root";
        String password = "12345";

        return DriverManager.getConnection(url,user,password);
    }
    public void mostrardatos()throws SQLException {
        String nombre =nombreabuscar.getText();
        //connection puede variar para las diferentes funciones
        Connection connection = conectar();
        String sql="select * from estudiantes where nombre_apellido=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,nombre);
        ResultSet RS = pstmt.executeQuery();

        StringBuilder datos = new StringBuilder("<html>");
        if (RS.next()) {
            datos.append("<b>Nombre:</b> ").append(RS.getString("nombre_apellido")).append("<br>");
            datos.append("<b>Direccion:</b> ").append(RS.getString("direccion")).append("<br>");
            datos.append("<b>edad:</b> ").append(RS.getString("edad")).append("<br><br>");
            datos.append("<b>Nombre:</b> ").append(RS.getString("nombre_apellido")).append("<br>");
            datos.append("<b>Direccion:</b> ").append(RS.getString("direccion")).append("<br>");
            datos.append("<b>edad:</b> ").append(RS.getString("edad")).append("<br><br>");
        } else {
            datos.append("No se encontraron resultados para el correo ingresado.");
        }

        datos.append("</html>");
        mostrar_datos.setText(datos.toString());
        /*
        if (RS.next()){
            String Edad = RS.getString("edad");
            String id = RS.getString("codigo_matricula");
            String direccion = RS.getString("direccion");
            String edad = RS.getString("edad");
            String telefono = RS.getString("telefono");
            String correo = RS.getString("correo");
            String nota1 = RS.getString("nota1");
            String nota2 = RS.getString("nota2");

            JOptionPane.showMessageDialog(null, "ID: "+ id+"\n"+"nombre: "+nombre+"\n"+ "direccion: "+direccion+"\n"+ "Edad: "+edad+"\n"+"Telefono: "+ telefono+"\n"+ "Correo: "+correo+"\n"+ "Nota1: "+nota1+"\n"+ "Nota2: "+nota2);

        }else{
            JOptionPane.showMessageDialog(null,"No se encontraron datos para ese nombre");
        }

        */
        RS.close();
        pstmt.close();
        connection.close();






    }

}
