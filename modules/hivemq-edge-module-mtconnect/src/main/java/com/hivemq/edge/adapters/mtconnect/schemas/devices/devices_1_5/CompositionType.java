//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.devices.devices_1_5;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * An XML element used to describe the lowest level structural building
 *         blocks contained within a component element.
 * 
 * <p>Java class for CompositionType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="CompositionType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Description" type="{urn:mtconnect.org:MTConnectDevices:1.5}ComponentDescriptionType" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="id" use="required" type="{urn:mtconnect.org:MTConnectDevices:1.5}IDType" />
 *       <attribute name="uuid" type="{urn:mtconnect.org:MTConnectDevices:1.5}UuidType" />
 *       <attribute name="name" type="{urn:mtconnect.org:MTConnectDevices:1.5}NameType" />
 *       <attribute name="type" use="required" type="{urn:mtconnect.org:MTConnectDevices:1.5}CompositionEnumTypeType" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@com.fasterxml.jackson.annotation.JsonTypeName(value = "CompositionType")
@XmlType(name = "CompositionType", propOrder = {
    "description"
})
public class CompositionType {

    /**
     * An XML element that can contain any descriptive content.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Description")
    @XmlElement(name = "Description")
    protected ComponentDescriptionType description;
    /**
     * The unique identifier for this element.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "id")
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    /**
     * The unique identifier for an XML element.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "uuid")
    @XmlAttribute(name = "uuid")
    protected String uuid;
    /**
     * The name of an element or a piece of equipment.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "name")
    @XmlAttribute(name = "name")
    protected String name;
    /**
     * The type of either a structural element or a dataitem being measured.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "type")
    @XmlAttribute(name = "type", required = true)
    protected String type;

    /**
     * An XML element that can contain any descriptive content.
     * 
     * @return
     *     possible object is
     *     {@link ComponentDescriptionType }
     *     
     */
    public ComponentDescriptionType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComponentDescriptionType }
     *     
     * @see #getDescription()
     */
    public void setDescription(ComponentDescriptionType value) {
        this.description = value;
    }

    /**
     * The unique identifier for this element.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getId()
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * The unique identifier for an XML element.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Sets the value of the uuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getUuid()
     */
    public void setUuid(String value) {
        this.uuid = value;
    }

    /**
     * The name of an element or a piece of equipment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getName()
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * The type of either a structural element or a dataitem being measured.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getType()
     */
    public void setType(String value) {
        this.type = value;
    }

}
