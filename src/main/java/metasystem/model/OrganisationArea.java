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
@Table(name = "organisation_area")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganisationArea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


    @XmlElement(name = "organisationAreaTitle")
    @Column(name = "organisation_area_title")
    private String organisationAreaTitle;

    /**
     * Description of organisation
     *
     */
    @Column(name = "description", length = 10000)
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_operations_id",
            referencedColumnName = "id")
    private Operation referenceOperation;


    @XmlElementWrapper(name = "organisationSegments")
    @XmlElement(name = "organisationSegment")
    @JsonIgnore
    @OneToMany(mappedBy = "referenceOrganisationAreas", fetch = FetchType.LAZY)
    private List<OrganisationSegment> organisationSegments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganisationAreaTitle() {
        return organisationAreaTitle;
    }

    public void setOrganisationAreaTitle(String organisationAreaTitle) {
        this.organisationAreaTitle = organisationAreaTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Operation getReferenceOperation() {
        return referenceOperation;
    }

    public void setReferenceOperation(Operation referenceOperation) {
        this.referenceOperation = referenceOperation;
    }

    public List<OrganisationSegment> getOrganisationSegments() {
        return organisationSegments;
    }

    public void setOrganisationSegments(List<OrganisationSegment> organisationSegments) {
        this.organisationSegments = organisationSegments;
    }

    @Override
    public String toString() {
        return "OrganisationArea{" +
                "organisationAreaTitle='" + organisationAreaTitle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
