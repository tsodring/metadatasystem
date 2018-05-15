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
@Table(name = "organisation")
@XmlRootElement(name="organisation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Organisation
        implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Organisation identifier
     * This could be a national identifier company id. For example in Norway
     * we use organisasjonsnummer
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "organisation_id")
    private String organisationId;

    /**
     * Name of organisation
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

    @XmlElementWrapper(name = "operations")
    @XmlElement(name = "operation")
    @JsonIgnore
    @OneToMany(mappedBy = "referenceOrganisation", fetch = FetchType.LAZY)
    private List<Operation> operation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(String organisationId) {
        this.organisationId = organisationId;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Operation> getOperation() {
        return operation;
    }

    public void setOperation(List<Operation> operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "id=" + id +
                ", organisationId='" + organisationId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
