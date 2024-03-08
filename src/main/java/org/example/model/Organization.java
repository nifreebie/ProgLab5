package org.example.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
    @JacksonXmlProperty(localName = "id")
    private long id;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "employeesCount")
    private Long employeesCount;
    @JacksonXmlProperty(localName = "type")
    private OrganizationType type;
    @JacksonXmlProperty(localName = "officialAddress")
    private Address officialAddress;

    private long lastId = 0L;


    public Organization(String name, Long employeesCount, OrganizationType type, Address officialAddress) {
        this.id = generateId();
        this.name = name;
        this.employeesCount = employeesCount;
        this.type = type;
        this.officialAddress = officialAddress;
    }

    private long generateId() {
        return ++lastId;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ",name='" + name + '\'' +
                ", employeesCount=" + employeesCount +
                ", type=" + type +
                ", officialAddress=" + officialAddress.toString() +
                '}';
    }
}
