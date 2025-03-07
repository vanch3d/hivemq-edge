//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.devices.devices_1_7;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * A reference to the creator of the Specification
 * 
 * <p>Java class for OriginatorEnumEnum</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="OriginatorEnumEnum">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="MANUFACTURER"/>
 *     <enumeration value="USER"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@com.fasterxml.jackson.annotation.JsonTypeName(value = "OriginatorEnumEnum")
@XmlType(name = "OriginatorEnumEnum")
@XmlEnum
public enum OriginatorEnumEnum {


    /**
     * The manufacturer of a piece of equipment or component.
     * 
     */
    MANUFACTURER,

    /**
     * The owner or implementer of a piece of equipment or component.
     * 
     */
    USER;

    public String value() {
        return name();
    }

    public static OriginatorEnumEnum fromValue(String v) {
        return valueOf(v);
    }

}
