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

/**
 *
 * @author langhanz
 */
public class CasaisIdeais { 
    
    private ArrayList<Homem> listaHomens = new ArrayList<>();
    private ArrayList<Mulher> listaMulheres = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CasaisIdeais c = new CasaisIdeais();
        c.leArquivo();
    }
    
    public void leArquivo() {
        System.out.printf("\nConteúdo do arquivo texto:\n");
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
            System.out.println(sQtdCasais+"\n");
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
                
                
                listaHomens.add(new Homem(id, pr, seg, ter));

                
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
                
                
                listaMulheres.add(new Mulher(id, pr, seg, ter));

                
                linha = lerArq.readLine(); 
            }
            
            
//            while (linha != null) {
//                System.out.printf("%s\n", linha);
//
//                linha = lerArq.readLine(); // lê da segunda até a última linha
//            }
            
            System.out.println(listaHomens.toString());
            System.out.println(listaMulheres.toString());

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }
    
}
