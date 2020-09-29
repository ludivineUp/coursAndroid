/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syntaxejava;

import beans.Rationnel;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author ludivine
 */
public class SyntaxeJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 0;
        double x = 3.14;
        boolean b = true;
        Integer n1 = 0; // wrapper
        ArrayList<Integer> tab = new ArrayList<>(); 
        /*
            Langage fortement typé : la langage impose de donner le type de la variable
            avant de la déclarer => pas permissif mais c'est plus rapide et plus sûr que les langages non typés
            <> : généricité, on va type un type d'objet
        */
        Scanner scanner = new Scanner(System.in);   // deguelasse : saisie clavier
        //int ex = scanner.nextInt();
        for (int i = 0; i < 10; i++) {
            tab.add(i);
        }
        for(int element : tab){ //foreach
            System.out.println(element);
        }
        // modifier un élément
        tab.set(2, 5);
        for(int element : tab){ // foreach est uniquement en lecture
            System.out.println(element); // deguelasse : afficha console, pas à retenir
        }
        tab.forEach(System.out::print);
        // on récupère le premier élément
        int unElement = tab.get(0);
        
        System.out.println("");
        List<Integer> pair = tab.stream().filter(e -> e%2 == 0).collect(Collectors.toList());
        
        Integer unPair = tab.stream().filter(e -> e >100).findAny().orElse(null);
        System.out.println(unPair);
        
        // consturire une liste qui contient les doubles de tous les lement de tab
        // .forEach est uniquement en lecture
        List<Integer> doubles = tab.stream().map(e -> e * 2).collect(Collectors.toList());
        for (Integer aDouble : doubles) {
            System.out.print(aDouble + " - ");
        }
        Rationnel  r = new Rationnel(1,3);
        System.out.println("\n"+r);
    }
    
}
