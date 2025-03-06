//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.devices.devices_1_5;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * stock is an XML container that represents the information for the
 *         material that is used in a manufacturing process and to which work is
 *         applied in a machine or piece of equipment to produce parts.
 * 
 * <p>Java class for StockType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="StockType">
 *   <complexContent>
 *     <extension base="{urn:mtconnect.org:MTConnectDevices:1.5}MaterialsType">
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@com.fasterxml.jackson.annotation.JsonTypeName(value = "StockType")
@XmlType(name = "StockType")
public class StockType
    extends MaterialsType
{


}
