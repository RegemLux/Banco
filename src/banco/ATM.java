/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

public class ATM {
    
    public static int cupo=500;
    public static int billete_200=1;
    public static int billete_100=1;
    public static int billete_60=1;
    public static int billete_40=2;
    public static int billete_20=3;
    
    
    public ATM(){
        this.cupo=cupo;
    }
    
    public void setCupo(int cupo){
        this.cupo=cupo;
    }
    
    public int getCupo(){
        return cupo;
    }
    
    public void set200(int billete_200){
        this.billete_200=billete_200;
    }
    
    public int get200(){
        return billete_200;
    }
    
    public void set100(int billete_100){
        this.billete_100=billete_100;
    }
    
    public int get100(){
        return billete_100;
    }
    
    public void set60(int billete_60){
        this.billete_60=billete_60;
    }
    
    public int get60(){
        return billete_60;
    }
    
    public void set40(int billete_40){
        this.billete_40=billete_40;
    }
    
    public int get40(){
        return billete_40;
    }
    
    public void set20(int billete_20){
        this.billete_20=billete_20;
    }
    
    public int get20(){
        return billete_20;
    }
    
}
