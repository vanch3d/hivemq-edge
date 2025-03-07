//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.assets.assets_2_4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The type of tool location
 * 
 * <p>Java class for LocationsTypeType</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="LocationsTypeType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="POT"/>
 *     <enumeration value="STATION"/>
 *     <enumeration value="CRIB"/>
 *     <enumeration value="SPINDLE"/>
 *     <enumeration value="TRANSFER_POT"/>
 *     <enumeration value="RETURN_POT"/>
 *     <enumeration value="STAGING_POT"/>
 *     <enumeration value="REMOVAL_POT"/>
 *     <enumeration value="EXPIRED_POT"/>
 *     <enumeration value="END_EFFECTOR"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@com.fasterxml.jackson.annotation.JsonTypeName(value = "LocationsTypeType")
@XmlType(name = "LocationsTypeType")
@XmlEnum
public enum LocationsTypeType {


    /**
     * A location in a tool magazine. updated
     * 
     */
    POT,

    /**
     * A location in a turret, tool bar, or tool rack. updated
     * 
     */
    STATION,

    /**
     * A location within a tool crib. updated
     * 
     */
    CRIB,

    /**
     * A location associated with a spindle
     * 
     */
    SPINDLE,

    /**
     * A location for a tool awaiting transfer from a tool magazine to
     *             spindle or a turret
     * 
     */
    TRANSFER_POT,

    /**
     * A location for a tool removed from a spindle or turret and awaiting
     *             return to a tool magazine
     * 
     */
    RETURN_POT,

    /**
     * A location for a tool awaiting transfer to a tool magazine or turret
     *             from outside of the piece of equipment.
     * 
     */
    STAGING_POT,

    /**
     * A location for a tool removed from a tool magazine or turret
     *             awaiting transfer to a location outside of the piece of equipment.
     * 
     */
    REMOVAL_POT,

    /**
     * A location for a tool that is no longer useable and is awaiting
     *             removal from a tool magazine or turret.
     * 
     */
    EXPIRED_POT,

    /**
     * A location associated with an end effector
     * 
     */
    END_EFFECTOR;

    public String value() {
        return name();
    }

    public static LocationsTypeType fromValue(String v) {
        return valueOf(v);
    }

}
