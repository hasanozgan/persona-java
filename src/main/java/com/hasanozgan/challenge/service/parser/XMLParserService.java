package com.hasanozgan.challenge.service.parser;

import com.hasanozgan.challenge.model.People;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hasanozgan
 * Date: 10/2/13
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLParserService implements ParserService {
    private String filePath;

    public XMLParserService(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public People createPeople() throws IOException {
        People people = new People();

        try {
            JAXBContext jc = JAXBContext.newInstance(Contacts.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Contacts contacts = (Contacts) unmarshaller.unmarshal(new File(filePath));

            for (Contact contact : contacts.getList()) {
                people.addPerson(contact.getName(), contact.getLastName(), contact.getPhone());
            }

            System.out.println(people.size());
            System.out.println(contacts.getList().size());

        } catch (JAXBException e) {
            throw new IOException(e.getMessage());
        }

        return people;
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class Contacts {

        @XmlElement(name = "contact")
        private List<Contact> list;

        public List<Contact> getList() {
            return list;
        }

        public void setList(List<Contact> list) {
            this.list = list;
        }
    }

    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
    private static class Contact {

        @XmlElement(name="name")
        private String name;

        @XmlElement(name="lastName")
        private String lastName;

        @XmlElement(name="phone")
        private String phone;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
