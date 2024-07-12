import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class pantalladeingreso extends JFrame{
    private JTextField nya;
    private JTextField dir;
    private JTextField edadd;
    private JTextField telf;
    private JTextField corr;
    private JTextField primeranota;
    private JTextField segundanota;
    private JPanel panelingreso;
    private JButton button1;

    public pantalladeingreso() {
        super("Pantalla de registro");
        setContentPane(panelingreso);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ingreso();
                }catch (SQLException ex){
                    System.out.println(ex.getMessage());
                }


            }
        });
    }

    public void ingresar(){
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    public  void ingreso()throws SQLException{
        String nombre_apellido = nya.getText();
        String direccion= dir.getText();
        String edad = edadd.getText();
        String telefono = telf.getText();
        String correo = corr.getText();
        Double nota1= Double.parseDouble(primeranota.getText());
        Double nota2= Double.parseDouble(segundanota.getText());
        Connection connection=conectar();
        String sql = "INSERT INTO estudiantes(nombre_apellido,direccion,edad,telefono,correo,nota1,nota2)values(?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,nombre_apellido);
        pstmt.setString(2,direccion);
        pstmt.setInt(3, Integer.parseInt(edad));
        pstmt.setInt(4,Integer.parseInt(telefono));
        pstmt.setString(5,correo);

        pstmt.setDouble(6,nota1);
        pstmt.setDouble(7,nota2);
        int rowsAffected = pstmt.executeUpdate();
        if ((rowsAffected>0 )){
            JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
        }else {
            JOptionPane.showMessageDialog(null,"Error al ingresar datos");
        }
        pstmt.close();
        connection.close();

    }
    public Connection conectar()throws SQLException{
        String url = "jdbc:mysql://localhost:3306/curso";
        String user ="root";
        String password = "12345";

        return DriverManager.getConnection(url,user,password);





    }
}
