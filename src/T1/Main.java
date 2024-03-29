package T1;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.FileNotFoundException;
import java.io.IOException;



public class Main {

    public static void main(String[] args) {

        Transicao t1 = new Transicao();
        Scanner regras = new Scanner(System.in);
        //System.out.println("Informe o endereço das regras: ");
        String caminho = "rules.afd";
        Integer EstadoInicial = 0;
        ArrayList<Integer> ef = new ArrayList();

        try{
            FileReader arquivo = new FileReader(caminho);
            BufferedReader lerArquivo = new BufferedReader(arquivo);

            String QtdEstados = lerArquivo.readLine();
            System.out.println("primeira linha " + QtdEstados);
            EstadoInicial = Character.getNumericValue(QtdEstados.charAt(0));
            System.out.println("estado inicial " + EstadoInicial);
            String EstadoFinal = lerArquivo.readLine();
            System.out.println("Estado final " + EstadoFinal);
            ArrayList<Integer> EstadoFinalArray = new ArrayList();

            for(char Lista : EstadoFinal.toCharArray()){
                if (Lista != ' ' ) {
                  EstadoFinalArray.add(Character.getNumericValue(Lista));
                }
            }


            ef = EstadoFinalArray;

            while (EstadoFinal != null) {
                EstadoFinal = lerArquivo.readLine();
                System.out.println("sequência " + EstadoFinal);
                if(EstadoFinal != null){
                    Integer p1 = Character.getNumericValue(EstadoFinal.charAt(0));
                    Integer p3 = Character.getNumericValue(EstadoFinal.charAt(4));
                    t1.setTransicao(p1,p3,EstadoFinal.charAt(2));
                    System.out.println(p1 + " " + EstadoFinal.charAt(2) + " " + p3);
                    System.out.println(EstadoFinal);
                }
                System.out.println(EstadoFinal);
            }
            arquivo.close();
        }
        catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println();

        AFD a1 = new AFD(t1,EstadoInicial,ef);

        Scanner imput = new Scanner(System.in);
        //System.out.println("Informe o endereço do imput: ");
        String endereco = "imput.txt";

        try{
            FileReader arquivo = new FileReader(endereco);
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String palavra = " ";
            boolean teste = true;
            while (palavra != null) {
                palavra = lerArquivo.readLine();
                //System.out.println(palavra);
                if (palavra != null) {
                    teste = a1.validacao(palavra);
                }
                if(teste && palavra != null){
                    System.out.println(palavra + " Palavra Aceita");
                }
                else{
                    System.out.println(palavra + " Palavra Rejeitada");
                }
            }
            arquivo.close();
        }
        catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        System.out.println();




    }
}
