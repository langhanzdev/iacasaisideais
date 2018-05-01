/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaisideais;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author langhanz
 */
public class CasaisIdeais { 
    
    public static ArrayList<Elemento> listaElementos = new ArrayList<>();
    public static int n = 10;
    private int qtdHomens;
    private int qtdMulheres;
    private int qtdCartorios;
    private int qtdParedes;
    public static int[][] matriz = new int[n][n];
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        CasaisIdeais c = new CasaisIdeais();
        c.iniciaMatriz();
        c.geraParedes();
        c.leArquivo();
        c.geraCartorios();
        
        for(int i=0;i<15;i++){
            
//            c.desenhaMatriz();
            for(Elemento e:listaElementos){
                e.executa();
            }
            c.desenhaAmbiente();
            //c.andaAgente();
            Thread.sleep(500);
        }
        
    }
    
    public void iniciaMatriz(){
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                matriz[i][j] = -1;
    }
    
    public void desenhaMatriz(){
        for(int i=0;i<this.n;i++){
            for(int z=0;z<this.n;z++){
                System.out.print("["+matriz[z][i]+"]");
            }
            System.out.println();
        }
    }
    
    public void desenhaAmbiente(){
        Elemento e;
        for(int y=0;y<this.n;y++){
            for(int x=0;x<this.n;x++){
                e = temElemento(x,y);
                if(e != null){
                    if(e.isHomem()){
                        System.out.print("[H"+e.getId()+"]");
                    }else
                        if(e.isMulher()){
                            System.out.print("[M"+e.getId()+"]");
                        }else
                            if(e.isParede()){
                                System.out.print("[##]");
                            }else
                                if(e.isCartorio()){
                                    System.out.print("[C ]");
                                }
                }else
                System.out.print("[  ]");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------");
    }
    
    public Elemento temElemento(int x, int y){
        Elemento aux;
        for(int i=0;i<listaElementos.size();i++){
            aux  = listaElementos.get(i);
            if(aux.getX() == x && aux.getY() == y){
                return aux;
            }
        }
        return null;
    }
    
    public boolean isParede(int x, int y){
        Elemento aux;
        for(int i=0;i<listaElementos.size();i++){
            aux  = listaElementos.get(i);
            if(aux.getX() == x && aux.getY() == y && aux.isParede()){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isLivre(int x, int y){
        Elemento aux;
        for(int i=0;i<listaElementos.size();i++){
            aux  = listaElementos.get(i);
            if(aux.getX() == x && aux.getY() == y){
                return false;
            }
        }
        if(x < 0 || y < 0 || x >= n || y >= n)
            return false;
        return true;
    }
    
    public void geraParedes(){
        
        int tamanhoParede;
        int idParede = 0;
        int quantidadeParede = (int) this.n/5;
        this.qtdParedes = quantidadeParede;
        ArrayList<Integer> sementesX = new ArrayList<>();
        int sementex = 0;
        int sementey;
        boolean perto;
        int particao =  this.n/(quantidadeParede+1);
        Random ran = new Random();
        
        for(int a=0;a<quantidadeParede;a++){
            
            do{
                perto = true;
                tamanhoParede = (this.n/2)+1;
                sementex = (int) (sementex+(particao)-ran.nextInt(2));//(int) (Math.random()*this.n);
                sementey = (int) (Math.random()*((this.n/2)-1));
                if(sementey < 2) sementey += 2;
                if(sementey+tamanhoParede >= this.n) sementey -= 2;
                
                for(Integer p:sementesX){
                    if((p-sementex < particao && p-sementex > particao-(2*particao)) ){ //|| p < 3 || this.n-p > 3
                        perto = false;
                        break;
                        
                    }
                }
                
                
            }while(/*((sementex+tamanhoParede) > this.n) || */!perto);
            sementesX.add(sementex);
            for(int i=0;i<tamanhoParede;i++){
                listaElementos.add(new Elemento(false, false, true, false, idParede, 0, 0, 0, sementex, sementey));
                matriz[sementex][sementey] = listaElementos.size()-1;
                sementey++;
            }
            idParede++;
        }
        
        
    }
    
    
    public void geraCartorios(){
        int y;
        Random ran = new Random();
        int x = 0;
        int p = 0;
        int pid = 0;
        Elemento aux;
        ArrayList<Elemento> lstAux = new ArrayList<>();
        for(int i=0;i<this.qtdCartorios;i++){
//            for(Elemento aux:this.listaElementos){
            for(int b=p;b<this.listaElementos.size();b++){
                aux = this.listaElementos.get(b);
                if(aux.isParede() && pid != aux.getId()){
                    pid = aux.getId();
                    do{
                        y = ran.nextInt(this.n);
                        if(ran.nextInt(2) == 1) x = aux.getX()-1; else x = aux.getX()+1;
                        
                    }while(!isLivre(x, y) || y < aux.getY() || (y > aux.getY()+((this.n/2)+1)));
                    lstAux.add(new Elemento(false, false, false, true, 0, 0, 0, 0, x, y));
                    
                    break;
                }
                p=b;
            }
            
            
        }
        
        for(int a=0;a<lstAux.size();a++){
            this.listaElementos.add(lstAux.get(a));
            matriz[lstAux.get(a).getX()][lstAux.get(a).getY()] = listaElementos.size()-1;
        }
    }
    
    
    public void andaAgente3(){
        Elemento agente;
        for(int i=0;i<this.listaElementos.size();i++){
            agente = this.listaElementos.get(i);
            if(agente.isHomem() || agente.isMulher()){
                
                switch(agente.getDirecao()){
                    case 0:
                        if(isLivre(agente.getX(), agente.getY()+1)){
                            this.listaElementos.get(i).setY(agente.getY()+1);
                        }else{
                            this.listaElementos.get(i).setDirecao(somaDirecao(agente.getDirecao()));
                        }
                        break;
                    case 1:
                        if(isLivre(agente.getX()+1, agente.getY())){
                            this.listaElementos.get(i).setX(agente.getX()+1);
                        }else{
                            this.listaElementos.get(i).setDirecao(somaDirecao(agente.getDirecao()));
                        }
                        break;
                    case 2:
                        if(isLivre(agente.getX(), agente.getY()-1)){
                            this.listaElementos.get(i).setY(agente.getY()-1);
                        }else{
                            this.listaElementos.get(i).setDirecao(somaDirecao(agente.getDirecao()));
                        }
                        break;
                    case 3:
                        if(isLivre(agente.getX()-1, agente.getY())){
                            this.listaElementos.get(i).setX(agente.getX()-1);
                        }else{
                            this.listaElementos.get(i).setDirecao(somaDirecao(agente.getDirecao()));
                        }
                        break;
                }
            }
        }
    }
    
    public int somaDirecao(int d){
        Random ran = new Random();
        return ran.nextInt(4);
//        if(d == 3) return 0;
//        else return d+1;
    }
    
    
    
    
    
    public void leArquivo() {
        ///System.out.printf("\nConteúdo do arquivo texto:\n");
        
        try {
            FileReader arq = new FileReader("entrada.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
            int p = 0;
            String sQtdCasais = "0";
            String sQtdCartorios = "0";
           
            while(linha.charAt(p) != ' '){
                sQtdCasais += linha.charAt(p)+"";
                
                p++;
            }
            //System.out.println(sQtdCasais+"\n");
            int qtdCasais = Integer.parseInt(sQtdCasais);
            p++;
            while(p < linha.length()){
                sQtdCartorios += linha.charAt(p)+"";
                p++;
                
            }
            
            linha = lerArq.readLine(); 
            
            this.qtdCartorios = Integer.parseInt(sQtdCartorios);
            this.qtdHomens = qtdCasais;
            this.qtdMulheres = qtdCasais;
            System.out.println("Casais "+qtdCasais+" Cartorios "+this.qtdCartorios+"\n");
            
            int id, pr,seg,ter;
            String aux = "0";
            
            /* Carrega homens */
            for(int i=0;i<qtdCasais;i++){
                p=0;
                
                /* Pega id */
                while(linha.charAt(p) != ' '){
                    aux += linha.charAt(p)+"";
                    p++;
                }
                id = Integer.parseInt(aux);
                p++;aux="0";
                
                /* Pega preferencia 1 */
                while(linha.charAt(p) != ' '){
                    aux += linha.charAt(p)+"";
                    p++;
                }
                pr = Integer.parseInt(aux);
                p++;aux="0";
                
                /* Pega preferencia 2 */
                while(linha.charAt(p) != ' '){
                    aux += linha.charAt(p)+"";
                    p++;
                }
                seg = Integer.parseInt(aux);
                p++;aux="0";
                
                /* Pega preferencia 3 */
                while(p < linha.length()){
                    aux += linha.charAt(p)+"";
                    p++;
                }
                ter = Integer.parseInt(aux);
                p++;aux="0";
                
                int ax,ay;
                do{
                    ax = (int) (Math.random()*this.n);
                    ay = (int) (Math.random()*this.n);
                    
                }while(!isLivre(ax, ay));
                
                listaElementos.add(new Elemento(true, false, false, false, id, pr, seg, ter,ax,ay));
                matriz[ax][ay] = listaElementos.size()-1;
                
                linha = lerArq.readLine(); 
            }
            
            /* Carrega mulheres */
            while(linha != null){
                p=0;
                
                /* Pega id */
                while(linha.charAt(p) != ' '){
                    aux += linha.charAt(p)+"";
                    p++;
                }
                id = Integer.parseInt(aux);
                p++;aux="0";
                
                /* Pega preferencia 1 */
                while(linha.charAt(p) != ' '){
                    aux += linha.charAt(p)+"";
                    p++;
                }
                pr = Integer.parseInt(aux);
                p++;aux="0";
                
                /* Pega preferencia 2 */
                while(linha.charAt(p) != ' '){
                    aux += linha.charAt(p)+"";
                    p++;
                }
                seg = Integer.parseInt(aux);
                p++;aux="0";
                
                /* Pega preferencia 3 */
                while(p < linha.length()){
                    aux += linha.charAt(p)+"";
                    p++;
                }
                ter = Integer.parseInt(aux);
                p++;aux="0";
                
                int ax,ay;
                do{
                    ax = (int) (Math.random()*this.n);
                    ay = (int) (Math.random()*this.n);
                    
                }while(!isLivre(ax, ay));
                
                listaElementos.add(new Elemento(false, true, false,false, id, pr, seg, ter,ax,ay));
                matriz[ax][ay] = listaElementos.size()-1;
                
                linha = lerArq.readLine(); 
            }
            
            
//            while (linha != null) {
//                System.out.printf("%s\n", linha);
//
//                linha = lerArq.readLine(); // lê da segunda até a última linha
//            }
            
//            System.out.println(listaElementos.toString());
            

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }
    
}
