/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaisideais;

import java.util.Random;

/**
 *
 * @author langhanz
 */
public class Elemento {
    
    private boolean isHomem;
    private boolean isMulher;
    private boolean isParede;
    private boolean isCartorio;
    
    private int id;
    private int preferencia1;
    private int preferencia2;
    private int preferencia3;
    
    private int x;
    private int y;
    
    private int direcao;

    public Elemento(boolean isHomem, boolean isMulher, boolean isParede, boolean isCartorio, int id, int preferencia1, int preferencia2, int preferencia3) {
        Random ran = new Random();
        this.isHomem = isHomem;
        this.isMulher = isMulher;
        this.isParede = isParede;
        this.isCartorio = isCartorio;
        this.id = id;
        this.preferencia1 = preferencia1;
        this.preferencia2 = preferencia2;
        this.preferencia3 = preferencia3;
        this.direcao = ran.nextInt(4);
    }

    public Elemento(boolean isHomem, boolean isMulher, boolean isParede, boolean isCartorio, int id, int preferencia1, int preferencia2, int preferencia3, int x, int y) {
        Random ran = new Random();
        this.isHomem = isHomem;
        this.isMulher = isMulher;
        this.isParede = isParede;
        this.isCartorio = isCartorio;
        this.id = id;
        this.preferencia1 = preferencia1;
        this.preferencia2 = preferencia2;
        this.preferencia3 = preferencia3;
        this.x = x;
        this.y = y;
        this.direcao = ran.nextInt(4);
    }

    public int getDirecao() {
        return direcao;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isCartorio() {
        return isCartorio;
    }

    public void setIsCartorio(boolean isCartorio) {
        this.isCartorio = isCartorio;
    }

    public boolean isHomem() {
        return isHomem;
    }

    public void setIsHomem(boolean isHomem) {
        this.isHomem = isHomem;
    }

    public boolean isMulher() {
        return isMulher;
    }

    public void setIsMulher(boolean isMulher) {
        this.isMulher = isMulher;
    }

    public boolean isParede() {
        return isParede;
    }

    public void setIsParede(boolean isParede) {
        this.isParede = isParede;
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
        return "Elemento{" + "isHomem=" + isHomem + ", isMulher=" + isMulher + ", isParede=" + isParede + ", isCartorio=" + isCartorio + ", id=" + id + ", preferencia1=" + preferencia1 + ", preferencia2=" + preferencia2 + ", preferencia3=" + preferencia3 + '}';
    }
    
    
    
    
}
