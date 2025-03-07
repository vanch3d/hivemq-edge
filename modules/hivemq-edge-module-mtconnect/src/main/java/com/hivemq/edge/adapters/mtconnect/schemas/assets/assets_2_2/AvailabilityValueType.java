//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.assets.assets_2_2;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Controlled vocabulary for Availability
 * 
 * <p>Java class for AvailabilityValueType</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="AvailabilityValueType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="AVAILABLE"/>
 *     <enumeration value="UNAVAILABLE"/>
 *     <enumeration value="UNAVAILABLE"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@com.fasterxml.jackson.annotation.JsonTypeName(value = "AvailabilityValueType")
@XmlType(name = "AvailabilityValueType")
@XmlEnum
public enum AvailabilityValueType {


    /**
     * data source is active and capable of providing data.
     * 
     */
    AVAILABLE,

    /**
     * data source is either inactive or not capable of providing data.
     * 
     */
    UNAVAILABLE;

    public String value() {
        return name();
    }

    public static AvailabilityValueType fromValue(String v) {
        return valueOf(v);
    }

}
