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
    
    private ArrayList<Elemento> listaElementos = new ArrayList<>();
    private int n = 20;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CasaisIdeais c = new CasaisIdeais();
        c.leArquivo();
        c.geraParedes();
        c.desenhaAmbiente();
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
                                    System.out.println("[C"+e.getId()+"]");
                                }
                }else
                System.out.print("[  ]");
            }
            System.out.println();
        }
        
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
    
    public void geraParedes(){
        
        int tamanhoParede;
        int quantidadeParede = (int) this.n/5;
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
                listaElementos.add(new Elemento(false, false, true, false, i, 0, 0, 0, sementex, sementey));
                sementey++;
            }
        }
        
        
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
            int qtdCartorios = Integer.parseInt(sQtdCartorios);
            System.out.println("Casais "+qtdCasais+" Cartorios "+qtdCartorios+"\n");
            
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
                
                
                listaElementos.add(new Elemento(true, false, false, false, id, pr, seg, ter,(int) (Math.random()*this.n),(int) (Math.random()*this.n)));

                
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
                
                
                listaElementos.add(new Elemento(false, true, false,false, id, pr, seg, ter,(int) (Math.random()*this.n),(int) (Math.random()*this.n)));

                
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
