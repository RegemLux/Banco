package BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import banco.ATM;
import banco.Cliente;
import banco.Retiro;
import banco.Inicio;
import banco.Transaccion;
import banco.Restablecer;
import java.util.Date;

public class Conexion {

    private Connection conexion = null;
    private Statement comando = null;
    private ResultSet registro;
    private String tabla = "registro";
    private boolean f = false;
    private boolean g = false;
    private int a = 0;

    public Conexion() {
    }

    public void MySQLConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String servidor = "jdbc:mysql://localhost:3306/cuentas";
            String usuario = "root";
            String pass = "";

            conexion = DriverManager.getConnection(servidor, usuario, pass);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexcion a la base de datos: 1 " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexion a la base de datos: enciendala por favor 2 " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error en la conexion a la base de datos: 3 " + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion = null;
        }

    }

    public boolean Logeo_1(int a) {
        tabla = "cuenta";

        try {

            String Query = "SELECT numero_cuenta FROM " + tabla;

            comando = conexion.createStatement();
            registro = comando.executeQuery(Query);

            while (registro.next()) {

                if (registro.getInt("numero_cuenta") == a) {
                    comando.execute("UPDATE cuenta"
                            + "\nSET contador = contador + " + 1
                            + "\nWHERE numero_cuenta = " + a);
                    f = true;
                    break;
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                comando.close();
                conexion.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Por favor encienda la base de datos", e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }

        return f;

    }

    public boolean Logeo_2(int b, int c) {
        tabla = "cuenta";

        try {

            String Query = "SELECT nip FROM " + tabla + " WHERE numero_cuenta = " + b;

            comando = conexion.createStatement();
            registro = comando.executeQuery(Query);

            while (registro.next()) {

                if (registro.getInt("nip") == c) {
                    f = true;
                    break;
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                comando.close();
                conexion.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Por favor encienda la base de datos", e.getMessage(), JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        System.out.println(f);
        return f;
    }

    public void Retiro(int cuenta, int valor) {
        tabla = "cuenta";
        int s = cuenta;
        int m = valor;
        int saldito = 0;

        ATM lp = new ATM();

        try {
            String Query = "SELECT saldo FROM " + tabla + " WHERE numero_cuenta = " + s;

            comando = conexion.createStatement();
            registro = comando.executeQuery(Query);

            while (registro.next()) {

                saldito = registro.getInt("saldo");
                System.out.println(saldito);

                if (m <= saldito) {
                    if (lp.getCupo() >= m) {
                        comando.execute("UPDATE cuenta"
                                + "\nSET saldo = saldo - " + m
                                + "\nWHERE numero_cuenta = " + s);

                        lp.setCupo(lp.getCupo() - m);
                        lp.set200(lp.get200() - 1);

                    } else {
                        JOptionPane.showMessageDialog(null, "CUPO INSUFICIENTE VUELVA MANANA");
                        Inicio fail = new Inicio();

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE");
                    Inicio fail = new Inicio();
                }
            }

        } catch (Exception ex) {

        } finally {
            try {
                comando.close();
                conexion.close();
            } catch (SQLException ext) {
                JOptionPane.showMessageDialog(null, "Por favor encienda la base de datos", ext.getMessage(), JOptionPane.ERROR_MESSAGE);
                ext.printStackTrace();
            }
        }

    }

    public boolean verificacion(int cuenta_externa) {
        tabla = "cuenta";

        try {

            String Query = "SELECT numero_cuenta FROM " + tabla + " WHERE numero_cuenta = " + cuenta_externa;

            comando = conexion.createStatement();
            registro = comando.executeQuery(Query);

            System.out.println(cuenta_externa);

            while (registro.next()) {

                if (registro.getInt("numero_cuenta") == cuenta_externa) {
                    f = true;
                    break;
                }
            }

        } catch (SQLException awt) {
            JOptionPane.showMessageDialog(null, "ERROR EL NUMERO DE CUENTA ES INCORRECTO");
        } finally {
            try {
                comando.close();
                conexion.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Por favor encienda la base de datos", e.getMessage(), JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

        return f;
    }

    public void deposito(int cuenta_2, int cuenta_externa2, double valor_2) {

        tabla = "cuenta";

        try {
            String Query = "SELECT saldo FROM " + tabla + " WHERE numero_cuenta = " + cuenta_2;

            comando = conexion.createStatement();
            registro = comando.executeQuery(Query);

            while (registro.next()) {

                if (valor_2 <= registro.getInt("saldo")) {

                    comando.execute("UPDATE cuenta"
                            + "\nSET saldo = saldo - " + valor_2
                            + "\nWHERE numero_cuenta = " + cuenta_2);

                    comando.execute("UPDATE cuenta"
                            + "\nSET saldo = saldo + " + valor_2
                            + "\nWHERE numero_cuenta = " + cuenta_externa2);

                    break;

                } else {
                    JOptionPane.showMessageDialog(null, "por favor seleccione un monto mas pequeño");
                    Inicio fail2 = new Inicio();
                }

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "por favor seleccione un monto mas pequeño");

        } finally {
            try {
                comando.close();
                conexion.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Por favor encienda la base de datos", e.getMessage(), JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    public int consulta(int cuenta_3) {

        int r = 0;

        tabla = "cuenta";

        try {

            String Query = "SELECT saldo FROM " + tabla + " WHERE numero_cuenta = " + cuenta_3;

            comando = conexion.createStatement();
            registro = comando.executeQuery(Query);

            while (registro.next()) {

                r = registro.getInt("saldo");
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                comando.close();
                conexion.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Por favor encienda la base de datos", e.getMessage(), JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

        return r;
    }

    public void recarga(int cuenta_4, int valor_3) {
        tabla = "cuenta";

        try {

            String Query = "SELECT numero_cuenta FROM " + tabla + " WHERE numero_cuenta = " + cuenta_4;

            comando = conexion.createStatement();
            registro = comando.executeQuery(Query);

            while (registro.next()) {

                if (valor_3 > 0) {

                    comando.execute("UPDATE cuenta"
                            + "\nSET saldo = saldo + " + valor_3
                            + "\nWHERE numero_cuenta = " + cuenta_4);

                    JOptionPane.showMessageDialog(null, "GRACIAS POR USAR NUESTROS SERVICIOS");
                    Inicio backsito = new Inicio();

                    break;

                } else {
                    JOptionPane.showMessageDialog(null, "POR FAVOR INGRESE UNA SUMA MAYOR A 0");
                    Inicio backsito = new Inicio();
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                comando.close();
                conexion.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Por favor encienda la base de datos", e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public boolean res(int cuenta_5) {

        tabla = "cuenta";

        try {
            String Query = "SELECT contador FROM " + tabla + " WHERE numero_cuenta = " + cuenta_5;

            comando = conexion.createStatement();
            registro = comando.executeQuery(Query);

            System.out.println(cuenta_5);

            while (registro.next()) {
                a = registro.getInt("contador");

                if (a >= 5) {
                    JOptionPane.showMessageDialog(null, "SERA REDIRRECIONADO A CAMBIAR SU CONTRASENA");
                    Restablecer ko = new Restablecer();
                    g = true;
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                comando.close();
                conexion.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Por favor encienda la base de datos", e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }

        return g;

    }

    public void res_2(int cuenta_6, int valor_4) {
        tabla = "cuenta";

        try {

            String Query = "SELECT numero_cuenta FROM " + tabla + " WHERE numero_cuenta = " + cuenta_6;

            comando = conexion.createStatement();
            registro = comando.executeQuery(Query);

            while (registro.next()) {

                comando.execute("UPDATE cuenta"
                        + "\nSET nip = " + valor_4
                        + "\nWHERE numero_cuenta = " + cuenta_6);

                comando.execute("UPDATE cuenta"
                        + "\nSET contador = " + 0
                        + "\nWHERE numero_cuenta = " + cuenta_6);

                JOptionPane.showMessageDialog(null, "GRACIAS POR USAR NUESTROS SERVICIOS");
                Inicio backsito = new Inicio();

                break;

            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            try {
                comando.close();
                conexion.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Por favor encienda la base de datos", e.getMessage(), JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void recibo(int cuenta_7, int valor_5) {
        Date fecha = new Date();
        String puta="";
        tabla = "cuenta";

        MySQLConnect();

        try {
            String Query = "SELECT saldo FROM " + tabla + " WHERE numero_cuenta = " + cuenta_7;
            comando = conexion.createStatement();
            registro = comando.executeQuery(Query);

            while (registro.next()) {
                
                
                if (valor_5 <= registro.getInt("saldo")) {
                    int resp = JOptionPane.showConfirmDialog(null, "¿Desea un recibo?", "Recibo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (resp == JOptionPane.YES_NO_OPTION) {

                        JOptionPane.showMessageDialog(null, " GRACIAS POR USAR NUESTROS SERVICIOS " + "\n Numero de cuenta: " + cuenta_7 + "\n Monto retirado: " + valor_5 + "\n" + fecha  );
                        Inicio backsito = new Inicio();
                        break;

                    }

                    if (resp == JOptionPane.NO_OPTION) {

                        Inicio backsito = new Inicio();

                        break;

                    }
                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "por favor encienda la base de datos");
        } finally {
            try {
                comando.close();
                conexion.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Por favor encienda la base de datos", e.getMessage(), JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }
    

}
