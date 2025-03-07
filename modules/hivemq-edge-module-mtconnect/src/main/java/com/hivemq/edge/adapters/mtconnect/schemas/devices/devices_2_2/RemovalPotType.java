//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.devices.devices_2_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * leaf {{block(Component)}} that is a {{block(Pot)}} for a tool that has
 *         to be removed from a {{block(ToolMagazine)}} or {{block(Turret)}} to a
 *         location outside of the piece of equipment.
 * 
 * <p>Java class for RemovalPotType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="RemovalPotType">
 *   <complexContent>
 *     <extension base="{urn:mtconnect.org:MTConnectDevices:2.2}CommonComponentType">
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@com.fasterxml.jackson.annotation.JsonTypeName(value = "RemovalPotType")
@XmlType(name = "RemovalPotType")
public class RemovalPotType
    extends CommonComponentType
{


}
