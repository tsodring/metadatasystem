package metasystem.model;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by tsodring on 26/01/2018
 */

@Entity
@Table(name = "organisation")
@XmlRootElement
public class Organisation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Unique identifier for organisation.
     * This could be a national identifier company id. For example in Norway
     * we use organisasjonsnummer
     *
     */
    @Id
    @Column(name = "id", nullable = false)
    private String organisation_id;

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


    /*
    @JsonIgnore
    public Functionality getReferenceParentFunctionality() {
        return referenceParentFunctionality;
    }

    @XmlTransient
    public void setReferenceParentFunctionality(Functionality referenceParentFunctionality) {
        this.referenceParentFunctionality = referenceParentFunctionality;
    }
    */
}
