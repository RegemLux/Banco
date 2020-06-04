package banco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BaseDatos.Conexion;

public class Recargar extends JFrame implements ActionListener {

    String n[];
    int valor=0;

    JLabel imagen, titulo, subtitulo;
    JPanel teclado, opcion, texto, accion;
    JButton b[], enter, salir, cero, borrar;
    JTextField pantalla;
    Container menu_recarga = getContentPane();
    ImageIcon fondo = new ImageIcon("C://Users//admin1//Desktop//imagenes//banco.png");
    ImageIcon imageIcon = new ImageIcon("C://Users//admin1//Desktop//imagenes//icono.png");
    Image image = imageIcon.getImage();

    Conexion c8 = new Conexion();
    Cliente cp = new Cliente();

    public Recargar() {

        super("Recargar");

        c8.MySQLConnect();

        this.setIconImage(image);

        menu_recarga.setLayout(new FlowLayout());

        imagen = new JLabel(fondo);
        imagen.setBounds(25, 15, 300, 150);

        titulo = new JLabel("BIENVENIDO");
        titulo.setBounds(35, 135, 300, 30);
        titulo.setForeground(Color.white);
        titulo.setFont(new Font("Andale Mono", 3, 18));

        subtitulo = new JLabel("Por favor ingrese el monto a recargar");
        subtitulo.setBounds(45, 212, 200, 30);
        subtitulo.setFont(new Font("Andale Mono", 0, 12));
        subtitulo.setForeground(Color.white);

        pantalla = new JTextField(10);
        pantalla.setEditable(false);

        enter = new JButton("Ingresar");
        enter.setForeground(Color.white);
        enter.setBackground(new Color(93, 232, 19));
        enter.setPreferredSize(new Dimension(100, 25));
        enter.addActionListener(this);

        salir = new JButton("Salir");
        salir.setForeground(Color.white);
        salir.setBackground(new Color(232, 51, 19));
        salir.setPreferredSize(new Dimension(100, 25));
        salir.addActionListener(this);

        cero = new JButton("0");
        cero.setForeground(Color.black);
        cero.setBackground(new Color(237, 246, 246));
        cero.setPreferredSize(new Dimension(140, 35));
        cero.addActionListener(this);

        borrar = new JButton("AC");
        borrar.setForeground(Color.black);
        borrar.setBackground(new Color(237, 246, 246));
        borrar.setPreferredSize(new Dimension(70, 35));
        borrar.addActionListener(this);

        texto = new JPanel(new FlowLayout());
        texto.setBackground(new Color(104, 210, 236));
        texto.add(subtitulo);
        texto.add(pantalla);

        teclado = new JPanel(new GridLayout(3, 2));
        teclado.setBackground(new Color(104, 210, 236));

        accion = new JPanel(new FlowLayout());
        accion.setBackground(new Color(104, 210, 236));
        accion.add(cero);
        accion.add(borrar);

        opcion = new JPanel(new FlowLayout());
        opcion.setBackground(new Color(104, 210, 236));
        opcion.add(salir);
        opcion.add(enter);

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
            b[i].setPreferredSize(new Dimension(70, 35));
            b[i].setForeground(Color.black);
            b[i].setBackground(new Color(237, 246, 246));
            b[i].addActionListener(this);
            teclado.add(b[i]);
        }

        menu_recarga.add(imagen);
        menu_recarga.add(titulo);
        menu_recarga.add(texto);
        menu_recarga.add(teclado);
        menu_recarga.add(accion);
        menu_recarga.add(opcion);

        this.setSize(400, 450);
        this.setVisible(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(104, 210, 236));

    }
    
    public void deposito(){
        valor = Integer.parseInt(pantalla.getText());
        
        c8.recarga(cp.getCuenta(), valor);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        n = new String[9];
        String n[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int x = 0; x < b.length; x++) {
            if (e.getSource() == b[x]) {
                pantalla.setText(pantalla.getText() + n[x]);
            }
        }

        if (e.getSource() == cero) {
            pantalla.setText(pantalla.getText() + 0);
        }

        if (e.getSource() == borrar) {
            pantalla.setText(null);
        }

        if (e.getSource() == enter) {
            
            try{
               deposito(); 
            }catch(Exception eas){
                JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UN NUMERO VALIDO");
                Inicio backsote = new Inicio();
                dispose();
            }
            
        }

        if (e.getSource() == salir) {
            Inicio back = new Inicio();
            dispose();
        }
    }

}
