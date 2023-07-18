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
 *
 * @author Usuario
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
    
    public List<Podcast> listarPorProdutor(String filtroDescricao){
        List podcasts = null;
        EntityManager em = JPAUtil.getEntityManager();
        try{
             String textoQuery = "SELECT pd FROM Podcast pd";
             if(!filtroDescricao.isEmpty()) //informou algum valor no parâmetro "filtroDescricao"
              textoQuery = textoQuery + " WHERE pd.produtor LIKE :produtor";

            if(!filtroDescricao.isEmpty()){
                Query consulta = em.createQuery(textoQuery);
                consulta.setParameter("produtor", filtroDescricao);
                podcasts = consulta.getResultList();
            }
        }finally{
             JPAUtil.closeEtityManager();
        }
           

      
        return podcasts;
    }
}
