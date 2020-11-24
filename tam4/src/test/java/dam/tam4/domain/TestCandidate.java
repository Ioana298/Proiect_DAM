package dam.tam4.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestCandidate {

	// Define values to be compared with initial candidate
	private final Long DEFAULT_CANDIDATE_ID = 1L;
	private final String DEFAULT_NAME = "test";
	private final List<Internship> DEFAULT_INTERNSHIP = null;

	// Define values to be compared with updated candidate
	private final Long UPDATED_CANDIDATE_ID = 2L;
	private final String UPDATED_DEFAULT_NAME = "update";
	private final List<Internship> UPDATED_DEFAULT_INTERNSHIP = new ArrayList<>();

	// Define initial Candidate
	@Before
	public Candidate initCandidate() {
		Candidate newCandidate = new Candidate();
		newCandidate.setCandidateId(1L);
		newCandidate.setName("test");
		newCandidate.setInternships(null);

		return newCandidate;
	}

	// Update Intial Candidate
	@Before
	public Candidate initUpdatedCandidate() {
		Candidate existingCandidate = initCandidate();
		existingCandidate.setCandidateId(2L);
		existingCandidate.setName("update");
		existingCandidate.setInternships(new ArrayList<>());

		return existingCandidate;
	}

	// Check if Initital Candidate attributes values match Default Candidate values(lines 16-18)
	@Test
	public void checkIfSameCandidate() {
		assertEquals("Check Default Candidate Id", DEFAULT_CANDIDATE_ID, initCandidate().getCandidateId());
		assertEquals("Check Default Candidate Name", DEFAULT_NAME, initCandidate().getName());
		assertEquals("Check Default Candidate Intership", DEFAULT_INTERNSHIP, initCandidate().getInternships());
	}


	// Check if Update Candidate attributes values match Update Candidate values(lines 21-23)
	@Test
	public void checkUpdateCandidate() {
		assertEquals("Check Updated Candidate Id", UPDATED_CANDIDATE_ID, initUpdatedCandidate().getCandidateId());
		assertEquals("Check Updated Candidate Name", UPDATED_DEFAULT_NAME, initUpdatedCandidate().getName());
		assertEquals("Check Updated Candidate Intership", UPDATED_DEFAULT_INTERNSHIP, initUpdatedCandidate().getInternships());
	}
}
