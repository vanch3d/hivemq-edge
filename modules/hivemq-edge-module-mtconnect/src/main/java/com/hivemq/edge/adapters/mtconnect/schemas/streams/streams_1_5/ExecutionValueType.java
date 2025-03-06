//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.streams.streams_1_5;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Controlled vocabulary for Execution
 * 
 * <p>Java class for ExecutionValueType</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="ExecutionValueType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="READY"/>
 *     <enumeration value="ACTIVE"/>
 *     <enumeration value="INTERRUPTED"/>
 *     <enumeration value="FEED_HOLD"/>
 *     <enumeration value="STOPPED"/>
 *     <enumeration value="OPTIONAL_STOP"/>
 *     <enumeration value="PROGRAM_STOPPED"/>
 *     <enumeration value="PROGRAM_COMPLETED"/>
 *     <enumeration value="UNAVAILABLE"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@com.fasterxml.jackson.annotation.JsonTypeName(value = "ExecutionValueType")
@XmlType(name = "ExecutionValueType")
@XmlEnum
public enum ExecutionValueType {


    /**
     * A component is ready to engage.
     * 
     */
    READY,

    /**
     * The value of the data entity that is engaging.
     * 
     */
    ACTIVE,

    /**
     * The action of a component has been suspended due to an external
     *             signal.
     * 
     */
    INTERRUPTED,

    /**
     * Motion of a component has been commanded to stop at its current
     *             position.
     * 
     */
    FEED_HOLD,

    /**
     * The component is stopped.
     * 
     */
    STOPPED,

    /**
     * The controllers program has been intentionally stopped
     * 
     */
    OPTIONAL_STOP,

    /**
     * The execution of the controller's program has been stopped by a
     *             command from within the program.
     * 
     */
    PROGRAM_STOPPED,

    /**
     * The execution of the controllers program has been stopped by a
     *             command from within the program.
     * 
     */
    PROGRAM_COMPLETED,

    /**
     * Value is indeterminate
     * 
     */
    UNAVAILABLE;

    public String value() {
        return name();
    }

    public static ExecutionValueType fromValue(String v) {
        return valueOf(v);
    }

}
