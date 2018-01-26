package metasystem.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by tsodring on 26/01/2018
 *
 */

@Entity
@Table(name = "activity")
@XmlRootElement
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for each activity.
     *
     * Currently just an increment
     *
     */
    @Id
    @Column(name = "id", nullable = false)
    private Long activityId;

    /**
     * Activity name
     *
     * e.g TBD
     *
     */
    @Column(name = "activity_name", nullable = false)
    private String activityName;

    /**
     * Description of activity
     *
     */
    @Column(name = "activity_description", length = 10000)
    private String activityDescription;


    /**
     * Registration
     *
     */
    @Column(name = "registration")
    private String registration;

    /**
     * Analogue document format
     *
     */
    @Column(name = "analogue_document_format")
    private String analogueDocumentFormat;

    /**
     * Analogue document storage
     *
     */
    @Column(name = "analogue_document_storage")
    private String analogueDocumentStorage;

    /**
     * Digital document format
     *
     */
    @Column(name = "digital_document_format")
    private String digitalDocumentFormat;

    /**
     * Digital document storage
     *
     */
    @Column(name = "digital_document_storage")
    private String digitalDocumentStorage;

    /**
     * Deletion/retention deadline
     *
     */
    @Column(name = "deletion_retention_deadline")
    private String deletionRetentionDeadline;


    /**
     * depositToArchiveDeadline
     *
     */
    @Column(name = "deposit_to_archive_deadline")
    private String depositToArchiveDeadline;

    /**
     * formatForArchiving
     *
     */
    @Column(name = "format_for_archiving")
    private String formatForArchiving;

    /**
     * formatForArchiving
     *
     */
    @Column(name = "process_metadata")
    private String processMetadata;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
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
                Objects.equals(activityName, activity.activityName) &&
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

        return Objects.hash(activityId, activityName, activityDescription,
                registration, analogueDocumentFormat, analogueDocumentStorage,
                digitalDocumentFormat, digitalDocumentStorage,
                deletionRetentionDeadline, depositToArchiveDeadline,
                formatForArchiving, processMetadata);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId='" + activityId + '\'' +
                ", activityName='" + activityName + '\'' +
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
