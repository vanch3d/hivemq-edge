//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.devices.devices_1_7;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * device relationships
 * 
 * <p>Java class for DeviceRoleEnumType</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="DeviceRoleEnumType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="SYSTEM"/>
 *     <enumeration value="AUXILIARY"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@com.fasterxml.jackson.annotation.JsonTypeName(value = "DeviceRoleEnumType")
@XmlType(name = "DeviceRoleEnumType")
@XmlEnum
public enum DeviceRoleEnumType {


    /**
     * a system
     * 
     */
    SYSTEM,

    /**
     * an auxiliary
     * 
     */
    AUXILIARY;

    public String value() {
        return name();
    }

    public static DeviceRoleEnumType fromValue(String v) {
        return valueOf(v);
    }

}
