//
// This file was generated by the Eclipse Implementation of JAXB, v4.0.5 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
//


package com.hivemq.edge.adapters.mtconnect.schemas.streams.streams_2_4;

import java.math.BigInteger;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * provides information from an {{term(agent)}} defining version
 *         information, storage capacity, and parameters associated with the data
 *         management within the {{term(agent)}}.
 * 
 * <p>Java class for HeaderType complex type</p>.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * 
 * <pre>{@code
 * <complexType name="HeaderType">
 *   <simpleContent>
 *     <extension base="<http://www.w3.org/2001/XMLSchema>string">
 *       <attGroup ref="{urn:mtconnect.org:MTConnectStreams:2.4}HeaderAttributesType"/>
 *       <attribute name="bufferSize" use="required" type="{urn:mtconnect.org:MTConnectStreams:2.4}BufferSizeType" />
 *       <attribute name="nextSequence" use="required" type="{urn:mtconnect.org:MTConnectStreams:2.4}SequenceType" />
 *       <attribute name="lastSequence" use="required" type="{urn:mtconnect.org:MTConnectStreams:2.4}SequenceType" />
 *       <attribute name="firstSequence" use="required" type="{urn:mtconnect.org:MTConnectStreams:2.4}SequenceType" />
 *     </extension>
 *   </simpleContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@com.fasterxml.jackson.annotation.JsonTypeName(value = "HeaderType")
@XmlType(name = "HeaderType", propOrder = {
    "value"
})
public class HeaderType {

    @XmlValue
    protected String value;
    /**
     * The size of the agent's buffer.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "bufferSize")
    @XmlAttribute(name = "bufferSize", required = true)
    protected long bufferSize;
    /**
     * The next sequence number for subsequent requests
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "nextSequence")
    @XmlAttribute(name = "nextSequence", required = true)
    protected BigInteger nextSequence;
    /**
     * The last sequence number available from the agent
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "lastSequence")
    @XmlAttribute(name = "lastSequence", required = true)
    protected BigInteger lastSequence;
    /**
     * The first sequence number available from the agent
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "firstSequence")
    @XmlAttribute(name = "firstSequence", required = true)
    protected BigInteger firstSequence;
    /**
     * The document version
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "version")
    @XmlAttribute(name = "version", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String version;
    /**
     * time the file was created.
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "creationTime")
    @XmlAttribute(name = "creationTime", required = true)
    protected XMLGregorianCalendar creationTime;
    /**
     * Indicates that this was a test document
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "testIndicator")
    @XmlAttribute(name = "testIndicator")
    protected Boolean testIndicator;
    /**
     * The unique instance identifier of this agent process
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "instanceId")
    @XmlAttribute(name = "instanceId", required = true)
    protected BigInteger instanceId;
    /**
     * The sender of the message
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "sender")
    @XmlAttribute(name = "sender", required = true)
    protected String sender;
    /**
     * A timestamp in 8601 format of the last update of the Device
     *           information for any device
     * 
     */
    @com.fasterxml.jackson.annotation.JsonProperty(value = "deviceModelChangeTime")
    @XmlAttribute(name = "deviceModelChangeTime", required = true)
    protected XMLGregorianCalendar deviceModelChangeTime;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * The size of the agent's buffer.
     * 
     */
    public long getBufferSize() {
        return bufferSize;
    }

    /**
     * Sets the value of the bufferSize property.
     * 
     */
    public void setBufferSize(long value) {
        this.bufferSize = value;
    }

    /**
     * The next sequence number for subsequent requests
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNextSequence() {
        return nextSequence;
    }

    /**
     * Sets the value of the nextSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     * @see #getNextSequence()
     */
    public void setNextSequence(BigInteger value) {
        this.nextSequence = value;
    }

    /**
     * The last sequence number available from the agent
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLastSequence() {
        return lastSequence;
    }

    /**
     * Sets the value of the lastSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     * @see #getLastSequence()
     */
    public void setLastSequence(BigInteger value) {
        this.lastSequence = value;
    }

    /**
     * The first sequence number available from the agent
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFirstSequence() {
        return firstSequence;
    }

    /**
     * Sets the value of the firstSequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     * @see #getFirstSequence()
     */
    public void setFirstSequence(BigInteger value) {
        this.firstSequence = value;
    }

    /**
     * The document version
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getVersion()
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * time the file was created.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the creationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     * @see #getCreationTime()
     */
    public void setCreationTime(XMLGregorianCalendar value) {
        this.creationTime = value;
    }

    /**
     * Indicates that this was a test document
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTestIndicator() {
        return testIndicator;
    }

    /**
     * Sets the value of the testIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     * @see #isTestIndicator()
     */
    public void setTestIndicator(Boolean value) {
        this.testIndicator = value;
    }

    /**
     * The unique instance identifier of this agent process
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInstanceId() {
        return instanceId;
    }

    /**
     * Sets the value of the instanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     * @see #getInstanceId()
     */
    public void setInstanceId(BigInteger value) {
        this.instanceId = value;
    }

    /**
     * The sender of the message
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     * @see #getSender()
     */
    public void setSender(String value) {
        this.sender = value;
    }

    /**
     * A timestamp in 8601 format of the last update of the Device
     *           information for any device
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeviceModelChangeTime() {
        return deviceModelChangeTime;
    }

    /**
     * Sets the value of the deviceModelChangeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     * @see #getDeviceModelChangeTime()
     */
    public void setDeviceModelChangeTime(XMLGregorianCalendar value) {
        this.deviceModelChangeTime = value;
    }

}
