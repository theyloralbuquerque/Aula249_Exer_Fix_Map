package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // Lembrando que os tipos primitivos e Wrapper classes já vem com o hashCode e equals implementados.
        Map<String, Integer> votos = new TreeMap<>(); // votos é um Map utilizando o TrreMap<>(). (mais lento, mas ordena)

        System.out.print("Digite o caminho completo do arquivo: ");
        String caminho = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) { // br recebe o conteúdo do arquivo. 
            
            String linha = br.readLine(); // Lê uma linha de br.
           
            while (linha != null) {
                
            	String[] campo = linha.split(","); // campo é um vetor de Strings que recebe a separação da String linha. 
                String nome = campo[0]; // nome recebe a primeira parte da String linha.
                Integer cont = Integer.parseInt(campo[1]); // cont recebe a psegunda parte da String linha convertida em Integer.
                
                if (votos.containsKey(nome)) { // .constainsKeey(chave do elemnto map) verifica se tem uma chave com valor de nome a coleção.
                	Integer votosAteAgora = votos.get(nome); // .get(nome) chama o valor da chave passada como argumento.
                	votos.put(nome, cont + votosAteAgora);// .put(key, value) adiciona um par chave-valor ao map.
                }
                else {
                	votos.put(nome, cont);
                }                

                linha = br.readLine();
            }

            for (String key : votos.keySet()) {
                System.out.println(key + ": " + votos.get(key));
            }

        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        sc.close();
    }
}