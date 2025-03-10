//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.devices.devices_2_1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * {{block(ConfigurationRelationship)}} that describes the association
 *         between two pieces of equipment that function independently but together
 *         perform a manufacturing operation.
 * 
 * <p>Java class for DeviceRelationshipType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="DeviceRelationshipType">
 *   <complexContent>
 *     <extension base="{urn:mtconnect.org:MTConnectDevices:2.1}RelationshipType">
 *       <attribute name="deviceUuidRef" use="required" type="{urn:mtconnect.org:MTConnectDevices:2.1}UuidType" />
 *       <attribute name="role" type="{urn:mtconnect.org:MTConnectDevices:2.1}DeviceRoleEnumType" />
 *       <attribute name="href" type="{http://www.w3.org/1999/xlink}hrefType" />
 *       <attribute ref="{http://www.w3.org/1999/xlink}type fixed="locator""/>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@com.fasterxml.jackson.annotation.JsonTypeName(value = "DeviceRelationshipType")
@XmlType(name = "DeviceRelationshipType")
public class DeviceRelationshipType
    extends RelationshipType
{

    /**
     * A reference to the device uuid
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "deviceUuidRef")
    @XmlAttribute(name = "deviceUuidRef", required = true)
    protected String deviceUuidRef;
    /**
     * The type of relatiship
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "role")
    @XmlAttribute(name = "role")
    protected DeviceRoleEnumType role;
    /**
     * {{term(URL)}} giving the location of the {{block(SolidModel)}}. If
     *               not present, the model referenced in the
     *               {{property(solidModelIdRef,SolidModel)}} is used.
     *               {{property(href,SolidModel)}} is of type `xlink:href` from the W3C
     *               XLink specification.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "href")
    @XmlAttribute(name = "href")
    protected String href;
    /**
     * Description
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "type")
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink")
    protected TypeType typeOfDeviceRelationship;

    /**
     * A reference to the device uuid
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceUuidRef() {
        return deviceUuidRef;
    }

    /**
     * Sets the value of the deviceUuidRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getDeviceUuidRef()
     */
    public void setDeviceUuidRef(String value) {
        this.deviceUuidRef = value;
    }

    /**
     * The type of relatiship
     * 
     * @return
     *     possible object is
     *     {@link DeviceRoleEnumType }
     *     
     */
    public DeviceRoleEnumType getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceRoleEnumType }
     *     
     * @see #getRole()
     */
    public void setRole(DeviceRoleEnumType value) {
        this.role = value;
    }

    /**
     * {{term(URL)}} giving the location of the {{block(SolidModel)}}. If
     *               not present, the model referenced in the
     *               {{property(solidModelIdRef,SolidModel)}} is used.
     *               {{property(href,SolidModel)}} is of type `xlink:href` from the W3C
     *               XLink specification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getHref()
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Description
     * 
     * @return
     *     possible object is
     *     {@link TypeType }
     *     
     */
    public TypeType getTypeOfDeviceRelationship() {
        if (typeOfDeviceRelationship == null) {
            return TypeType.LOCATOR;
        } else {
            return typeOfDeviceRelationship;
        }
    }

    /**
     * Sets the value of the typeOfDeviceRelationship property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeType }
     *     
     * @see #getTypeOfDeviceRelationship()
     */
    public void setTypeOfDeviceRelationship(TypeType value) {
        this.typeOfDeviceRelationship = value;
    }

}
