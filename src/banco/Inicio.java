package banco;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import BaseDatos.Conexion;

public class Inicio extends JFrame implements ActionListener {

    private Connection conexion = null;
    private Statement comando = null;
    private ResultSet registro;
    private String tabla = "registro";
    private boolean f = false;
    private int cuenta;
    
    Cliente cli = new Cliente();
    ATM cosito2 = new ATM();
    Conexion c1 = new Conexion();
    
    

    JButton validar, cero, borrar, salir;
    JLabel ID, imagen, titulo, prueba;
    JTextField N_ID;
    String N[];
    JButton b[];
    JPanel Teclado1, Teclado2, Teclado3, texto;
    Container contenedor = getContentPane();
    ImageIcon imagen2 = new ImageIcon("C://Users//admin1//Desktop//imagenes//banco.png");
    ImageIcon ImageIcon = new ImageIcon("C://Users//admin1//Desktop//imagenes//icono.png");
    Image image = ImageIcon.getImage();
    
    public Inicio() {

        super("Inicio");
        
        this.setIconImage(image);
        
        
        validar = new JButton("INGRESAR");
        cero = new JButton("0");
        borrar = new JButton("AC");
        salir = new JButton("SALIR");
        ID = new JLabel("Por favor ingrese su numero ID");
        titulo = new JLabel("BIENVENIDO");
        imagen = new JLabel(imagen2);
        N_ID = new JTextField(9);
        texto = new JPanel();
        Teclado1 = new JPanel();
        Teclado2 = new JPanel();
        Teclado3 = new JPanel();
        
        cero.setPreferredSize(new Dimension(140, 35));
        borrar.setPreferredSize(new Dimension(70, 35));
        
        contenedor.setLayout(new FlowLayout());
        Teclado1.setLayout(new GridLayout(3, 2));
        Teclado2.setLayout(new FlowLayout(1));
        Teclado3.setLayout(new FlowLayout());
        texto.setLayout(new FlowLayout());
        
        imagen.setBounds(25,15,300,150);
        titulo.setBounds(35,135,300,30);
        ID.setBounds(45,212,200,30);
        titulo.setFont(new Font("Andale Mono", 3, 18));
        ID.setFont(new Font("Andale Mono",0, 12));
        titulo.setForeground(new Color(255,255,255));
        texto.setBackground(new Color(104, 210, 236));
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
        salir.setPreferredSize(new Dimension(100,25));
        
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
        validar.setForeground(Color.white);
        salir.setForeground(Color.white);
        borrar.setForeground(Color.black);
        N_ID.setForeground(Color.black);
        ID.setForeground(Color.black);
       
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
        borrar.setBackground(new Color(237, 246, 246));
        salir.setBackground(new Color(232, 51, 19));
        validar.setBackground(new Color(93, 232, 19));
        N_ID.setBackground(Color.white);
        
        
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
        
        texto.add(ID);
        texto.add(N_ID);

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

        N_ID.addActionListener(this);
        validar.addActionListener(this);

        contenedor.add(imagen);
        contenedor.add(titulo);
        contenedor.add(texto);
        contenedor.add(Teclado1);
        contenedor.add(Teclado2);
        contenedor.add(Teclado3);
        
        c1.MySQLConnect();
        
        setSize(400, 450);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(104, 210, 236));
        N_ID.setEditable(false);
        
        
    }

    public void validacion() throws Excepcion_logeo {
            
            cli.setCuenta(Integer.parseInt(N_ID.getText()));
            
            if (c1.Logeo_1(cli.getCuenta()) == true) {
                dispose();
                Inicio_2 lp = new Inicio_2();
                
            } else {
                throw new Excepcion_logeo("NUMERO INCORRECTO");
            }
    }
    
    public void bloqueo(){
        if(cuenta == 3){
            JOptionPane.showMessageDialog(null, "ERROR SISTEMA BLOQUEADO POR INTENTOS INCORRECTOS");
            System.exit(0);
        }else{}
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        N = new String[11];
        String N[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < b.length; i++) {

            if (e.getSource() == b[i]) {
                N_ID.setText(N_ID.getText() + N[i]);

            }
        }

        if (e.getSource() == validar) {
            try {
                validacion();
            } catch (Excepcion_logeo ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                c1.MySQLConnect();
                cuenta++;
                System.out.println(cuenta);
                bloqueo();
            } catch(Exception as){
                JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE SU NUMERO DE CUENTA");
            }
        }

        if (e.getSource() == cero) {
            N_ID.setText(N_ID.getText() + "0");
        }
        if (e.getSource() == borrar) {
            N_ID.setText(null);
        }
        if (e.getSource() == salir) {
            System.exit(0);
        }

    }

}
