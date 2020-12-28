package com.example.clientMS;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class RestController1 {

    @Autowired
    RestTemplate p;


    @RequestMapping(value = "/template/etudiants")
    public String getEtudiants()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return p.exchange("http://localhost:8080/mysql/etudiants",
                HttpMethod.GET,entity,String.class).getBody();
    }


    @RequestMapping(value = "/template/add", method = RequestMethod.POST)
    public String createProducts(@RequestBody Etudiant product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Etudiant> entity = new HttpEntity<Etudiant>(product,headers);

        return p.exchange(
                "http://localhost:8080/mysql/add1",
                HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/add2", method = RequestMethod.POST)
    public String createProductss(@RequestBody EtudiantNote product) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<EtudiantNote> entity = new HttpEntity<EtudiantNote>(product, headers);

        if (p.exchange("http://localhost:8080/mysql/etudiants",
                HttpMethod.GET, entity, String.class).getBody().contains(product.getNum_etudiant())
        ) {
            return p.exchange(
               "http://localhost:9091/postgres/insertSub",
                    HttpMethod.POST, entity, String.class).getBody();
        }
        return "Cet etudiant n'existe pas";
    }

    @RequestMapping(value = "/template/addS")
    public String insertStage(@RequestBody EtudiantStage product)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<EtudiantStage> entity = new HttpEntity<EtudiantStage>(product, headers);
        if (p.exchange("http://localhost:8080/mysql/etudiants",
                HttpMethod.GET, entity, String.class).getBody().contains(product.getNum_etudiant())
                && p.exchange("http://localhost:8080/mysql/etudiants",
                HttpMethod.GET, entity, String.class).getBody().contains(product.getPrenom())
                && p.exchange("http://localhost:8080/mysql/etudiants",
                HttpMethod.GET, entity, String.class).getBody().contains(product.getNom()))
        {
            return p.exchange("http://localhost:9090/mariadb/add1", HttpMethod.POST,
                    entity, String.class).getBody();
        }
        return "L'etudiant n'existe pas dans la base de donnee MySQL";
    }


}
