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


public class Inicio_2 extends JFrame implements ActionListener{

    
     Cliente cli = new Cliente();
     Conexion c2 = new Conexion();
     
     

    JButton validar, cero, borrar, salir;
    JLabel NIP, fondo, titulo_2;
    JPasswordField N_NIP;
    String N[];
    JButton b[];
    JPanel Teclado1, Teclado2, Teclado3, texto2;
    Container contenedor = getContentPane();
    ImageIcon banco = new ImageIcon("C://Users//admin1//Desktop//imagenes//banco.png");
    ImageIcon ImageIcon = new ImageIcon("C://Users//admin1//Desktop//imagenes//icono.png");
    Image image = ImageIcon.getImage();

    public Inicio_2() {
        super("Numero de NIP");
        
        this.setIconImage(image);

        contenedor.setLayout(new FlowLayout());
        validar = new JButton("Ingresar");
        cero = new JButton("0");
        borrar = new JButton("AC");
        salir = new JButton("SALIR");
        NIP = new JLabel("Por favor ingrese su numero NIP");
        titulo_2 = new JLabel("BIENVENIDO");
        fondo = new JLabel(banco);
        N_NIP = new JPasswordField(9);
        Teclado1 = new JPanel();
        Teclado2 = new JPanel();
        Teclado3 = new JPanel();
        texto2 = new JPanel();
        
        
        cero.setPreferredSize(new Dimension(140, 35));
        borrar.setPreferredSize(new Dimension(70, 35));
        
        Teclado1.setLayout(new GridLayout(3, 2));
        Teclado2.setLayout(new FlowLayout(1));
        Teclado3.setLayout(new FlowLayout());
        texto2.setLayout(new FlowLayout());
        
        fondo.setBounds(25,15,300,150);
        titulo_2.setBounds(35,135,300,30);
        titulo_2.setFont(new Font("Andale Mono", 3, 18));
        NIP.setFont(new Font("Andale Mono",0, 12));
        titulo_2.setForeground(new Color(255,255,255));
        NIP.setForeground(Color.black);
        NIP.setBounds(45,212,200,30);
        texto2.setBackground(new Color(104, 210, 236));
        Teclado2.setBackground(new Color(104, 210, 236));
        Teclado3.setBackground(new Color(104, 210, 236));

        b = new JButton[11];
        b[0] = new JButton("1");
        b[1] = new JButton("2");
        b[2] = new JButton("3");
        b[3] = new JButton("4");
        b[4] = new JButton("5");
        b[5] = new JButton("6");
        b[6] = new JButton("7");
        b[7] = new JButton("8");
        b[8] = new JButton("9");
        
        b[0].setPreferredSize(new Dimension(70, 35));
        b[1].setPreferredSize(new Dimension(70, 35));
        b[2].setPreferredSize(new Dimension(70, 35));
        b[3].setPreferredSize(new Dimension(70, 35));
        b[4].setPreferredSize(new Dimension(70, 35));
        b[5].setPreferredSize(new Dimension(70, 35));
        b[6].setPreferredSize(new Dimension(70, 35));
        b[7].setPreferredSize(new Dimension(70, 35));
        b[8].setPreferredSize(new Dimension(70, 35));
        
        b[0].setForeground(Color.black);
        b[1].setForeground(Color.black);
        b[2].setForeground(Color.black);
        b[3].setForeground(Color.black);
        b[4].setForeground(Color.black);
        b[5].setForeground(Color.black);
        b[6].setForeground(Color.black);
        b[7].setForeground(Color.black);
        b[8].setForeground(Color.black);
        cero.setForeground(Color.black);
        validar.setForeground(Color.black);
        salir.setForeground(Color.black);
        borrar.setForeground(Color.black);
        
        b[0].setBackground(new Color(237, 246, 246));
        b[1].setBackground(new Color(237, 246, 246));
        b[2].setBackground(new Color(237, 246, 246));
        b[3].setBackground(new Color(237, 246, 246));
        b[4].setBackground(new Color(237, 246, 246));
        b[5].setBackground(new Color(237, 246, 246));
        b[6].setBackground(new Color(237, 246, 246));
        b[7].setBackground(new Color(237, 246, 246));
        b[8].setBackground(new Color(237, 246, 246));
        cero.setBackground(new Color(237, 246, 246));
        validar.setBackground(new Color(93, 232, 19));
        salir.setBackground(new Color(232, 51, 19));
        borrar.setBackground(new Color(237, 246, 246));
        

        Teclado1.add(b[6]);
        Teclado1.add(b[7]);
        Teclado1.add(b[8]);
        Teclado1.add(b[3]);
        Teclado1.add(b[4]);
        Teclado1.add(b[5]);
        Teclado1.add(b[0]);
        Teclado1.add(b[1]);
        Teclado1.add(b[2]);

        Teclado2.add(cero);
        Teclado2.add(borrar);

        Teclado3.add(salir);
        Teclado3.add(validar);
        
        texto2.add(NIP);
        texto2.add(N_NIP);

        cero.addActionListener(this);
        borrar.addActionListener(this);
        b[0].addActionListener(this);
        b[1].addActionListener(this);
        b[2].addActionListener(this);
        b[3].addActionListener(this);
        b[4].addActionListener(this);
        b[5].addActionListener(this);
        b[6].addActionListener(this);
        b[7].addActionListener(this);
        b[8].addActionListener(this);
        salir.addActionListener(this);

        N_NIP.addActionListener(this);
        validar.addActionListener(this);

        contenedor.add(fondo);
        contenedor.add(titulo_2);
        contenedor.add(texto2);
        contenedor.add(Teclado1);
        contenedor.add(Teclado2);
        contenedor.add(Teclado3);
        
        N_NIP.setEditable(false);
        
        c2.MySQLConnect();
        
        setSize(400, 450);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(104, 210, 236));
    }
    
    public void validacion() throws Excepcion_logeo {
            
            cli.setNIP(Integer.parseInt(N_NIP.getText()));
            
            System.out.println(cli.getNIP());

            if (c2.Logeo_2(cli.getCuenta(), cli.getNIP()) == true) {
                dispose();
                Transaccion lt = new Transaccion();
                
            } else {
                throw new Excepcion_logeo("NUMERO DE NIP INCORRECTO");
            }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        N = new String[11];
        String N[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < b.length; i++) {

            if (e.getSource() == b[i]) {
                N_NIP.setText(N_NIP.getText() + N[i]);

            }
        }
        
        if(e.getSource() == validar){
            try {
                validacion();
            } catch (Excepcion_logeo ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Inicio back_4 = new Inicio();
                dispose();
            } catch (Exception asd){
                JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UN NIP");
                Inicio backsito = new Inicio();
                dispose();
            }
        }

        if (e.getSource() == cero) {
            N_NIP.setText(N_NIP.getText() + "0");
        }
        if (e.getSource() == borrar) {
            N_NIP.setText(null);
        }
        if (e.getSource() == salir) {
            Inicio backsito = new Inicio();
        }

    }

}
