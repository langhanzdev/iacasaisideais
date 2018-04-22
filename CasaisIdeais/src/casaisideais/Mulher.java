/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaisideais;

/**
 *
 * @author langhanz
 */
public class Mulher {
    
    private int id;
    private int preferencia1;
    private int preferencia2;
    private int preferencia3;

    public Mulher(int id, int preferencia1, int preferencia2, int preferencia3) {
        this.id = id;
        this.preferencia1 = preferencia1;
        this.preferencia2 = preferencia2;
        this.preferencia3 = preferencia3;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreferencia1() {
        return preferencia1;
    }

    public void setPreferencia1(int preferencia1) {
        this.preferencia1 = preferencia1;
    }

    public int getPreferencia2() {
        return preferencia2;
    }

    public void setPreferencia2(int preferencia2) {
        this.preferencia2 = preferencia2;
    }

    public int getPreferencia3() {
        return preferencia3;
    }

    public void setPreferencia3(int preferencia3) {
        this.preferencia3 = preferencia3;
    }

    @Override
    public String toString() {
        return "Mulher{" + "id=" + id + ", preferencia1=" + preferencia1 + ", preferencia2=" + preferencia2 + ", preferencia3=" + preferencia3 + '}';
    }
    
    
    
}
