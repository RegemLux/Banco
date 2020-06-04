package banco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BaseDatos.Conexion;

public class Transaccion extends JFrame implements ActionListener{

    Container menu_trans = getContentPane();
    JLabel titulo_trans, imagen_2;
    JButton b_retiro, b_deposito, b_consulta, b_salir, b_recargar;
    JPanel panel_trans, panel_trans2;
    ImageIcon fondo_2 = new ImageIcon("C://Users//admin1//Desktop//imagenes//banco.png");
    Icon image1 = new ImageIcon("C://Users//admin1//Desktop//imagenes//cash.png");
    Icon image2 = new ImageIcon("C://Users//admin1//Desktop//imagenes//send.png");
    Icon image3 = new ImageIcon("C://Users//admin1//Desktop//imagenes//search.png");
    Icon image4 = new ImageIcon("C://Users//admin1//Desktop//imagenes//off.png");
    Icon image5 = new ImageIcon("C://Users//admin1//Desktop//imagenes//coin.png");
    
    ImageIcon ImageIcon = new ImageIcon("C://Users//admin1//Desktop//imagenes//icono.png");
    Image image = ImageIcon.getImage();
    
    Conexion c3 = new Conexion();
    Cliente f = new Cliente();
    
    
    
    public Transaccion() {
        super("Transaccion");
        
        this.setIconImage(image);
        

        menu_trans.setLayout(new FlowLayout());
        titulo_trans = new JLabel("¡Buenos dias! Bienvenido");
        panel_trans = new JPanel(new FlowLayout());
        imagen_2 = new JLabel(fondo_2);
        panel_trans2 = new JPanel(new FlowLayout());
        b_retiro = new JButton("Retirar", image1);
        b_deposito = new JButton("Depositar", image2);
        b_consulta = new JButton("Consultar", image3);
        b_recargar = new JButton("Recargar", image5);
        b_salir = new JButton("Salir", image4);
        
        
        imagen_2.setBounds(25,15,300,150);
        titulo_trans.setBounds(35,135,300,30);
        titulo_trans.setFont(new Font("Andale Mono", 3,18));
        titulo_trans.setForeground(new Color(255,255,255));
        panel_trans.setBackground(new Color(104, 210, 236));
        panel_trans2.setBackground(new Color(104, 210, 236));
        
        b_retiro.setPreferredSize(new Dimension(140,50));
        b_deposito.setPreferredSize(new Dimension(140,50));
        b_consulta.setPreferredSize(new Dimension(140,50));
        b_salir.setPreferredSize(new Dimension(140,50));
        b_recargar.setPreferredSize(new Dimension(140,50));
        
        b_retiro.setForeground(Color.black);
        b_deposito.setForeground(Color.black);
        b_consulta.setForeground(Color.black);
        b_salir.setForeground(Color.black);
        b_recargar.setForeground(Color.black);
        
        b_retiro.setBackground(new Color(237, 246, 246));
        b_deposito.setBackground(new Color(237, 246, 246));
        b_consulta.setBackground(new Color(237, 246, 246));
        b_salir.setBackground(new Color(237, 246, 246));
        b_recargar.setBackground(new Color(237, 246, 246));

        panel_trans2.add(b_consulta);
        panel_trans2.add(b_recargar);
        panel_trans2.add(b_salir);
        panel_trans.add(b_retiro);
        panel_trans.add(b_deposito);
        
        
        b_retiro.addActionListener(this);
        b_deposito.addActionListener(this);
        b_consulta.addActionListener(this);
        b_salir.addActionListener(this);
        b_recargar.addActionListener(this);
        
        menu_trans.add(imagen_2);
        menu_trans.add(titulo_trans);
        menu_trans.add(panel_trans);
        menu_trans.add(panel_trans2);
        
        setSize(470, 350);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(104, 210, 236));
        
        c3.MySQLConnect();
        if(c3.res(f.getCuenta())){
            dispose();
        }
    }

    @Override
    public void actionPerformed(ActionEvent tra) {

        //Boton retiro
        if (tra.getSource() == b_retiro) {
            dispose();
            Retiro lr = new Retiro();
        }
        //Boton deposito
        if (tra.getSource() == b_deposito) {
            dispose();
            Verificacion lb = new Verificacion();
        }
        //Boton consulta
        if (tra.getSource() == b_consulta) {
            dispose();
            Consulta la = new Consulta();
        }
        //Boton recargar
        if (tra.getSource() == b_recargar) {
            dispose();
            Recargar lx = new Recargar();
        }
        //Boton salir
        if (tra.getSource() == b_salir) {
            Inicio back = new Inicio();
            dispose();
        }

    }
} 