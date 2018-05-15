package metasystem;

import metasystem.model.*;
import metasystem.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsodring on 26/01/2018
 *
 */

@SpringBootApplication()
public class MetaSystemApplication {

    private IOperationRepository operationRepository;
    private IOrganisationAreaRepository organisationAreaRepository;
    private IOrganisationRepository organisationRepository;
    private IOrganisationSegmentRepository organisationSegmentRepository;
    private IActivityRepository activityRepository;

    public MetaSystemApplication(IOperationRepository operationRepository,
                                 IOrganisationAreaRepository organisationAreaRepository,
                                 IOrganisationRepository organisationRepository,
                                 IOrganisationSegmentRepository organisationSegmentRepository,
                                 IActivityRepository activityRepository) {
        this.operationRepository = operationRepository;
        this.organisationAreaRepository = organisationAreaRepository;
        this.organisationRepository = organisationRepository;
        this.organisationSegmentRepository = organisationSegmentRepository;
        this.activityRepository = activityRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(MetaSystemApplication.class, args);
	}


	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Organisation.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			InputStream data = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("db" + File.separator + "data.xml");

			Organisation organisation = (Organisation) jaxbUnmarshaller.unmarshal(data);

			organisationRepository.save(organisation);

			List<Operation> operations =
                    organisation.getOperation();
			System.out.println("hello");
            organisation.setOperation(operations);
            for (Operation operation: operations) {
                operation.setReferenceOrganisation(organisation);
                operationRepository.save(operation);

                List<OrganisationArea> organisationAreas =
                        operation.getOrganisationArea();

                for (OrganisationArea organisationArea : organisationAreas) {
                    organisationArea.setReferenceOperation(operation);
                    organisationAreaRepository.save(organisationArea);

                    List<OrganisationSegment> organisationSegments =
                        organisationArea.getOrganisationSegments();
                    // Can you init these so we don't need null check??

                    if (organisationSegments != null) {
                        for (OrganisationSegment organisationSegment
                                :organisationSegments) {
                            organisationSegment.
                                    setReferenceOrganisationAreas(
                                            organisationArea);
                            organisationSegmentRepository.save
                                    (organisationSegment);

                            List<Activity> activities = organisationSegment
                                    .getActivities();
                            // Goodness! Get rid of having to check for null!!
                            if (activities != null) {
                                for (Activity activity: activities) {
                                    activity.setReferenceOrganisationSegment
                                            (organisationSegment);
                                    activityRepository.save(activity);
                                }

                            }
                        }
                    }
                    System.out.println(organisationArea);
                }
            }

		}
		catch (JAXBException e) {
			System.out.println(e.toString());
		}
	}
}
