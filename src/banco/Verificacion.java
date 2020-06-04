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

public class Verificacion extends JFrame implements ActionListener{

    private Connection conexion = null;
    private Statement comando = null;
    private ResultSet registro;
    private String tabla = "registro";
    private boolean f = false;
    
    Conexion c5 = new Conexion();

    JButton continuar;
    JButton y[], cero, BORRAR, salir;
    String k[];
    JTextField NUMERO;
    JLabel CN, imagencita;
    JPanel teclado, y1, y2, texto, texto2;
    Container contenedor = getContentPane();
    ImageIcon fondito = new ImageIcon("C://Users//admin1//Desktop//imagenes//banco.png");
    ImageIcon ImageIcon = new ImageIcon("C://Users//admin1//Desktop//imagenes//icono.png");
    Image image = ImageIcon.getImage();

    Cliente tli = new Cliente();

    public Verificacion() {
        super("Numero de cuenta");

        this.setIconImage(image);
        c5.MySQLConnect();

        contenedor.setLayout(new FlowLayout());
        continuar = new JButton("Continuar");
        imagencita = new JLabel(fondito);
        cero = new JButton("0");
        BORRAR = new JButton("BORRAR");
        salir = new JButton("Salir");
        NUMERO = new JTextField(9);
        CN = new JLabel("Por favor ingrese el numero de cuenta a enviar");
        teclado = new JPanel(new GridLayout(3, 2));
        texto = new JPanel(new FlowLayout());
        texto2 = new JPanel(new FlowLayout());

        y1 = new JPanel();
        y1.setLayout(new FlowLayout());
        y2 = new JPanel();
        y2.setLayout(new FlowLayout());
        
        CN.setForeground(Color.white);
        CN.setFont(new Font("Andale mono", 1, 15));
        
        NUMERO.setEditable(false);

        imagencita.setBounds(25, 15, 300, 150);

        y = new JButton[11];
        y[0] = new JButton("1");
        y[1] = new JButton("2");
        y[2] = new JButton("3");
        y[3] = new JButton("4");
        y[4] = new JButton("5");
        y[5] = new JButton("6");
        y[6] = new JButton("7");
        y[7] = new JButton("8");
        y[8] = new JButton("9");

        y[0].setForeground(Color.black);
        y[1].setForeground(Color.black);
        y[2].setForeground(Color.black);
        y[3].setForeground(Color.black);
        y[4].setForeground(Color.black);
        y[5].setForeground(Color.black);
        y[6].setForeground(Color.black);
        y[7].setForeground(Color.black);
        y[8].setForeground(Color.black);
        cero.setForeground(Color.black);
        BORRAR.setForeground(Color.black);
        salir.setForeground(Color.white);
        continuar.setForeground(Color.white);

        y[0].setBackground(new Color(237, 246, 246));
        y[1].setBackground(new Color(237, 246, 246));
        y[2].setBackground(new Color(237, 246, 246));
        y[3].setBackground(new Color(237, 246, 246));
        y[4].setBackground(new Color(237, 246, 246));
        y[5].setBackground(new Color(237, 246, 246));
        y[6].setBackground(new Color(237, 246, 246));
        y[7].setBackground(new Color(237, 246, 246));
        y[8].setBackground(new Color(237, 246, 246));
        cero.setBackground(new Color(237, 246, 246));
        BORRAR.setBackground(new Color(237, 246, 246));
        salir.setBackground(new Color(232, 51, 19));
        continuar.setBackground(new Color(93, 232, 19));

        y[0].setPreferredSize(new Dimension(90, 35));
        cero.setPreferredSize(new Dimension(135, 35));
        BORRAR.setPreferredSize(new Dimension(135, 35));

        teclado.add(y[0]);
        teclado.add(y[1]);
        teclado.add(y[2]);
        teclado.add(y[3]);
        teclado.add(y[4]);
        teclado.add(y[5]);
        teclado.add(y[6]);
        teclado.add(y[7]);
        teclado.add(y[8]);

        y1.setBackground(new Color(104, 210, 236));
        y2.setBackground(new Color(104, 210, 236));

        y1.add(cero);
        y1.add(BORRAR);

        y2.add(salir);
        y2.add(continuar);

        texto.add(CN);
        texto2.add(NUMERO);
        texto.setBackground(new Color(104, 210, 236));
        texto2.setBackground(new Color(104, 210, 236));

        cero.addActionListener(this);
        BORRAR.addActionListener(this);
        continuar.addActionListener(this);
        y[0].addActionListener(this);
        y[1].addActionListener(this);
        y[2].addActionListener(this);
        y[3].addActionListener(this);
        y[4].addActionListener(this);
        y[5].addActionListener(this);
        y[6].addActionListener(this);
        y[7].addActionListener(this);
        y[8].addActionListener(this);
        salir.addActionListener(this);

        contenedor.add(imagencita);
        contenedor.add(texto);
        contenedor.add(texto2);
        contenedor.add(teclado);
        contenedor.add(y1);
        contenedor.add(y2);

        setSize(400, 450);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(new Color(104, 210, 236));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

            k = new String[11];
            String k[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

            for (int i = 0; i < y.length; i++) {

                if (e.getSource() == y[i]) {
                    NUMERO.setText(NUMERO.getText() + k[i]);
                }
            }

            if (e.getSource() == cero) {
                NUMERO.setText(NUMERO.getText() + "0");
            }
            if (e.getSource() == BORRAR) {
                NUMERO.setText(null);
            }
            if (e.getSource() == salir) {
                JOptionPane.showMessageDialog(null, "GRACIAS POR USAR NUESTROS SERVICIOS");
                dispose();
                Inicio back_3 = new Inicio();
            }

            if (e.getSource() == continuar) {
                try {
                    validar();
                } catch (Excepcion_logeo ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    Inicio backsito = new Inicio();
                }
            }
        }
    
    public void validar() throws Excepcion_logeo {
        
            tli.setCuentaEx(Integer.parseInt(NUMERO.getText()));
            

            if (c5.verificacion(tli.getCuentaEx())== true) {
                dispose();
                Deposito ls = new Deposito();
            } else {
                throw new Excepcion_logeo("NUMERO INCORRECTO");
            }

    }

}
