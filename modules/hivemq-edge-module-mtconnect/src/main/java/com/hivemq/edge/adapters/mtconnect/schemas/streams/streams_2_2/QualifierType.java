//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.streams.streams_2_2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * A qualifier for the condition
 * 
 * <p>Java class for QualifierType</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="QualifierType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="HIGH"/>
 *     <enumeration value="LOW"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@com.fasterxml.jackson.annotation.JsonTypeName(value = "QualifierType")
@XmlType(name = "QualifierType")
@XmlEnum
public enum QualifierType {


    /**
     * The value is too high
     * 
     */
    HIGH,

    /**
     * The value is too low
     * 
     */
    LOW;

    public String value() {
        return name();
    }

    public static QualifierType fromValue(String v) {
        return valueOf(v);
    }

}
