package org.softlang.company.features;

import static org.softlang.company.features.Parsing.*;
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

public class Unparsing {

    public static void serializeCompany(File output, Company c)
    throws     JAXBException,
            FileNotFoundException,
            XMLStreamException 
    {
        JAXBContext jaxbContext = initializeJaxbContext();
        OutputStream os = new FileOutputStream(output);
        Marshaller marshaller = jaxbContext.createMarshaller();
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = outputFactory.createXMLStreamWriter(os);
        marshaller.marshal(c, writer); // TODO: need a stream writer that does indentation
    }

}