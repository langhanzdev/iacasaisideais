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
    private boolean solteiro;
    private Elemento conjuje;

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
        this.solteiro = true;
        this.conjuje = null;
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
        this.solteiro = true;
        this.conjuje = null;
    }

    public Elemento getConjuje() {
        return conjuje;
    }

    public void setConjuje(Elemento conjuje) {
        this.conjuje = conjuje;
    }
    

    public boolean isSolteiro() {
        return solteiro;
    }

    public void setSolteiro(boolean solteiro) {
        this.solteiro = solteiro;
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
        return "Elemento{" + "isHomem=" + isHomem + ", isMulher=" + isMulher + ", isParede=" + isParede + ", isCartorio=" + isCartorio + ", id=" + id + ", preferencia1=" + preferencia1 + ", preferencia2=" + preferencia2 + ", preferencia3=" + preferencia3 + ", x=" + x + ", y=" + y + ", direcao=" + direcao + ", solteiro=" + solteiro + ", conjuje=" + conjuje + '}';
    }
    
    public void executa(){
        anda();
        encontraAgente();
    }

    
    public void anda(){
        
        if(isHomem() || isMulher()){

            switch(getDirecao()){
                case 0:
                    if(CasaisIdeais.isLivre(getX(), getY()+1)){
                        
                        CasaisIdeais.matriz[getX()][getY()+1] = CasaisIdeais.matriz[getX()][getY()];
                        CasaisIdeais.matriz[getX()][getY()] = -1;
                        setY(getY()+1);
                    }else{
                        setDirecao(somaDirecao(getDirecao()));
                    }
                    break;
                case 1:
                    if(CasaisIdeais.isLivre(getX()+1, getY())){
                        
                        CasaisIdeais.matriz[getX()+1][getY()] = CasaisIdeais.matriz[getX()][getY()];
                        CasaisIdeais.matriz[getX()][getY()] = -1;
                        setX(getX()+1);
                    }else{
                        setDirecao(somaDirecao(getDirecao()));
                    }
                    break;
                case 2:
                    if(CasaisIdeais.isLivre(getX(), getY()-1)){
                        
                        CasaisIdeais.matriz[getX()][getY()-1] = CasaisIdeais.matriz[getX()][getY()];
                        CasaisIdeais.matriz[getX()][getY()] = -1;
                        setY(getY()-1);
                    }else{
                        setDirecao(somaDirecao(getDirecao()));
                    }
                    break;
                case 3:
                    if(CasaisIdeais.isLivre(getX()-1, getY())){
                        
                        CasaisIdeais.matriz[getX()-1][getY()] = CasaisIdeais.matriz[getX()][getY()];
                        CasaisIdeais.matriz[getX()][getY()] = -1;
                        setX(getX()-1);
                    }else{
                        setDirecao(somaDirecao(getDirecao()));
                    }
                    break;
            }
        }
    }
    

    public int somaDirecao(int d){
        Random ran = new Random();
        return ran.nextInt(4);
    }
    
    
    public void encontraAgente(){
//        int px,py;
               
        if(isHomem()){
            
            int xx = 0;
            int yy = 0;
            int e = -1;
            Elemento b = null;
            for(int px=1;px<2 && px>-2;px--){
                for(int py=1;py<2 && py>-2;py--){
                    if(!(px==0 && py==0)){
                        if(getX()-px < 0 || getY()-py < 0 || getX()-px >= CasaisIdeais.n || getY()-py >= CasaisIdeais.n) continue;
                        e = CasaisIdeais.matriz[getX()-px][getY()-py];
                        xx = getX()-px;
                        yy =getY()-py;
                                
                        if(e != -1){
                            b = CasaisIdeais.listaElementos.get(e);
                            if(b.isHomem() || b.isMulher())
                            if(isSolteiro()){ //Solteiro
                                System.out.println("CASAMENTO "+id+" e "+b.getId());
                                if(proposta(id)){
                                    conjuje = b;
                                    setSolteiro(false);
                                    CasaisIdeais.listaElementos.get(e).setConjuje(this);
                                    CasaisIdeais.listaElementos.get(e).setSolteiro(false);
                                }
                            }else{ //Casado
                                if(b.getId() == preferencia1 && ((b.isMulher && isHomem()) || (b.isHomem() && isMulher()))){
                                    if(b.proposta(id)){
                                        //vao ao cartorio
                                        System.out.println("VAO AO CARTORIO "+id+" e "+b.getId());
                                    }else{
                                        //nao se casam, segue o jogo
                                        System.out.println("Segue o jogo."+id+" e "+b.getId());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
                        
        }
        
        
        
    }
    
    public boolean proposta(int id){
        
        if(isSolteiro()) return true;
        else{
            if(conjuje.id == preferencia1) return false;
            if(preferencia1 == id) return true;
            else{
                if(conjuje.id == preferencia2) return false;
                if(id == preferencia2) return true;
                else{
                    if(conjuje.id == preferencia3) return false;
                    if(id == preferencia3) return true;
                }
            }
        }
        return false;
    }
    
    
    
    
}
