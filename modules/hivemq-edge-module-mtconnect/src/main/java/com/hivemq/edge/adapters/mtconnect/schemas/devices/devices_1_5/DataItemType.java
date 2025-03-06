//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.devices.devices_1_5;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * data entity describing a piece of information reported about a piece of
 *         equipment.
 * 
 * <p>Java class for DataItemType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="DataItemType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Source" type="{urn:mtconnect.org:MTConnectDevices:1.5}DataItemSourceType" minOccurs="0"/>
 *         <element name="Constraints" type="{urn:mtconnect.org:MTConnectDevices:1.5}DataItemConstraintsType" minOccurs="0"/>
 *         <element name="Filters" type="{urn:mtconnect.org:MTConnectDevices:1.5}FiltersType" minOccurs="0"/>
 *         <element name="InitialValue" type="{urn:mtconnect.org:MTConnectDevices:1.5}DataItemNumericValueType" minOccurs="0"/>
 *         <element name="ResetTrigger" type="{urn:mtconnect.org:MTConnectDevices:1.5}DataItemResetValueType" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="name" type="{urn:mtconnect.org:MTConnectDevices:1.5}NameType" />
 *       <attribute name="id" use="required" type="{urn:mtconnect.org:MTConnectDevices:1.5}IDType" />
 *       <attribute name="type" use="required" type="{urn:mtconnect.org:MTConnectDevices:1.5}DataItemEnumType" />
 *       <attribute name="subType" type="{urn:mtconnect.org:MTConnectDevices:1.5}DataItemSubEnumType" />
 *       <attribute name="statistic" type="{urn:mtconnect.org:MTConnectDevices:1.5}DataItemStatisticsType" />
 *       <attribute name="units" type="{urn:mtconnect.org:MTConnectDevices:1.5}UnitsType" />
 *       <attribute name="nativeUnits" type="{urn:mtconnect.org:MTConnectDevices:1.5}NativeUnitsType" />
 *       <attribute name="nativeScale" type="{urn:mtconnect.org:MTConnectDevices:1.5}NativeScaleType" />
 *       <attribute name="category" use="required" type="{urn:mtconnect.org:MTConnectDevices:1.5}CategoryType" />
 *       <attribute name="coordinateSystem" type="{urn:mtconnect.org:MTConnectDevices:1.5}CoordinateSystemEnumType" />
 *       <attribute name="coordinateSystemId" type="{urn:mtconnect.org:MTConnectDevices:1.5}CoordinateSystemIdType" />
 *       <attribute name="compositionId" type="{urn:mtconnect.org:MTConnectDevices:1.5}CompositionIdType" />
 *       <attribute name="sampleRate" type="{urn:mtconnect.org:MTConnectDevices:1.5}DataItemSampleRateType" />
 *       <attribute name="representation" type="{urn:mtconnect.org:MTConnectDevices:1.5}RepresentationType" default="VALUE" />
 *       <attribute name="significantDigits" type="{urn:mtconnect.org:MTConnectDevices:1.5}SignificantDigitsValueType" />
 *       <attribute name="discrete" type="{urn:mtconnect.org:MTConnectDevices:1.5}DiscreteType" default="false" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@com.fasterxml.jackson.annotation.JsonTypeName(value = "DataItemType")
@XmlType(name = "DataItemType", propOrder = {
    "source",
    "constraints",
    "filters",
    "initialValue",
    "resetTrigger"
})
public class DataItemType {

