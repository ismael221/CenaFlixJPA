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
 *
 * @author Usuario
 */
public class loginDAO {
    public static Login validarUsuario(Login usuario) {
                   
                //Login usuarioEncontrado = null;
                EntityManager em = JPAUtil.getEntityManager();
                TypedQuery<Login> consulta = em.createQuery("SELECT u FROM Login u WHERE u.usuario = :usuario AND u.senha = :senha ", Login.class);
                consulta.setParameter("usuario", usuario.getUsuario());
                consulta.setParameter("senha",usuario.getSenha());
                Login item = consulta.getSingleResult();
   
                return item;
                }    
                      
}
