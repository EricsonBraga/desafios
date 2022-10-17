
import java.util.Scanner;

public class TesteString {

    public static void main(String[] args) {

        String palavra;
        int tamanho, cont = 0, cont2 = 1;
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite uma palavra:");
        palavra = sc.next();
        tamanho = palavra.length();

        char [] vetor = new char[tamanho]; //armazena os caracteres de uma palavra
        char [] aux = new char[tamanho]; //armazena as letras já percorridas
        int [] quantidade = new int[tamanho]; //armazena o número de vezes que uma letra se repete

        //preenche um vetor com os caracteres da palavra recebida
        for (int i = 0; i < tamanho; i++){
            vetor[i] = palavra.charAt(i);
        }

        /*a letra de uma posição do vetor[] será comparada com as posições seguintes,
        * mas antes deve-se verificar se a letra já foi contabilizada ou não,
        * para isso utilizou-se um vetor aux[], para receber as letras já percorridas e fazer a verificação
        * Ao final do laço for, se a letra não tiver sido contada ainda, é armazenada no vetor aux[]
        * e o cont2 é incrementado e armazendo no vetor quantiddade[].
        * Se a letra já tiver sido contada retorna-se o loop e faz-se a verificação da letra seguinte.*/
        for(int i = 0; i < tamanho; i++){
            char letra = vetor[i];

            for(int j = 0; j < tamanho; j++){
                if(letra == aux[j]){
                    cont++;
                }
            }

            if(cont == 0){
                for(int k = i+1; k<tamanho; k++){
                    if(letra == vetor[k]){
                        cont2++  ;
                    }
                }
                aux[i] = letra;
                quantidade[i] = cont2;
            }

            cont = 0;
            cont2 = 1;

        }

        //Ordena o vetor quantidade[] em ordem decrescente
        for(int i =1; i < tamanho; i++){
            for(int j = 0; j < tamanho; j++){
                if(quantidade[i] > quantidade[j]){
                    int temp = quantidade[i];
                    quantidade[i] = quantidade[j];
                    quantidade[j] = temp;
                }
            }
        }

        //verifica a quantidade de posições com o número zero
        int cont3 = 0;
        for(int i = 0; i < tamanho; i++){
            if(quantidade[i] == 0){
                cont3++;
            }
        }

        //imprime o vetor sem as posições vazias
        System.out.print("{");
        for(int i = 0; i < tamanho-cont3; i++) {
            System.out.print(quantidade[i] + ", ");
        }
        System.out.print("}");




    }



}

