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
@Table(name = "operations")
@XmlRootElement(name="operations")
@XmlAccessorType(XmlAccessType.FIELD)
public class Operation
        implements Serializable {

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
     * Name of operation
     *
     * e.g Oslo kommune
     *
     */
    @Column(name = "operation_title")
    @XmlElement(name = "operationTitle")
    private String operationTitle;

    /**
     * Description of operation
     *
     */
    @Column(name = "description", length = 10000)
    private String description;



    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "xxxxx_id",
            referencedColumnName = "id")
    private Organisation referenceOrganisation;


    @XmlElementWrapper(name = "organisationAreas")
    @XmlElement(name = "organisationArea")
    @JsonIgnore
    @OneToMany(mappedBy = "referenceOperation", fetch = FetchType.LAZY)
    private List<OrganisationArea> organisationArea;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationTitle() {
        return operationTitle;
    }

    public void setOperationTitle(String operationTitle) {
        this.operationTitle = operationTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Organisation getReferenceOrganisation() {
        return referenceOrganisation;
    }

    public void setReferenceOrganisation(Organisation referenceOrganisation) {
        this.referenceOrganisation = referenceOrganisation;
    }

    public List<OrganisationArea> getOrganisationArea() {
        return organisationArea;
    }

    public void setOrganisationArea(List<OrganisationArea> organisationArea) {
        this.organisationArea = organisationArea;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", operationTitle='" + operationTitle + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
