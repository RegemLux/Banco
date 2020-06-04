package banco;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import BaseDatos.Conexion;

public class Restablecer extends JFrame implements ActionListener {

    JLabel fondo, titulo;
    JTextField pantalla;
    JButton b[], enter, borrar, cero;
    JPanel teclado, opcionales;
    Container menu_restablecer = getContentPane();

    String n[];
    int nueva=0;

    ImageIcon imagen = new ImageIcon("C://Users//admin1//Desktop//imagenes//banco.png");
    ImageIcon ImageIcon = new ImageIcon("C://Users//admin1//Desktop//imagenes//icono.png");
    Image image = ImageIcon.getImage();
    
    Conexion c9 = new Conexion(); 
    Cliente cli_2 = new Cliente();
    
    public Restablecer() {
        super("Restablecer");

        this.setIconImage(image);
        
        c9.MySQLConnect();
        

        menu_restablecer.setLayout(new FlowLayout());

        fondo = new JLabel(imagen);
        fondo.setBounds(25, 15, 300, 150);

        titulo = new JLabel("Ingrese su nueva contrasena");
        titulo.setFont(new Font("Andale Mono", 0, 18));
        titulo.setBounds(35, 135, 300, 30);

        pantalla = new JTextField(14);
        pantalla.setEditable(false);
        
        cero = new JButton("0");
        cero.setPreferredSize(new Dimension(140,35));
        cero.setForeground(Color.black);
        cero.setBackground(new Color(237, 246, 246));
        cero.addActionListener(this);
        
        borrar = new JButton("AC");
        borrar.setPreferredSize(new Dimension(140,35));
        borrar.setForeground(Color.black);
        borrar.setBackground(new Color(237, 246, 246));
        borrar.addActionListener(this);

        enter = new JButton("Continuar");
        enter.setBackground(new Color(232, 51, 19));
        enter.setForeground(Color.white);
        enter.setPreferredSize(new Dimension(100, 25));
        enter.addActionListener(this);

        teclado = new JPanel(new GridLayout(3, 2));
        teclado.setBackground(new Color(104, 210, 236));
        
        opcionales = new JPanel(new FlowLayout());
        opcionales.setBackground(new Color(104, 210, 236));
        opcionales.add(cero);
        opcionales.add(borrar);

        b = new JButton[9];
        b[0] = new JButton("1");
        b[1] = new JButton("2");
        b[2] = new JButton("3");
        b[3] = new JButton("4");
        b[4] = new JButton("5");
        b[5] = new JButton("6");
        b[6] = new JButton("7");
        b[7] = new JButton("8");
        b[8] = new JButton("9");

        for (int i = 0; i < b.length; i++) {
            b[i].setPreferredSize(new Dimension(100, 35));
            b[i].setForeground(Color.black);
            b[i].setBackground(new Color(237, 246, 246));
            b[i].addActionListener(this);
            teclado.add(b[i]);
        }

        menu_restablecer.add(fondo);
        menu_restablecer.add(titulo);
        menu_restablecer.add(pantalla);
        menu_restablecer.add(teclado);
        menu_restablecer.add(opcionales);
        menu_restablecer.add(enter);

        this.setSize(400, 450);
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(104, 210, 236));

    }
    
    public void validacion_C(){
        nueva = Integer.parseInt(pantalla.getText());
        
        if(pantalla.getText().length() == 5){
            c9.res_2(cli_2.getCuenta(), nueva);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR RECUERDE INTRODUCIR SOLO 5 NUMEROS");
        }
    }

    @Override
    public void actionPerformed(ActionEvent lp) {
        n = new String[9];
        String n[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int x = 0; x < b.length; x++) {
            if (lp.getSource() == b[x]) {
                pantalla.setText(pantalla.getText() + n[x]);
            }
        }
        
        if(lp.getSource() == enter ){
            validacion_C();
        }
        
        if(lp.getSource() == cero){
            pantalla.setText(pantalla.getText() + 0 );
        }
        
        if(lp.getSource() == borrar){
            pantalla.setText(null);
        }
    }

}
