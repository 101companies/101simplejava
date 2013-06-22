package org.softlang.company.features;

import org.softlang.company.xjc.Company;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

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
        Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
        return (Company) unMarshaller.unmarshal(input);
    }

    public static void serializeCompany(File output, Company c)
    throws     JAXBException,
            FileNotFoundException,
            XMLStreamException 
    {
        initializeJaxbContext();
        OutputStream os = new FileOutputStream(output);
        Marshaller marshaller = jaxbContext.createMarshaller();
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = outputFactory.createXMLStreamWriter(os);
        marshaller.marshal(c, writer); // TODO: need a stream writer that does indentation
    }

}