    /**
     * source identifies the structural element from which a measured value
     *             originates.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Source")
    @XmlElement(name = "Source")
    protected DataItemSourceType source;
    /**
     * constraints is an optional container that provides a set of expected
     *             values that can be reported for this dataitem.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Constraints")
    @XmlElement(name = "Constraints")
    protected DataItemConstraintsType constraints;
    /**
     * An XML container consisting of one or more types of filter XML
     *             elements.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "Filters")
    @XmlElement(name = "Filters")
    protected FiltersType filters;
    /**
     * initialvalue is an optional XML element that defines the starting
     *             value for a data item as well as the value to be set for the data
     *             item after a reset event.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "InitialValue")
    @XmlElement(name = "InitialValue")
    protected Float initialValue;
    /**
     * resettrigger is an optional XML element that identifies the type of
     *             event that may cause a reset to occur. It is additional information
     *             regarding the meaning of the data that establishes an understanding
     *             of the time frame that the data represents so that the data may be
     *             correctly understood by a client software application.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ResetTrigger")
    @XmlElement(name = "ResetTrigger")
    protected String resetTrigger;
    /**
     * The name of an element or a piece of equipment.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "name")
    @XmlAttribute(name = "name")
    protected String name;
    /**
     * The unique identifier for this element.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "id")
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    /**
     * The type of either a structural element or a dataitem being measured.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "type")
    @XmlAttribute(name = "type", required = true)
    protected String type;
    /**
     * A sub-categorization of the data item type.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "subType")
    @XmlAttribute(name = "subType")
    protected String subType;
    /**
     * Describes the type of statistical calculation performed on a series of
     *           data samples to provide the reported data value.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "statistic")
    @XmlAttribute(name = "statistic")
    protected String statistic;
    /**
     * The unit of measurement for the reported value of the data item.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "units")
    @XmlAttribute(name = "units")
    protected String units;
    /**
     * The native units of measurement for the reported value of the data
     *           item.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "nativeUnits")
    @XmlAttribute(name = "nativeUnits")
    protected String nativeUnits;
    /**
     * nativescale MAY be used to convert the reported value to represent the
     *           original measured value.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "nativeScale")
    @XmlAttribute(name = "nativeScale")
    protected Float nativeScale;
    /**
     * Specifies the kind of information provided by a data item.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "category")
    @XmlAttribute(name = "category", required = true)
    protected CategoryType category;
    /**
     * For measured values relative to a coordinate system like position
     *           sample, the coordinate system being used may be reported.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "coordinateSystem")
    @XmlAttribute(name = "coordinateSystem")
    protected CoordinateSystemEnumType coordinateSystem;
    /**
     * The coordinate system reference to a particular coordinate system
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "coordinateSystemId")
    @XmlAttribute(name = "coordinateSystemId")
    @XmlIDREF
    protected Object coordinateSystemId;
    /**
     * The identifier attribute of the composition element that the reported
     *           data is most closely associated.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "compositionId")
    @XmlAttribute(name = "compositionId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String compositionId;
    /**
     * The rate at which successive samples of a data item are recorded by a
     *           piece of equipment.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "sampleRate")
    @XmlAttribute(name = "sampleRate")
    protected Float sampleRate;
    /**
     * Description of a means to interpret data consisting of multiple data
     *           points or samples reported as a single value. representation is an
     *           optional attribute. representation will define a unique format for
     *           each set of data. representation for timeseries representation,
     *           discrete representation, and value representation are defined in
     *           MTCPart2 Section 7.2.2.12. If representation is not specified, it MUST
     *           be determined to be value representation.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "representation")
    @XmlAttribute(name = "representation")
    protected RepresentationType representation;
    /**
     * The number of significant digits in the reported value.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "significantDigits")
    @XmlAttribute(name = "significantDigits")
    protected BigInteger significantDigits;
    /**
     * An indication signifying whether each value reported for the data
     *           entity is significant and whether duplicate values are to be
     *           suppressed. The value defined MUST be either true removed or false
     *           removed - an XML boolean type. true removed indicates that each update
     *           to the data entity's value is significant and duplicate values
     *           MUSTNOT be suppressed. false removed indicates that duplicated values
     *           MUST be suppressed. If a value is not defined for discrete, the
     *           default value MUST be false removed.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "discrete")
    @XmlAttribute(name = "discrete")
    protected Boolean discrete;

    /**
     * source identifies the structural element from which a measured value
     *             originates.
     * 
     * @return
     *     possible object is
     *     {@link DataItemSourceType }
     *     
     */
    public DataItemSourceType getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataItemSourceType }
     *     
     * @see #getSource()
     */
    public void setSource(DataItemSourceType value) {
        this.source = value;
    }

    /**
     * constraints is an optional container that provides a set of expected
     *             values that can be reported for this dataitem.
     * 
     * @return
     *     possible object is
     *     {@link DataItemConstraintsType }
     *     
     */
    public DataItemConstraintsType getConstraints() {
        return constraints;
    }

    /**
     * Sets the value of the constraints property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataItemConstraintsType }
     *     
     * @see #getConstraints()
     */
    public void setConstraints(DataItemConstraintsType value) {
        this.constraints = value;
    }

    /**
     * An XML container consisting of one or more types of filter XML
     *             elements.
     * 
     * @return
     *     possible object is
     *     {@link FiltersType }
     *     
     */
    public FiltersType getFilters() {
        return filters;
    }

    /**
     * Sets the value of the filters property.
     * 
     * @param value
     *     allowed object is
     *     {@link FiltersType }
     *     
     * @see #getFilters()
     */
    public void setFilters(FiltersType value) {
        this.filters = value;
    }

    /**
     * initialvalue is an optional XML element that defines the starting
     *             value for a data item as well as the value to be set for the data
     *             item after a reset event.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getInitialValue() {
        return initialValue;
    }

    /**
     * Sets the value of the initialValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     * @see #getInitialValue()
     */
    public void setInitialValue(Float value) {
        this.initialValue = value;
    }

    /**
     * resettrigger is an optional XML element that identifies the type of
     *             event that may cause a reset to occur. It is additional information
     *             regarding the meaning of the data that establishes an understanding
     *             of the time frame that the data represents so that the data may be
     *             correctly understood by a client software application.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResetTrigger() {
        return resetTrigger;
    }

    /**
     * Sets the value of the resetTrigger property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getResetTrigger()
     */
    public void setResetTrigger(String value) {
        this.resetTrigger = value;
    }

    /**
     * The name of an element or a piece of equipment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getName()
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * The unique identifier for this element.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getId()
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * The type of either a structural element or a dataitem being measured.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getType()
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * A sub-categorization of the data item type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubType() {
        return subType;
    }

    /**
     * Sets the value of the subType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getSubType()
     */
    public void setSubType(String value) {
        this.subType = value;
    }

    /**
     * Describes the type of statistical calculation performed on a series of
     *           data samples to provide the reported data value.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatistic() {
        return statistic;
    }

    /**
     * Sets the value of the statistic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getStatistic()
     */
    public void setStatistic(String value) {
        this.statistic = value;
    }

    /**
     * The unit of measurement for the reported value of the data item.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getUnits()
     */
    public void setUnits(String value) {
        this.units = value;
    }

    /**
     * The native units of measurement for the reported value of the data
     *           item.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNativeUnits() {
        return nativeUnits;
    }

    /**
     * Sets the value of the nativeUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getNativeUnits()
     */
    public void setNativeUnits(String value) {
        this.nativeUnits = value;
    }

    /**
     * nativescale MAY be used to convert the reported value to represent the
     *           original measured value.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getNativeScale() {
        return nativeScale;
    }

    /**
     * Sets the value of the nativeScale property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     * @see #getNativeScale()
     */
    public void setNativeScale(Float value) {
        this.nativeScale = value;
    }

    /**
     * Specifies the kind of information provided by a data item.
     * 
     * @return
     *     possible object is
     *     {@link CategoryType }
     *     
     */
    public CategoryType getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryType }
     *     
     * @see #getCategory()
     */
    public void setCategory(CategoryType value) {
        this.category = value;
    }

    /**
     * For measured values relative to a coordinate system like position
     *           sample, the coordinate system being used may be reported.
     * 
     * @return
     *     possible object is
     *     {@link CoordinateSystemEnumType }
     *     
     */
    public CoordinateSystemEnumType getCoordinateSystem() {
        return coordinateSystem;
    }

    /**
     * Sets the value of the coordinateSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordinateSystemEnumType }
     *     
     * @see #getCoordinateSystem()
     */
    public void setCoordinateSystem(CoordinateSystemEnumType value) {
        this.coordinateSystem = value;
    }

    /**
     * The coordinate system reference to a particular coordinate system
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCoordinateSystemId() {
        return coordinateSystemId;
    }

    /**
     * Sets the value of the coordinateSystemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     * @see #getCoordinateSystemId()
     */
    public void setCoordinateSystemId(Object value) {
        this.coordinateSystemId = value;
    }

    /**
     * The identifier attribute of the composition element that the reported
     *           data is most closely associated.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompositionId() {
        return compositionId;
    }

    /**
     * Sets the value of the compositionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getCompositionId()
     */
    public void setCompositionId(String value) {
        this.compositionId = value;
    }

    /**
     * The rate at which successive samples of a data item are recorded by a
     *           piece of equipment.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSampleRate() {
        return sampleRate;
    }

    /**
     * Sets the value of the sampleRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     * @see #getSampleRate()
     */
    public void setSampleRate(Float value) {
        this.sampleRate = value;
    }

    /**
     * Description of a means to interpret data consisting of multiple data
     *           points or samples reported as a single value. representation is an
     *           optional attribute. representation will define a unique format for
     *           each set of data. representation for timeseries representation,
     *           discrete representation, and value representation are defined in
     *           MTCPart2 Section 7.2.2.12. If representation is not specified, it MUST
     *           be determined to be value representation.
     * 
     * @return
     *     possible object is
     *     {@link RepresentationType }
     *     
     */
    public RepresentationType getRepresentation() {
        if (representation == null) {
            return RepresentationType.VALUE;
        } else {
            return representation;
        }
    }

    /**
     * Sets the value of the representation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RepresentationType }
     *     
     * @see #getRepresentation()
     */
    public void setRepresentation(RepresentationType value) {
        this.representation = value;
    }

    /**
     * The number of significant digits in the reported value.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSignificantDigits() {
        return significantDigits;
    }

    /**
     * Sets the value of the significantDigits property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     * @see #getSignificantDigits()
     */
    public void setSignificantDigits(BigInteger value) {
        this.significantDigits = value;
    }

    /**
     * An indication signifying whether each value reported for the data
     *           entity is significant and whether duplicate values are to be
     *           suppressed. The value defined MUST be either true removed or false
     *           removed - an XML boolean type. true removed indicates that each update
     *           to the data entity's value is significant and duplicate values
     *           MUSTNOT be suppressed. false removed indicates that duplicated values
     *           MUST be suppressed. If a value is not defined for discrete, the
     *           default value MUST be false removed.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDiscrete() {
        if (discrete == null) {
            return false;
        } else {
            return discrete;
        }
    }

    /**
     * Sets the value of the discrete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     * @see #isDiscrete()
     */
    public void setDiscrete(Boolean value) {
        this.discrete = value;
    }

}
