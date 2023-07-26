/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import spring.cenaflixjpa.Podcast;

/**
 * Classe responsavel pela conexão do banco de dados realizando a listagem e exclusão
 * 
 * @author ismael221
 */
public class listagemDAO {
    
    public List<Podcast> listar(){
       EntityManager em = JPAUtil.getEntityManager();
       try{
           Query consulta = em.createQuery("SELECT pd FROM Podcast pd");
           List<Podcast> podcasts = consulta.getResultList();
           return podcasts;
       }finally{
           JPAUtil.closeEtityManager();
       }
    }
    /**
     * Recebe como parametro uam string contendo o nome do produtor e retorna uma lista com os devidos produtores informados
     * @param produtor
     * @return 
     */
    public List<Podcast> listarPorProdutor(String produtor){
        List podcasts = null;
        EntityManager em = JPAUtil.getEntityManager();
        try{
             String textoQuery = "SELECT pd FROM Podcast pd";
             if(!produtor.isEmpty()) //informou algum valor no parâmetro "filtroDescricao"
              textoQuery = textoQuery + " WHERE pd.produtor LIKE :produtor";

            if(!produtor.isEmpty()){
                Query consulta = em.createQuery(textoQuery);
                consulta.setParameter("produtor", produtor);
                podcasts = consulta.getResultList();
            }
        }finally{
             JPAUtil.closeEtityManager();
        }
           

      
        return podcasts;
    }
    
    /**
     * Metodo de exclusão de dados que recebe como parametro a id do objeto da classe Lista
     * @param id 
     */
    public void excluir(int id){
      EntityManager em = JPAUtil.getEntityManager();
      try{
          Podcast pd = em.find(Podcast.class, id);
          if(pd != null){
              em.getTransaction().begin();
              em.remove(pd);
              em.getTransaction().commit();
          }
      }catch(Exception e){
          em.getTransaction().rollback();
          throw e;
      }
      finally{
          JPAUtil.closeEtityManager();
      }
    }
}
