//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.assets.assets_2_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * A archetypical cutting tool life cycle definition
 * 
 * <p>Java class for CuttingToolLifeCycleArchetypeType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="CuttingToolLifeCycleArchetypeType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReconditionCount" type="{urn:mtconnect.org:MTConnectAssets:2.2}ReconditionCountType" minOccurs="0"/>
 *         <element name="CuttingToolLife" type="{urn:mtconnect.org:MTConnectAssets:2.2}LifeType" maxOccurs="3" minOccurs="0"/>
 *         <element name="ProgramToolGroup" type="{urn:mtconnect.org:MTConnectAssets:2.2}ProgramToolGroupType" minOccurs="0"/>
 *         <element name="ProgramToolNumber" type="{urn:mtconnect.org:MTConnectAssets:2.2}ProgramToolNumberType" minOccurs="0"/>
 *         <element name="ProcessSpindleSpeed" type="{urn:mtconnect.org:MTConnectAssets:2.2}ProcessSpindleSpeedType" minOccurs="0"/>
 *         <element name="ProcessFeedRate" type="{urn:mtconnect.org:MTConnectAssets:2.2}ProcessFeedRateType" minOccurs="0"/>
 *         <element name="ConnectionCodeMachineSide" type="{urn:mtconnect.org:MTConnectAssets:2.2}ConnectionCodeMachineSideType" minOccurs="0"/>
 *         <any maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="Measurements" type="{urn:mtconnect.org:MTConnectAssets:2.2}AssemblyMeasurementsType" minOccurs="0"/>
 *         <element name="CuttingItems" type="{urn:mtconnect.org:MTConnectAssets:2.2}CuttingItemsType" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@com.fasterxml.jackson.annotation.JsonTypeName(value = "CuttingToolLifeCycleArchetypeType")
@XmlType(name = "CuttingToolLifeCycleArchetypeType", propOrder = {
    "reconditionCount",
    "cuttingToolLife",
    "programToolGroup",
    "programToolNumber",
    "processSpindleSpeed",
    "processFeedRate",
    "connectionCodeMachineSide",
    "any",
    "measurements",
    "cuttingItems"
})
public class CuttingToolLifeCycleArchetypeType {

    /**
     * Description
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ReconditionCount")
    @XmlElement(name = "ReconditionCount")
    protected ReconditionCountType reconditionCount;
    /**
     * The life of the cutting tool assembly
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "CuttingToolLife")
    @XmlElement(name = "CuttingToolLife")
    protected List<LifeType> cuttingToolLife;
    /**
     * tool group this tool is assigned in the part program.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ProgramToolGroup")
    @XmlElement(name = "ProgramToolGroup")
    protected String programToolGroup;
    /**
     * number of the tool as referenced in the part program.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ProgramToolNumber")
    @XmlElement(name = "ProgramToolNumber")
    protected BigInteger programToolNumber;
    /**
     * constrained process spindle speed for the tool in
     *             revolutions/minute. The {{property(value)}} **MAY** contain the
     *             nominal process target spindle speed if available. If
     *             {{block(ProcessSpindleSpeed)}} is provided, at least one value of
     *             {{property(maximum)}}, {{property(nominal)}}, or
     *             {{property(minimum)}} **MUST** be specified.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ProcessSpindleSpeed")
    @XmlElement(name = "ProcessSpindleSpeed")
    protected ProcessSpindleSpeedType processSpindleSpeed;
    /**
     * constrained process feed rate for the tool in mm/s. The
     *             {{property(value)}} **MAY** contain the nominal process target feed
     *             rate if available. If {{block(ProcessFeedRate)}} is provided, at
     *             least one value of {{property(maximum)}}, {{property(nominal)}}, or
     *             {{property(minimum)}} **MUST** be specified.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ProcessFeedRate")
    @XmlElement(name = "ProcessFeedRate")
    protected ProcessFeedRateType processFeedRate;
    /**
     * identifier for the capability to connect any component of the
     *             cutting tool together, except Assembly Items, on the machine side.
     *             Code: `CCMS`
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ConnectionCodeMachineSide")
    @XmlElement(name = "ConnectionCodeMachineSide")
    protected String connectionCodeMachineSide;
    /**
     * Any additional properties
     * 
     */
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    /**
     * {{block(Measurements)}} groups one or more {{block(Measurement)}}
     *             subtypes. See {{sect(Measurement)}}.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Measurements")
    @XmlElement(name = "Measurements")
    protected AssemblyMeasurementsType measurements;
    /**
     * {{block(CuttingItems)}} groups one or more {{block(CuttingItem)}}
     *             entities. See {{sect(CuttingItem)}} and {{package(Cutting Item)}}
     *             for more detail.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "CuttingItems")
    @XmlElement(name = "CuttingItems")
    protected CuttingItemsType cuttingItems;

    /**
     * Description
     * 
     * @return
     *     possible object is
     *     {@link ReconditionCountType }
     *     
     */
    public ReconditionCountType getReconditionCount() {
        return reconditionCount;
    }

