//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.streams.streams_2_4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The state of the interface
 * 
 * <p>Java class for InterfaceStatesType</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="InterfaceStatesType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="UNAVAILABLE"/>
 *     <enumeration value="ENABLED"/>
 *     <enumeration value="DISABLED"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@com.fasterxml.jackson.annotation.JsonTypeName(value = "InterfaceStatesType")
@XmlType(name = "InterfaceStatesType")
@XmlEnum
public enum InterfaceStatesType {


    /**
     * The value is unavailable
     * 
     */
    UNAVAILABLE,

    /**
     * The interface is enabled
     * 
     */
    ENABLED,

    /**
     * The interface is disabled
     * 
     */
    DISABLED;

    public String value() {
        return name();
    }

    public static InterfaceStatesType fromValue(String v) {
        return valueOf(v);
    }

}
