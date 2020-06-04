package banco;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import BaseDatos.Conexion;

public class Consulta extends JFrame implements ActionListener{

    private Connection conexion = null;
    private Statement comando = null;
    private ResultSet registro;
    private String tabla = "registro";

    JButton Salir;
    JTextField Saldo;
    JLabel Saldo_disponible, fondo_3;
    JPanel Visible, Visible2;
    Container contenedor = getContentPane();
    ImageIcon banco_2 = new ImageIcon("C://Users//admin1//Desktop//imagenes//banco.png");
    ImageIcon ImageIcon = new ImageIcon("C://Users//admin1//Desktop//imagenes//icono.png");
    Image image = ImageIcon.getImage();
    
    
    Cliente cli = new Cliente();
    Conexion c7 = new Conexion();
    

    public Consulta() {
        super("Saldo");
        
        this.setIconImage(image);
        
        c7.MySQLConnect();

        contenedor.setLayout(new FlowLayout());
        Salir = new JButton("SALIR");
        Saldo = new JTextField(9);
        Saldo_disponible = new JLabel("Saldo Disponible");
        fondo_3 = new JLabel(banco_2);
        Visible = new JPanel();
        Visible.setLayout(new FlowLayout());
        Visible.add(Saldo_disponible);
        Visible.add(Saldo);
        Visible2 = new JPanel();
        Visible2.setLayout(new FlowLayout());
        Visible2.add(Salir);
        
        Saldo.setEditable(false);
        Salir.addActionListener(this);
        
        Saldo_disponible.setForeground(Color.white);
        Saldo_disponible.setFont(new Font("Andale Mono", 3,12));
        
        Visible.setBackground(new Color(104, 210, 236));
        Visible2.setBackground(new Color(104, 210, 236));
        Salir.setForeground(Color.black);
        Salir.setBackground(new Color(237, 246, 246));
        
        contenedor.add(fondo_3);
        contenedor.add(Visible);
        contenedor.add(Visible2);
        
        Saldo.setText("$" + String.valueOf(c7.consulta(cli.getCuenta())));
        
        setSize(400, 280);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(104, 210, 236));

    }

    @Override

    public void actionPerformed(ActionEvent alv) {
         if(alv.getSource() == Salir ){
                JOptionPane.showMessageDialog(null, "GRACIAS POR USAR NUESTROS SERVICIOS");
                dispose();
                Inicio lk = new Inicio();
         }   
    }

}
