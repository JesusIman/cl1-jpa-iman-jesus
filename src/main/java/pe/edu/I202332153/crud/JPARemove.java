package pe.edu.I202332153.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202332153.entity.Country;

public class JPARemove {
    public static void main(String[] args) {
        //referenciar al EMF Y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        //Obtener Pais
        Country country = em.find(Country.class, "CCH");

        //Eliminamos
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();


    }
}
