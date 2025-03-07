//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.assets.assets_2_4;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Description
 * 
 * <p>Java class for RepresentationType</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="RepresentationType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="TIME_SERIES"/>
 *     <enumeration value="VALUE"/>
 *     <enumeration value="DATA_SET"/>
 *     <enumeration value="DISCRETE"/>
 *     <enumeration value="TABLE"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@com.fasterxml.jackson.annotation.JsonTypeName(value = "RepresentationType")
@XmlType(name = "RepresentationType")
@XmlEnum
public enum RepresentationType {


    /**
     * series of sampled data. The data is reported for a specified number
     *             of samples and each sample is reported with a fixed period.
     * 
     */
    TIME_SERIES,

    /**
     * measured value of the sample data. If no
     *             {{property(DataItem::representation)}} is specified for a data item,
     *             the {{property(DataItem::representation)}} **MUST** be determined to
     *             be `VALUE`.
     * 
     */
    VALUE,

    /**
     * reported value(s) are represented as a set of {{termplural(key-value
     *             pair)}}. Each reported value in the {{term(data set)}} **MUST** have
     *             a unique key.
     * 
     */
    DATA_SET,

    /**
     * **DEPRECATED** as {{property(DataItem::representation)}} type in
     *             *MTConnect Version 1.5*. Replaced by the
     *             {{property(DataItem::discrete)}}.
     * 
     */
    DISCRETE,

    /**
     * two dimensional set of {{termplural(key-value pair)}} where the
     *             {{block(Entry)}} represents a row, and the value is a set of
     *             {{term(key-value pair)}} {{block(Cell)}} elements. A {{term(table)}}
     *             follows the same behavior as the {{term(data set)}} for change
     *             tracking, clearing, and history. When an {{block(Entry)}} changes,
     *             all {{block(Cell)}} elements update as a single unit following the
     *             behavior of a {{term(data set)}}. > Note: It is best to use
     *             {{block(Variable)}} if the {{block(Cell)}} entities represent
     *             multiple semantic types. Each {{block(Entry)}} in the
     *             {{term(table)}} **MUST** have a unique key. Each {{block(Cell)}} of
     *             each {{block(Entry)}} in the {{term(table)}} **MUST** have a unique
     *             key. See {{block(Representation)}} in {{package(Observation
     *             Information Model)}}, for a description of {{block(Entry)}} and
     *             {{block(Cell)}} elements.
     * 
     */
    TABLE;

    public String value() {
        return name();
    }

    public static RepresentationType fromValue(String v) {
        return valueOf(v);
    }

}
