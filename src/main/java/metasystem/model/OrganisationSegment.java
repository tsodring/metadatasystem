package metasystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by tsodring on 26/01/2018
 */

@Entity
@Table(name = "organisation_segment")
@XmlRootElement(name="organisationSegment")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganisationSegment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for organisation.
     * This could be a national identifier company id. For example in Norway
     * we use organisasjonsnummer
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Name og organisation
     *
     * e.g Oslo kommune
     *
     */
    @Column(name = "name")
    private String name;

    /**
     * Description of organisation
     *
     */
    @Column(name = "description", length = 10000)
    private String description;

    @Column(name = "organisation_segment_title", length = 10000)
    private String organisationSegmentTitle;

    @XmlElementWrapper(name = "activities")
    @XmlElement(name = "activity")
    @JsonIgnore
    @OneToMany(mappedBy = "referenceOrganisationSegment",
            fetch = FetchType.LAZY)
    private List<Activity> activities;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_organisation_area_id",
            referencedColumnName = "id")
    private OrganisationArea referenceOrganisationAreas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getOrganisationSegmentTitle() {
        return organisationSegmentTitle;
    }

    public void setOrganisationSegmentTitle(String organisationSegmentTitle) {
        this.organisationSegmentTitle = organisationSegmentTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public OrganisationArea getReferenceOrganisationAreas() {
        return referenceOrganisationAreas;
    }

    public void setReferenceOrganisationAreas(OrganisationArea referenceOrganisationAreas) {
        this.referenceOrganisationAreas = referenceOrganisationAreas;
    }

    @Override
    public String toString() {
        return "OrganisationSegment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
