//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.streams.streams_2_4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Controlled vocabulary for OperatingMode
 * 
 * <p>Java class for OperatingModeValueType</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="OperatingModeValueType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="AUTOMATIC"/>
 *     <enumeration value="MANUAL"/>
 *     <enumeration value="SEMI_AUTOMATIC"/>
 *     <enumeration value="UNAVAILABLE"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@com.fasterxml.jackson.annotation.JsonTypeName(value = "OperatingModeValueType")
@XmlType(name = "OperatingModeValueType")
@XmlEnum
public enum OperatingModeValueType {


    /**
     * automatically execute instructions from a recipe or program. >
     *             Note: Setpoint comes from a recipe.
     * 
     */
    AUTOMATIC,

    /**
     * execute instructions from an external agent or person. > Note 1
     *             to entry: Valve or switch is manipulated by an agent/person. >
     *             Note 2 to entry: Direct control of the PID output. % of the range: A
     *             user manually sets the % output, not the setpoint.
     * 
     */
    MANUAL,

    /**
     * executes a single instruction from a recipe or program. > Note 1
     *             to entry: Setpoint is entered and fixed, but the PID is controlling.
     *             > Note 2 to entry: Still goes through the PID control system.
     *             > Note 3 to entry: Manual fixed entry from a recipe.
     * 
     */
    SEMI_AUTOMATIC,

    /**
     * Value is indeterminate
     * 
     */
    UNAVAILABLE;

    public String value() {
        return name();
    }

    public static OperatingModeValueType fromValue(String v) {
        return valueOf(v);
    }

}
