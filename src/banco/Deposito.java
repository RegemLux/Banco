package banco;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BaseDatos.Conexion;
import java.util.Date;

public class Deposito extends JFrame implements ActionListener {

    int saldo;
    double p;
    double s = 0;
    JButton h[], cero;
    String k[];
    JButton convertir, continuar, borrar;
    JTextField deposito, dolares;
    JLabel ingrese, Centavos, Dolares, imagen;
    JPanel Teclado, R1, R2;
    Container contenedor = getContentPane();
    ImageIcon fondo = new ImageIcon("C://Users//admin1//Desktop//imagenes//banco.png");
    ImageIcon ImageIcon = new ImageIcon("C://Users//admin1//Desktop//imagenes//icono.png");
    Image image = ImageIcon.getImage();

    Cliente ad = new Cliente();
    Conexion c6 = new Conexion();

    Timer timer = new Timer(20000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Inicio lg = new Inicio();
            dispose();
            JOptionPane.showMessageDialog(null, "Tiempo limite Excedido");
            timer.stop();

        }
    });

    public Deposito() {

        super("Deposito");

        this.setIconImage(image);

        timer.start();
        c6.MySQLConnect();

        contenedor.setLayout(new FlowLayout());
        cero = new JButton("0");
        ingrese = new JLabel("por favor ingrese el deposito en centavos o ingrese 0 para CANCELAR");
        Centavos = new JLabel("Centavos");
        Dolares = new JLabel("Dolares");
        imagen = new JLabel(fondo);
        convertir = new JButton("Convertir");
        continuar = new JButton("OK");
        borrar = new JButton("AC");
        deposito = new JTextField(9);
        dolares = new JTextField(9);
        Teclado = new JPanel(new GridLayout(4, 1));
        R1 = new JPanel(new FlowLayout());
        R2 = new JPanel(new FlowLayout());

        imagen.setBounds(25, 15, 300, 150);
        ingrese.setFont(new Font("Andale Mono", 3, 12));
        ingrese.setForeground(new Color(255, 255, 255));

        h = new JButton[11];
        h[0] = new JButton("1");
        h[1] = new JButton("2");
        h[2] = new JButton("3");
        h[3] = new JButton("4");
        h[4] = new JButton("5");
        h[5] = new JButton("6");
        h[6] = new JButton("7");
        h[7] = new JButton("8");
        h[8] = new JButton("9");

        h[0].setPreferredSize(new Dimension(70, 35));
        h[1].setPreferredSize(new Dimension(70, 35));
        h[2].setPreferredSize(new Dimension(70, 35));
        h[3].setPreferredSize(new Dimension(70, 35));
        h[4].setPreferredSize(new Dimension(70, 35));
        h[5].setPreferredSize(new Dimension(70, 35));
        h[6].setPreferredSize(new Dimension(70, 35));
        h[7].setPreferredSize(new Dimension(70, 35));
        h[8].setPreferredSize(new Dimension(70, 35));
        borrar.setPreferredSize(new Dimension(70, 35));
        cero.setPreferredSize(new Dimension(70, 35));
        continuar.setPreferredSize(new Dimension(70, 35));

        h[0].setForeground(Color.black);
        h[1].setForeground(Color.black);
        h[2].setForeground(Color.black);
        h[3].setForeground(Color.black);
        h[4].setForeground(Color.black);
        h[5].setForeground(Color.black);
        h[6].setForeground(Color.black);
        h[7].setForeground(Color.black);
        h[8].setForeground(Color.black);
        convertir.setForeground(Color.black);
        cero.setForeground(Color.black);
        borrar.setForeground(Color.black);
        continuar.setForeground(Color.white);

        h[0].setBackground(new Color(237, 246, 246));
        h[1].setBackground(new Color(237, 246, 246));
        h[2].setBackground(new Color(237, 246, 246));
        h[3].setBackground(new Color(237, 246, 246));
        h[4].setBackground(new Color(237, 246, 246));
        h[5].setBackground(new Color(237, 246, 246));
        h[6].setBackground(new Color(237, 246, 246));
        h[7].setBackground(new Color(237, 246, 246));
        h[8].setBackground(new Color(237, 246, 246));
        convertir.setBackground(new Color(237, 246, 246));
        cero.setBackground(new Color(237, 246, 246));
        borrar.setBackground(new Color(237, 246, 246));
        continuar.setBackground(new Color(93, 232, 19));

        Teclado.add(h[0]);
        Teclado.add(h[1]);
        Teclado.add(h[2]);
        Teclado.add(h[3]);
        Teclado.add(h[4]);
        Teclado.add(h[5]);
        Teclado.add(h[6]);
        Teclado.add(h[7]);
        Teclado.add(h[8]);
        Teclado.add(borrar);
        Teclado.add(cero);
        Teclado.add(continuar);

        R1.add(Centavos);
        R1.add(deposito);
        R1.add(convertir);
        R1.add(Dolares);
        R1.add(dolares);

        R1.setBackground(new Color(104, 210, 236));
        R2.setBackground(new Color(104, 210, 236));

        convertir.addActionListener(this);
        continuar.addActionListener(this);
        h[0].addActionListener(this);
        h[1].addActionListener(this);
        h[2].addActionListener(this);
        h[3].addActionListener(this);
        h[4].addActionListener(this);
        h[5].addActionListener(this);
        h[6].addActionListener(this);
        h[7].addActionListener(this);
        h[8].addActionListener(this);
        cero.addActionListener(this);
        borrar.addActionListener(this);

        contenedor.add(imagen);
        contenedor.add(ingrese);
        contenedor.add(R1);
        contenedor.add(Teclado);

        deposito.setEditable(false);
        dolares.setEditable(false);

        setSize(460, 450);
        setVisible(true);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(104, 210, 236));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String k[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < h.length; i++) {
            if (e.getSource() == h[i]) {
                deposito.setText(deposito.getText() + k[i]);
            }

        }
        if (e.getSource() == cero) {
            if (deposito.getText().equals("")) {
                Inicio back_2 = new Inicio();
                dispose();
            } else {
                deposito.setText(deposito.getText() + 0);
            }
        }

        if (e.getSource() == convertir) {

            p = Double.parseDouble(deposito.getText()) / 100;
            dolares.setText(String.valueOf(p));

        }

        if (e.getSource() == continuar) {
            s = Double.parseDouble(dolares.getText());
            c6.deposito(ad.getCuenta(), ad.getCuentaEx(), s);
            recibo();
            dispose();
        }

        if (e.getSource() == borrar) {
            deposito.setText(null);
            dolares.setText(null);
        }

    }

    public void recibo() {
        Date fecha = new Date();
            
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea un recibo?", "Recibo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (resp == JOptionPane.YES_NO_OPTION) {

            JOptionPane.showMessageDialog(null, " GRACIAS POR USAR NUESTROS SERVICIOS " + "\n Numero de cuenta: " + ad.getCuenta() + "\n Monto enviado: " + s + "\n Cuenta enviada" + ad.getCuentaEx() + "\n" + fecha);
            Inicio backsito = new Inicio();

        }

        if (resp == JOptionPane.NO_OPTION) {

            Inicio backsito = new Inicio();

        }

    }

}
