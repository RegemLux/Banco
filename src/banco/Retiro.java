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

public class Retiro extends JFrame implements ActionListener {

    private String hilo4;
    private boolean con = false;
    private int monto = 0;
    private int saldo = 0;
    private Connection conexion = null;
    private Statement comando = null;
    private ResultSet registro;
    private String tabla = "registro";

    Cliente cli = new Cliente();
    Conexion c4 = new Conexion();
    ATM cosito = new ATM();

    JButton R1, R2, R3, R4, R5, salir;
    JTextField monto_retirar;
    JPanel panel1, panel2;
    JLabel retiro, seleccion, imagen2;
    Container contenedor = getContentPane();
    ImageIcon ImageIcon = new ImageIcon("C://Users//admin1//Desktop//imagenes//icono.png");
    Image image = ImageIcon.getImage();

    Timer timer = new Timer(20000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            dispose();
            timer.stop();
            JOptionPane.showMessageDialog(null, "Tiempo limite excedido");
            Inicio lg = new Inicio();

        }
    });

    public Retiro() {
        super("Monto a Retirar");

        timer.start();

        this.setIconImage(image);

        contenedor.setLayout(new FlowLayout());
        this.getContentPane().setBackground(new Color(104, 210, 236));
        salir = new JButton("SALIR");
        salir.setBackground(new Color(237, 246, 246));
        salir.setForeground(Color.black);
        R1 = new JButton("20$ ");
        R1.setBackground(new Color(237, 246, 246));
        R1.setForeground(Color.black);
        R2 = new JButton("40$ ");
        R2.setBackground(new Color(237, 246, 246));
        R2.setForeground(Color.black);
        R3 = new JButton("60$ ");
        R3.setBackground(new Color(237, 246, 246));
        R3.setForeground(Color.black);
        R4 = new JButton("100$");
        R4.setBackground(new Color(237, 246, 246));
        R4.setForeground(Color.black);
        R5 = new JButton("200$");
        R5.setBackground(new Color(237, 246, 246));
        R5.setForeground(Color.black);
        monto_retirar = new JTextField(9);

        R1.setPreferredSize(new Dimension(110, 40));
        R2.setPreferredSize(new Dimension(110, 40));
        R3.setPreferredSize(new Dimension(110, 40));
        R4.setPreferredSize(new Dimension(110, 40));
        R5.setPreferredSize(new Dimension(110, 40));
        salir.setPreferredSize(new Dimension(110, 40));

        panel1 = new JPanel(new FlowLayout());
        panel2 = new JPanel(new FlowLayout());

        panel1.setBackground(new Color(104, 210, 236));
        panel2.setBackground(new Color(104, 210, 236));

        panel1.add(R1);
        panel1.add(R2);
        panel1.add(R3);
        panel2.add(R4);
        panel2.add(R5);
        panel2.add(salir);

        ImageIcon imagen = new ImageIcon("C://Users//admin1//Desktop//imagenes//banco.png");
        imagen2 = new JLabel(imagen);
        imagen2.setBounds(25, 15, 350, 150);

        R1.addActionListener(this);
        R2.addActionListener(this);
        R3.addActionListener(this);
        R4.addActionListener(this);
        R5.addActionListener(this);
        salir.addActionListener(this);

        seleccion = new JLabel("seleccione una opcion a retirar");
        seleccion.setForeground(Color.white);
        seleccion.setFont(new Font("Andale mono", 1, 15));

        c4.MySQLConnect();

        contenedor.add(imagen2);
        contenedor.add(seleccion);
        contenedor.add(panel1);
        contenedor.add(panel2);
        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == R1) {
            if (cosito.get20() > 0) {
                monto = 20;
                c4.Retiro(cli.getCuenta(), monto);
                c4.recibo(cli.getCuenta(), monto);
                dispose();
                timer.stop();
            } else {
                int resp = JOptionPane.showConfirmDialog(null, "No contamos con billetes del valor solicitado, desea recibir billetes de menor valor?", "Recibo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_NO_OPTION) {
                    monto = 20;
                    c4.Retiro(cli.getCuenta(), monto);
                    c4.recibo(cli.getCuenta(), monto);
                    dispose();
                    timer.stop();
                }

                if (resp == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, " GRACIAS POR USAR NUESTROS SERVICIOS ");
                    Inicio backsito = new Inicio();
                }
            }
        }

        if (e.getSource() == R2) {
            if (cosito.get40() > 0) {
                monto = 40;
                c4.Retiro(cli.getCuenta(), monto);
                c4.recibo(cli.getCuenta(), monto);
                dispose();
                timer.stop();
            } else {
                int resp = JOptionPane.showConfirmDialog(null, "No contamos con billetes del valor solicitado, desea recibir billetes de menor valor?", "Recibo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_NO_OPTION) {
                    monto = 40;
                    c4.Retiro(cli.getCuenta(), monto);
                    c4.recibo(cli.getCuenta(), monto);
                    dispose();
                    timer.stop();
                }

                if (resp == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, " GRACIAS POR USAR NUESTROS SERVICIOS ");
                    Inicio backsito = new Inicio();
                }
            }
        }
        
        if (e.getSource() == R3) {
            if (cosito.get60() > 0) {
                monto = 60;
                c4.Retiro(cli.getCuenta(), monto);
                c4.recibo(cli.getCuenta(), monto);
                dispose();
                timer.stop();
            } else {
                int resp = JOptionPane.showConfirmDialog(null, "No contamos con billetes del valor solicitado, desea recibir billetes de menor valor?", "Recibo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_NO_OPTION) {
                    monto = 60;
                    c4.Retiro(cli.getCuenta(), monto);
                    c4.recibo(cli.getCuenta(), monto);
                    dispose();
                    timer.stop();
                }

                if (resp == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, " GRACIAS POR USAR NUESTROS SERVICIOS ");
                    Inicio backsito = new Inicio();
                }
            }
        }
        
        if (e.getSource() == R4) {
           if (cosito.get100() > 0) {
                monto = 100;
                c4.Retiro(cli.getCuenta(), monto);
                c4.recibo(cli.getCuenta(), monto);
                dispose();
                timer.stop();
            } else {
                int resp = JOptionPane.showConfirmDialog(null, "No contamos con billetes del valor solicitado, desea recibir billetes de menor valor?", "Recibo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_NO_OPTION) {
                    monto = 100;
                    c4.Retiro(cli.getCuenta(), monto);
                    c4.recibo(cli.getCuenta(), monto);
                    dispose();
                    timer.stop();
                }

                if (resp == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, " GRACIAS POR USAR NUESTROS SERVICIOS ");
                    Inicio backsito = new Inicio();
                }
            }
        }
        
        if (e.getSource() == R5) {
            if (cosito.get200() > 0) {
                monto = 200;
                c4.Retiro(cli.getCuenta(), monto);
                c4.recibo(cli.getCuenta(), monto);
                dispose();
                timer.stop();
            } else {
                int resp = JOptionPane.showConfirmDialog(null, "No contamos con billetes del valor solicitado, desea recibir billetes de menor valor?", "Recibo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (resp == JOptionPane.YES_NO_OPTION) {
                    monto = 200;
                    c4.Retiro(cli.getCuenta(), monto);
                    c4.recibo(cli.getCuenta(), monto);
                    dispose();
                    timer.stop();
                }

                if (resp == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, " GRACIAS POR USAR NUESTROS SERVICIOS ");
                    Inicio backsito = new Inicio();
                }
            }
        }
        if (e.getSource() == salir) {
            Inicio back = new Inicio();
            dispose();
            timer.stop();
        }

    }

}
