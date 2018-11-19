package org.softlang.company.features;

import org.softlang.company.xjc.Company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Serialization {

    private static JAXBContext jaxbContext;
    
    public static void initializeJaxbContext()
    throws JAXBException
    {
        if (jaxbContext==null)
            jaxbContext =
                JAXBContext.newInstance("org.softlang.company.xjc");
    }

    public static Company deserializeCompany(File input)
    throws JAXBException 
    {	
        initializeJaxbContext();
        return (Company) jaxbContext.createUnmarshaller().unmarshal(input);
    }

    public static void serializeCompany(File output, Company c)
    throws     JAXBException,
            FileNotFoundException,
            XMLStreamException 
    {
    	initializeJaxbContext();
    	XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileOutputStream(output));
        jaxbContext.createMarshaller().marshal(c, writer); 
    }

}