package dam.tam4.domain;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class TestCandidate {

	@Before
	public Candidate initializeCandidate() {
		Candidate newCandidate=new Candidate();
		newCandidate.setCandidateId((long) 1);
		newCandidate.setName("Dorel");
		newCandidate.setInternships(null);
		
		return newCandidate;
	}
	
	@Test
	public void testPrintMessage() {
		Candidate existingCandidate=new Candidate();
		existingCandidate.setCandidateId((long) 1);
		existingCandidate.setName("Gigel");
		existingCandidate.setInternships(null);
		
		
		assertEquals(existingCandidate.getCandidateId().toString(), initializeCandidate().getCandidateId().toString());
		assertEquals(existingCandidate.getName().toString(), initializeCandidate().getName().toString());
	}
}
