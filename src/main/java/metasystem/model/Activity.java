package metasystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by tsodring on 26/01/2018
 *
 */

@Entity
@Table(name = "activity")
@XmlRootElement(name ="activity")
@XmlAccessorType(XmlAccessType.FIELD)
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for each activity.
     *
     * Currently just an increment
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long activityId;

    /**
     * Activity name
     *
     * e.g TBD
     *
     */
    @XmlElement(name = "title")
    @Column(name = "title")
    private String title;

    /**
     * Description of activity
     *
     */
    @XmlElement(name = "activityDescription")
    @Column(name = "activity_description", length = 10000)
    private String activityDescription;


    /**
     * Registration
     *
     */
    @XmlElement(name = "registration")
    @Column(name = "registration")
    private String registration;

    /**
     * Analogue document format
     *
     */
    @XmlElement(name = "analogueDocumentFormat")
    @Column(name = "analogue_document_format")
    private String analogueDocumentFormat;

    /**
     * Analogue document storage
     *
     */
    @XmlElement(name = "analogueDocumentStorage")
    @Column(name = "analogue_document_storage")
    private String analogueDocumentStorage;

    /**
     * Digital document format
     *
     */
    @XmlElement(name = "digitalDocumentFormat")
    @Column(name = "digital_document_format")
    private String digitalDocumentFormat;

    /**
     * Digital document storage
     *
     */
    @XmlElement(name = "digitalDocumentStorage")
    @Column(name = "digital_document_storage")
    private String digitalDocumentStorage;

    /**
     * Deletion/retention deadline
     *
     */
    @XmlElement(name = "deletionRetentionDeadline")
    @Column(name = "deletion_retention_deadline")
    private String deletionRetentionDeadline;

    /**
     * depositToArchiveDeadline
     *
     */
    @XmlElement(name = "depositToArchiveDeadline")
    @Column(name = "deposit_to_archive_deadline")
    private String depositToArchiveDeadline;

    /**
     * formatForArchiving
     *
     */
    @XmlElement(name = "formatForArchiving")
    @Column(name = "format_for_archiving")
    private String formatForArchiving;

    /**
     * formatForArchiving
     *
     */
    @XmlElement(name = "processMetadata")
    @Column(name = "process_metadata")
    private String processMetadata;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_organisation_segment_id",
            referencedColumnName = "id")
    private OrganisationSegment referenceOrganisationSegment;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getAnalogueDocumentFormat() {
        return analogueDocumentFormat;
    }

    public void setAnalogueDocumentFormat(String analogueDocumentFormat) {
        this.analogueDocumentFormat = analogueDocumentFormat;
    }

    public String getAnalogueDocumentStorage() {
        return analogueDocumentStorage;
    }

    public void setAnalogueDocumentStorage(String analogueDocumentStorage) {
        this.analogueDocumentStorage = analogueDocumentStorage;
    }

    public String getDigitalDocumentFormat() {
        return digitalDocumentFormat;
    }

    public void setDigitalDocumentFormat(String digitalDocumentFormat) {
        this.digitalDocumentFormat = digitalDocumentFormat;
    }

    public String getDigitalDocumentStorage() {
        return digitalDocumentStorage;
    }

    public void setDigitalDocumentStorage(String digitalDocumentStorage) {
        this.digitalDocumentStorage = digitalDocumentStorage;
    }

    public String getDeletionRetentionDeadline() {
        return deletionRetentionDeadline;
    }

    public void setDeletionRetentionDeadline(String deletionRetentionDeadline) {
        this.deletionRetentionDeadline = deletionRetentionDeadline;
    }

    public String getDepositToArchiveDeadline() {
        return depositToArchiveDeadline;
    }

    public void setDepositToArchiveDeadline(String depositToArchiveDeadline) {
        this.depositToArchiveDeadline = depositToArchiveDeadline;
    }

    public String getFormatForArchiving() {
        return formatForArchiving;
    }

    public void setFormatForArchiving(String formatForArchiving) {
        this.formatForArchiving = formatForArchiving;
    }

    public String getProcessMetadata() {
        return processMetadata;
    }

    public void setProcessMetadata(String processMetadata) {
        this.processMetadata = processMetadata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Objects.equals(activityId, activity.activityId) &&
                Objects.equals(title, activity.title) &&
                Objects.equals(activityDescription,
                        activity.activityDescription) &&
                Objects.equals(registration, activity.registration) &&
                Objects.equals(analogueDocumentFormat,
                        activity.analogueDocumentFormat) &&
                Objects.equals(analogueDocumentStorage,
                        activity.analogueDocumentStorage) &&
                Objects.equals(digitalDocumentFormat,
                        activity.digitalDocumentFormat) &&
                Objects.equals(digitalDocumentStorage,
                        activity.digitalDocumentStorage) &&
                Objects.equals(deletionRetentionDeadline,
                        activity.deletionRetentionDeadline) &&
                Objects.equals(depositToArchiveDeadline,
                        activity.depositToArchiveDeadline) &&
                Objects.equals(formatForArchiving,
                        activity.formatForArchiving) &&
                Objects.equals(processMetadata, activity.processMetadata);
    }

    @Override
    public int hashCode() {

        return Objects.hash(activityId, title, activityDescription,
                registration, analogueDocumentFormat, analogueDocumentStorage,
                digitalDocumentFormat, digitalDocumentStorage,
                deletionRetentionDeadline, depositToArchiveDeadline,
                formatForArchiving, processMetadata);
    }

    public OrganisationSegment getReferenceOrganisationSegment() {
        return referenceOrganisationSegment;
    }

    public void setReferenceOrganisationSegment(OrganisationSegment referenceOrganisationSegment) {
        this.referenceOrganisationSegment = referenceOrganisationSegment;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId='" + activityId + '\'' +
                ", title='" + title + '\'' +
                ", activityDescription='" + activityDescription + '\'' +
                ", registration='" + registration + '\'' +
                ", analogueDocumentFormat='" + analogueDocumentFormat + '\'' +
                ", analogueDocumentStorage='" + analogueDocumentStorage + '\'' +
                ", digitalDocumentFormat='" + digitalDocumentFormat + '\'' +
                ", digitalDocumentStorage='" + digitalDocumentStorage + '\'' +
                ", deletionRetentionDeadline='" + deletionRetentionDeadline + '\'' +
                ", depositToArchiveDeadline='" + depositToArchiveDeadline + '\'' +
                ", formatForArchiving='" + formatForArchiving + '\'' +
                ", processMetadata='" + processMetadata + '\'' +
                '}';
    }
}
