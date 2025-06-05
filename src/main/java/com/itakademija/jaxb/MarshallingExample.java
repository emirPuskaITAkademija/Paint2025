package com.itakademija.jaxb;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MarshallingExample {

    public static void main(String[] args) throws JAXBException {
        //1. XSD
        //2.generated XJC -> generisali klasu Country i ObjectFactory
        //3.generated class use for instantiation -> za instanciranje
        //4. serijalizujemo ih u neki XML prateć XSD
        ObjectFactory objectFactory = new ObjectFactory();
        Countries countries = objectFactory.createCountries();

        Country country = objectFactory.createCountry();
        country.setCountryCapital("Sarajevo");
        country.setCountryContinent("Europa");
        country.setCountryName("BiH");
        country.setCountryFoundationDate("1189");
        country.setCountryPopulation(new BigInteger("3500000"));

        Country country2 = objectFactory.createCountry();
        country2.setCountryCapital("Beograd");
        country2.setCountryContinent("Europa");
        country2.setCountryName("Srbija");
        country2.setCountryFoundationDate("1200");
        country2.setCountryPopulation(new BigInteger("5500000"));

        countries.getCountry().add(country);
        countries.getCountry().add(country2);

        JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(countries, System.out);
        marshaller.marshal(countries, new File("countries.xml"));
    }
}
