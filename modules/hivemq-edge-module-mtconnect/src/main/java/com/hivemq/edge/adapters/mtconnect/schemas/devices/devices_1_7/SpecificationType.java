//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.devices.devices_1_7;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * {{block(Specification)}} elements define information describing the
 *         design characteristics for a piece of equipment.
 * 
 * <p>Java class for SpecificationType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="SpecificationType">
 *   <complexContent>
 *     <extension base="{urn:mtconnect.org:MTConnectDevices:1.7}AbstractSpecificationType">
 *       <all>
 *         <element name="Maximum" type="{urn:mtconnect.org:MTConnectDevices:1.7}MaximumType" minOccurs="0"/>
 *         <element name="Minimum" type="{urn:mtconnect.org:MTConnectDevices:1.7}MinimumType" minOccurs="0"/>
 *         <element name="Nominal" type="{urn:mtconnect.org:MTConnectDevices:1.7}NominalType" minOccurs="0"/>
 *         <element name="UpperLimit" type="{urn:mtconnect.org:MTConnectDevices:1.7}UpperLimitType" minOccurs="0"/>
 *         <element name="UpperWarning" type="{urn:mtconnect.org:MTConnectDevices:1.7}UpperWarningType" minOccurs="0"/>
 *         <element name="LowerWarning" type="{urn:mtconnect.org:MTConnectDevices:1.7}LowerWarningType" minOccurs="0"/>
 *         <element name="LowerLimit" type="{urn:mtconnect.org:MTConnectDevices:1.7}LowerLimitType" minOccurs="0"/>
 *       </all>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@com.fasterxml.jackson.annotation.JsonTypeName(value = "SpecificationType")
@XmlType(name = "SpecificationType", propOrder = {
    "maximum",
    "minimum",
    "nominal",
    "upperLimit",
    "upperWarning",
    "lowerWarning",
    "lowerLimit"
})
public class SpecificationType
    extends AbstractSpecificationType
{

    /**
     * If the data reported for a data item is a range of numeric
     *                 values, the expected value reported **MAY** be described with an
     *                 upper limit defined by this constraint.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Maximum")
    @XmlElement(name = "Maximum")
    protected MaximumType maximum;
    /**
     * If the data reported for a data item is a range of numeric
     *                 values, the expected value reported **MAY** be described with a
     *                 lower limit defined by this constraint.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Minimum")
    @XmlElement(name = "Minimum")
    protected MinimumType minimum;
    /**
     * The target or expected value for this data item.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Nominal")
    @XmlElement(name = "Nominal")
    protected NominalType nominal;
    /**
     * The upper conformance boundary for a variable. Note to Entry:
     *                 immediate concern or action may be required.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UpperLimit")
    @XmlElement(name = "UpperLimit")
    protected UpperLimitType upperLimit;
    /**
     * The upper boundary indicating increased concern and supervision
     *                 may be required.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "UpperWarning")
    @XmlElement(name = "UpperWarning")
    protected UpperWarningType upperWarning;
    /**
     * The lower boundary indicating increased concern and supervision
     *                 may be required.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "LowerWarning")
    @XmlElement(name = "LowerWarning")
    protected LowerWarningType lowerWarning;
    /**
     * The lower conformance boundary for a variable. Note to Entry:
     *                 immediate concern or action may be required.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "LowerLimit")
    @XmlElement(name = "LowerLimit")
    protected LowerLimitType lowerLimit;

    /**
     * If the data reported for a data item is a range of numeric
     *                 values, the expected value reported **MAY** be described with an
     *                 upper limit defined by this constraint.
     * 
     * @return
     *     possible object is
     *     {@link MaximumType }
     *     
     */
    public MaximumType getMaximum() {
        return maximum;
    }

    /**
     * Sets the value of the maximum property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumType }
     *     
     * @see #getMaximum()
     */
    public void setMaximum(MaximumType value) {
        this.maximum = value;
    }

    /**
     * If the data reported for a data item is a range of numeric
     *                 values, the expected value reported **MAY** be described with a
     *                 lower limit defined by this constraint.
     * 
     * @return
     *     possible object is
     *     {@link MinimumType }
     *     
     */
    public MinimumType getMinimum() {
        return minimum;
    }

    /**
     * Sets the value of the minimum property.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumType }
     *     
     * @see #getMinimum()
     */
    public void setMinimum(MinimumType value) {
        this.minimum = value;
    }

    /**
     * The target or expected value for this data item.
     * 
     * @return
     *     possible object is
     *     {@link NominalType }
     *     
     */
    public NominalType getNominal() {
        return nominal;
    }

    /**
     * Sets the value of the nominal property.
     * 
     * @param value
     *     allowed object is
     *     {@link NominalType }
     *     
     * @see #getNominal()
     */
    public void setNominal(NominalType value) {
        this.nominal = value;
    }

    /**
     * The upper conformance boundary for a variable. Note to Entry:
     *                 immediate concern or action may be required.
     * 
     * @return
     *     possible object is
     *     {@link UpperLimitType }
     *     
     */
    public UpperLimitType getUpperLimit() {
        return upperLimit;
    }

    /**
     * Sets the value of the upperLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpperLimitType }
     *     
     * @see #getUpperLimit()
     */
    public void setUpperLimit(UpperLimitType value) {
        this.upperLimit = value;
    }

    /**
     * The upper boundary indicating increased concern and supervision
     *                 may be required.
     * 
     * @return
     *     possible object is
     *     {@link UpperWarningType }
     *     
     */
    public UpperWarningType getUpperWarning() {
        return upperWarning;
    }

    /**
     * Sets the value of the upperWarning property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpperWarningType }
     *     
     * @see #getUpperWarning()
     */
    public void setUpperWarning(UpperWarningType value) {
        this.upperWarning = value;
    }

    /**
     * The lower boundary indicating increased concern and supervision
     *                 may be required.
     * 
     * @return
     *     possible object is
     *     {@link LowerWarningType }
     *     
     */
    public LowerWarningType getLowerWarning() {
        return lowerWarning;
    }

    /**
     * Sets the value of the lowerWarning property.
     * 
     * @param value
     *     allowed object is
     *     {@link LowerWarningType }
     *     
     * @see #getLowerWarning()
     */
    public void setLowerWarning(LowerWarningType value) {
        this.lowerWarning = value;
    }

    /**
     * The lower conformance boundary for a variable. Note to Entry:
     *                 immediate concern or action may be required.
     * 
     * @return
     *     possible object is
     *     {@link LowerLimitType }
     *     
     */
    public LowerLimitType getLowerLimit() {
        return lowerLimit;
    }

    /**
     * Sets the value of the lowerLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link LowerLimitType }
     *     
     * @see #getLowerLimit()
     */
    public void setLowerLimit(LowerLimitType value) {
        this.lowerLimit = value;
    }

}
