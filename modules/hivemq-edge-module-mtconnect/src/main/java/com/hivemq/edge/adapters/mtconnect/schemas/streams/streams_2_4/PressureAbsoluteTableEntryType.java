//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.streams.streams_2_4;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Table Entry of The force per unit area measured relative to a vacuum.
 * 
 * <p>Java class for PressureAbsoluteTableEntryType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="PressureAbsoluteTableEntryType">
 *   <complexContent>
 *     <extension base="{urn:mtconnect.org:MTConnectStreams:2.4}EntryType">
 *       <sequence>
 *         <element name="Cell" type="{urn:mtconnect.org:MTConnectStreams:2.4}PressureAbsoluteCellType" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@com.fasterxml.jackson.annotation.JsonTypeName(value = "PressureAbsoluteTableEntryType")
@XmlType(name = "PressureAbsoluteTableEntryType", propOrder = {
    "cell"
})
public class PressureAbsoluteTableEntryType
    extends EntryType
{

    /**
     * Constraints for Cell Values
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Cell")
    @XmlElement(name = "Cell")
    protected List<PressureAbsoluteCellType> cell;

    /**
     * Constraints for Cell Values
     * 
     * Gets the value of the cell property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cell property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getCell().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PressureAbsoluteCellType }
     * </p>
     * 
     * 
     * @return
     *     The value of the cell property.
     */
    public List<PressureAbsoluteCellType> getCell() {
        if (cell == null) {
            cell = new ArrayList<>();
        }
        return this.cell;
    }

}
