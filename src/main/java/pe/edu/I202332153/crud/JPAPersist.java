package pe.edu.I202332153.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.I202332153.entity.City;
import pe.edu.I202332153.entity.Country;
import pe.edu.I202332153.entity.CountryLanguage;

import java.util.ArrayList;
import java.util.Arrays;

public class JPAPersist {
    public static void main(String[] args) {
        //referenciar al EMF Y EM
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        //Crear Country
        Country country = new Country("CCH","Los Canizales","South America","South America",546.56,1956,30000000,76.00,2.57,1.43,"Peru","Repiblic","Elizabeth II",3453,"CH",null);

        //Crear city
        City city = new City("Cristo Rey","CR","Cristo Rey",92780,country);
        City city2 = new City("Catacaos","CT","Catacaos",92781,country);
        City city3 = new City("Sechura","SC","Sechura",92782,country);

        country.setCity(Arrays.asList(city,city2,city3));

        //Crear lenguaje

        CountryLanguage language = new CountryLanguage("español","T",7.89,country);
        CountryLanguage language1 = new CountryLanguage("Quechua","F",7.90,country);

        country.setCountryLanguages(Arrays.asList(language,language1));

        //Registrar country
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
    }
}
