/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package spring.cenaflixjpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import view.login;
/**
 * Classe main do projeto que faz a instanciação da classe login
 * @author ismael221
 */
public class CenaFlixJPA {

    public static void main(String[] args) {
       
    login login = new login();
    login.setVisible(true);
    }
}
