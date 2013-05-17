package org.softlang.company.features;

import org.softlang.company.model.Company;

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

public class Parsing {

    private static JAXBContext jaxbContext;

    public static JAXBContext initializeJaxbContext()
    throws JAXBException
    {
        if (jaxbContext==null)
            jaxbContext =
                JAXBContext.newInstance("org.softlang.company.model");
        return jaxbContext;
    }

    public static Company deserializeCompany(File input)
    throws JAXBException 
    {
        initializeJaxbContext();
        Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
        return (Company) unMarshaller.unmarshal(input);
    }

}