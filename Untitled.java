Esse trabalho tem como implementação um algoritmo que simula um AFD (Autômato Finito Determinístico) onde sua entrada consiste respectivamente :
- Estados do autômato separados por um espaço: Ex: 0 1 
- Os caracteres referentes ao alfabeto separados por um espaço: Ex: a b
- A quantidade de transições presente no autômato:  Ex: 3
- O estado atual o caractere a ser consumido e o estado de destino presentes <o,c,d>
ex: 0 a 1 
    1 a 1
    1 b 1
- Os estados Iniciais. Ex: 0
- Os estados Finais. Ex: 1
- O conjunto de palavras a ser verificada pelo autômato, separados por um espaço entre elas Ex: a aaa ababa bbbba ababa b

A saída do sistema é indicado um N para caso a palavra não seja reconhecida e S caso ela seja reconhecida 
ex:

S
S
S
N
S

Nessa parte do algoritmo estão declaradas as variáveis que serão usadas ao decorrer do algoritmo, aqui são inseridos como entrada os estados, os caracteres e a quantidade de transição do autômato. 
        HashMap<String, String> dicionario= new HashMap <>();
        HashMap<String, Integer> finais= new HashMap <>();
        
        Scanner e= new Scanner (System.in);
         
        String[]  ocd;
        String tripla;
        String estados;
        String alfabeto;
        String estado_inicial;
        String estado_final;
        String[] estados_finais;
        String[] palavras;
        String estado_atual;
        int t,z,y=0, n;
        boolean contem;
        estados=e.nextLine();
        alfabeto=e.nextLine();
        t=Integer.parseInt(e.nextLine());
Nessa parte do código  tem como entrada  <o,c,d>  referentes ao estado de origem, o caractere a ser consumido e o estado de destino, esses valores estão sendo armazenados em uma HashMap chamada dicionario e são inseridos de acordo a quantidade de transições que o autômato possui. 
while(y<t){
        z=0;            
        tripla=e.nextLine();
        ocd=tripla.split(" ");
        dicionario.put(ocd[z].concat(ocd[z+1]), ocd[z+2]);
        
            y++;
        }
  
Essa parte do código é referente a entrada do estado inicial, dos estados finais, e das palavras a serem consumidas pelo autômato, os estados finais também é colocado em uma HashMap com nomes finais. 
 estado_inicial=e.nextLine();
       estado_final=e.nextLine();
       estados_finais=estado_final.split(" ");
       
       for(int i=0;i<estados_finais.length;i++){
           finais.put(estados_finais[i], i);
       }
           
      String palavra;

 palavra=e.nextLine();
 palavras=palavra.split(" ");
Nessa parte do código é feita a verificação da palavra, onde o algoritimo tem sua complexidade O(n) percorrendo caractere por caractere até terminar a palavra, n será o tamanho da palavra. Quando o algoritimo termina a palavra, ele verifica se aquele estado  está no hasmap de estados finais, onde a complexidade é O(1). Tanto a a busca do estado final como a busca do estado atual com o caractere possui a complexidade O(1). 
for(int j=0;j<palavras.length;j++){  // esse for é apenas para pegar a palavra 
 estado_atual=estado_inicial;  
 contem=true;
 n=palavras[j].length();
//  aqui onde confere se a palavra faz parte do automato  --------------------------------------------------------------------
 for(int i=0;i<n;i++){
     estado_atual=estado_atual.concat(palavras[j].substring(i, i+1));
     
     if (dicionario.containsKey(estado_atual)){  // custo o(1) ultiliza a tabela map do dicionario para verificar 
       
         estado_atual=(String)dicionario.get(estado_atual);
         }else {
       
             contem=false;
         
             }
       
           }
     if(finais.containsKey(estado_atual) &&( contem=true)){ // custo O(1) ultiliza a tabela map com os valores finais  para verificar
     System.out.println("S");
     
   }else {
          System.out.println("N");
     }
          
 }
 



