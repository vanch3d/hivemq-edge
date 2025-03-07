//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.assets.assets_2_4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Controlled vocabulary for CharacteristicStatus
 * 
 * <p>Java class for CharacteristicStatusValueType</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="CharacteristicStatusValueType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="PASS"/>
 *     <enumeration value="FAIL"/>
 *     <enumeration value="REWORK"/>
 *     <enumeration value="SYSTEM_ERROR"/>
 *     <enumeration value="INDETERMINATE"/>
 *     <enumeration value="NOT_ANALYZED"/>
 *     <enumeration value="BASIC_OR_THEORETIC_EXACT_DIMENSION"/>
 *     <enumeration value="UNDEFINED"/>
 *     <enumeration value="UNAVAILABLE"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@com.fasterxml.jackson.annotation.JsonTypeName(value = "CharacteristicStatusValueType")
@XmlType(name = "CharacteristicStatusValueType")
@XmlEnum
public enum CharacteristicStatusValueType {


    /**
     * measurement is within acceptable tolerances.
     * 
     */
    PASS,

    /**
     * measurement is not within acceptable tolerances.
     * 
     */
    FAIL,

    /**
     * failed, but acceptable constraints achievable by utilizing
     *             additional manufacturing processes.
     * 
     */
    REWORK,

    /**
     * measurement is indeterminate due to an equipment failure.
     * 
     */
    SYSTEM_ERROR,

    /**
     * measurement cannot be determined.
     * 
     */
    INDETERMINATE,

    /**
     * measurement cannot be evaluated.
     * 
     */
    NOT_ANALYZED,

    /**
     * nominal provided without tolerance limits. {{cite(QIF 3:2018
     *             5.10.2.6)}}
     * 
     */
    BASIC_OR_THEORETIC_EXACT_DIMENSION,

    /**
     * status of measurement cannot be determined.
     * 
     */
    UNDEFINED,

    /**
     * Value is indeterminate
     * 
     */
    UNAVAILABLE;

    public String value() {
        return name();
    }

    public static CharacteristicStatusValueType fromValue(String v) {
        return valueOf(v);
    }

}
