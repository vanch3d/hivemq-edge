//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.streams.streams_2_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Cell of {{def(EventEnum:MAINTENANCE_LIST)}} If the
 *         {{property(INTERVAL)}} {{property(key)}} is not provided, it is assumed
 *         `ABSOLUTE`. If the {{property(DIRECTION)}} {{property(key)}} is not
 *         provided, it is assumed `UP`. If the {{property(UNITS)}}
 *         {{property(key)}} is not provided, it is assumed to be `COUNT`.
 * 
 * <p>Java class for MaintenanceListCellType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="MaintenanceListCellType">
 *   <simpleContent>
 *     <restriction base="<urn:mtconnect.org:MTConnectStreams:2.2>TableCellType">
 *     </restriction>
 *   </simpleContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@com.fasterxml.jackson.annotation.JsonTypeName(value = "MaintenanceListCellType")
@XmlType(name = "MaintenanceListCellType")
public class MaintenanceListCellType
    extends TableCellType
{


}
