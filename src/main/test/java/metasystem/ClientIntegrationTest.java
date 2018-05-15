package java.metasystem;

import metasystem.model.Activity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static metasystem.utils.Constants.ACTIVITY;
import static metasystem.utils.Constants.SLASH;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createClient() {

        Activity activity = new Activity();
        activity.setTitle("Name of activity");
        activity.setActivityDescription("description");

        ResponseEntity<Activity> responseEntity =
                restTemplate.postForEntity(SLASH + ACTIVITY, activity,
                        Activity.class);
        Activity client = responseEntity.getBody();
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("description", client.getActivityDescription());
    }
}
