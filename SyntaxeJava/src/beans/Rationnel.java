package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ludivine
 */
public class Rationnel {
     private int d;
     private int n;
     
     public Rationnel(){
         this.d = 0;
         this.n = 0;
     }
    public Rationnel(int d, int n){
         this.d = n;
         this.n = n;
         this.d = this.d < 0 ? -this.d : this.d;
     }
    
    // conversion de l'ogjet en string
    // par défaut l'adresse de l'object
    public String toString(){
        return this.n + "/" + this.d;
    }
}
