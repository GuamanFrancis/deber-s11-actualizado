import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Menu_de_administrador extends JFrame{
    private JButton ingresarButton;
    private JButton mostrarButton;
    private JButton busquedaButton;
    private JButton regresarButton;
    private JPanel panelmenu;

    public Menu_de_administrador() {
        super("Menu del Administrador");
        setContentPane(panelmenu);
        Pantalla_login pa = new Pantalla_login();

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pantalladeingreso ingreso = new pantalladeingreso();
                ingreso.ingresar();
                dispose();
            }
        });


        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pantallamostrartodoslosdatos mostrardatos = new Pantallamostrartodoslosdatos();
                mostrardatos.ingresar();
                dispose();




            }
        });
        busquedaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Datospersonalizados pantallabusquedaper = new Datospersonalizados();
                pantallabusquedaper.ingresar();
                dispose();

            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pantalla_login pantallalogin = new Pantalla_login();
                pantallalogin.ingresar();


            }
        });
    }
    public void ingresar(){
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