    /**
     * Sets the value of the reconditionCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReconditionCountType }
     *     
     * @see #getReconditionCount()
     */
    public void setReconditionCount(ReconditionCountType value) {
        this.reconditionCount = value;
    }

    /**
     * The life of the cutting tool assembly
     * 
     * Gets the value of the cuttingToolLife property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cuttingToolLife property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getCuttingToolLife().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LifeType }
     * </p>
     * 
     * 
     * @return
     *     The value of the cuttingToolLife property.
     */
    public List<LifeType> getCuttingToolLife() {
        if (cuttingToolLife == null) {
            cuttingToolLife = new ArrayList<>();
        }
        return this.cuttingToolLife;
    }

    /**
     * tool group this tool is assigned in the part program.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramToolGroup() {
        return programToolGroup;
    }

    /**
     * Sets the value of the programToolGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getProgramToolGroup()
     */
    public void setProgramToolGroup(String value) {
        this.programToolGroup = value;
    }

    /**
     * number of the tool as referenced in the part program.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getProgramToolNumber() {
        return programToolNumber;
    }

    /**
     * Sets the value of the programToolNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     * @see #getProgramToolNumber()
     */
    public void setProgramToolNumber(BigInteger value) {
        this.programToolNumber = value;
    }

    /**
     * constrained process spindle speed for the tool in
     *             revolutions/minute. The {{property(value)}} **MAY** contain the
     *             nominal process target spindle speed if available. If
     *             {{block(ProcessSpindleSpeed)}} is provided, at least one value of
     *             {{property(maximum)}}, {{property(nominal)}}, or
     *             {{property(minimum)}} **MUST** be specified.
     * 
     * @return
     *     possible object is
     *     {@link ProcessSpindleSpeedType }
     *     
     */
    public ProcessSpindleSpeedType getProcessSpindleSpeed() {
        return processSpindleSpeed;
    }

    /**
     * Sets the value of the processSpindleSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessSpindleSpeedType }
     *     
     * @see #getProcessSpindleSpeed()
     */
    public void setProcessSpindleSpeed(ProcessSpindleSpeedType value) {
        this.processSpindleSpeed = value;
    }

    /**
     * constrained process feed rate for the tool in mm/s. The
     *             {{property(value)}} **MAY** contain the nominal process target feed
     *             rate if available. If {{block(ProcessFeedRate)}} is provided, at
     *             least one value of {{property(maximum)}}, {{property(nominal)}}, or
     *             {{property(minimum)}} **MUST** be specified.
     * 
     * @return
     *     possible object is
     *     {@link ProcessFeedRateType }
     *     
     */
    public ProcessFeedRateType getProcessFeedRate() {
        return processFeedRate;
    }

    /**
     * Sets the value of the processFeedRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessFeedRateType }
     *     
     * @see #getProcessFeedRate()
     */
    public void setProcessFeedRate(ProcessFeedRateType value) {
        this.processFeedRate = value;
    }

    /**
     * identifier for the capability to connect any component of the
     *             cutting tool together, except Assembly Items, on the machine side.
     *             Code: `CCMS`
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectionCodeMachineSide() {
        return connectionCodeMachineSide;
    }

    /**
     * Sets the value of the connectionCodeMachineSide property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getConnectionCodeMachineSide()
     */
    public void setConnectionCodeMachineSide(String value) {
        this.connectionCodeMachineSide = value;
    }

    /**
     * Any additional properties
     * 
     * Gets the value of the any property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * </p>
     * 
     * 
     * @return
     *     The value of the any property.
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<>();
        }
        return this.any;
    }

    /**
     * {{block(Measurements)}} groups one or more {{block(Measurement)}}
     *             subtypes. See {{sect(Measurement)}}.
     * 
     * @return
     *     possible object is
     *     {@link AssemblyMeasurementsType }
     *     
     */
    public AssemblyMeasurementsType getMeasurements() {
        return measurements;
    }

    /**
     * Sets the value of the measurements property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssemblyMeasurementsType }
     *     
     * @see #getMeasurements()
     */
    public void setMeasurements(AssemblyMeasurementsType value) {
        this.measurements = value;
    }

    /**
     * {{block(CuttingItems)}} groups one or more {{block(CuttingItem)}}
     *             entities. See {{sect(CuttingItem)}} and {{package(Cutting Item)}}
     *             for more detail.
     * 
     * @return
     *     possible object is
     *     {@link CuttingItemsType }
     *     
     */
    public CuttingItemsType getCuttingItems() {
        return cuttingItems;
    }

    /**
     * Sets the value of the cuttingItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link CuttingItemsType }
     *     
     * @see #getCuttingItems()
     */
    public void setCuttingItems(CuttingItemsType value) {
        this.cuttingItems = value;
    }

}
