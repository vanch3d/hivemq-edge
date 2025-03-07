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
 * leaf {{block(Component)}} that is a {{block(Pot)}} for a tool that is
 *         awaiting transfer from a {{block(ToolMagazine)}} to {{term(spindle)}} or
 *         {{block(Turret)}}.
 * 
 * <p>Java class for TransferPotType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="TransferPotType">
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
@com.fasterxml.jackson.annotation.JsonTypeName(value = "TransferPotType")
@XmlType(name = "TransferPotType")
public class TransferPotType
    extends CommonComponentType
{


}
