/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import jakarta.persistence.EntityManager;
import spring.cenaflixjpa.Podcast;

/**
 * Classe responsavel por realizar a conexão com o banco de dados para inserir o objeto da classe Podcast
 * @author ismael221
 */
public class PodcastDAO {
       
       /**
        * Metodo que insere o registro no banco de dados recebendo como parametro um objeto da class Podcast
        * @param podcast 
        */
       public void cadastrar(Podcast podcast){
          EntityManager em = JPAUtil.getEntityManager();
          try {
              em.getTransaction().begin();
              em.persist(podcast);
              em.getTransaction().commit();
          }catch(Exception e){
              em.getTransaction().rollback();
              throw e;
          }
          finally{
              JPAUtil.closeEtityManager();
          }
      }
}
