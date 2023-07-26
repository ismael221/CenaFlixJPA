/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import spring.cenaflixjpa.Login;


/**
 * Classe responsavel por fazer a conexão com o banco de dados e validar objeto da classe Login
 * @author ismael221
 */
public class loginDAO {
    
    /**
     * 
     * Metodo que recebe como parametro um objeto do tipo Login e tem como retorno 
     * um unico objeto do mesmo tipo
     * @param usuario
     * @return 
     */
    public static Login validarUsuario(Login usuario) {

        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Login> consulta = em.createQuery("SELECT u FROM Login u WHERE u.usuario = :usuario AND u.senha = :senha ", Login.class);
        consulta.setParameter("usuario", usuario.getUsuario());
        consulta.setParameter("senha",usuario.getSenha());
        Login item = consulta.getSingleResult();
   
            return item;
    }       
}
