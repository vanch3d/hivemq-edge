//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.assets.assets_2_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * {{def(EventEnum:WAIT_STATE)}} When {{block(Execution)}}
 *         {{property(result)}} is not `WAIT`, the
 *         {{property(Observation::isUnavailable)}} property of
 *         {{block(WaitState)}} **MUST** be `true`.
 * 
 * <p>Java class for WaitStateType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="WaitStateType">
 *   <simpleContent>
 *     <restriction base="<urn:mtconnect.org:MTConnectAssets:2.2>EventType">
 *     </restriction>
 *   </simpleContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@com.fasterxml.jackson.annotation.JsonTypeName(value = "WaitStateType")
@XmlType(name = "WaitStateType")
public class WaitStateType
    extends EventType
{


}
