package banco;

public class Cliente {
    
    private static int nip;
    private static int cuenta;
    private static int cuenta_externa;
    private static String nombre;
    private static String apellido;
    
    public Cliente(){
        this.nip=nip;
        this.cuenta=cuenta;
        this.cuenta_externa=cuenta_externa;
    }
    
    public void setCuenta(int cuenta)
    {
        this.cuenta=cuenta;
    }
    
    public int getCuenta()
    {
        return cuenta;
    }
    
    public void setCuentaEx(int cuenta_externa)
    {
        this.cuenta_externa=cuenta_externa;
    }
    
    public int getCuentaEx()
    {
        return cuenta_externa;
    }
    
    public void setNIP(int nip)
    {
        this.nip=nip;
    }
    
    public int getNIP()
    {
        return nip;
    }
    
    
    public void setNombre(String Nombre)
    {
        this.nombre=Nombre;
    }
    public String getNombre()
    {
        return nombre;
    }
   
}
