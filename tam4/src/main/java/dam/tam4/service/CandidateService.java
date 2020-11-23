package dam.tam4.service;

import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import dam.tam4.domain.Candidate;
import dam.tam4.repository.CandidateRepository;

@Service
@Transactional
public class CandidateService {

	private final CandidateRepository cRepository;
	
	public CandidateService(CandidateRepository cRepository) {
		this.cRepository = cRepository;
	}
	
	public void addCandidate(Candidate c) {
		Candidate newCandidate=new Candidate();
		newCandidate.setCandidateId(null);
		newCandidate.setName(c.getName());
		newCandidate.setInternships(c.getInternships());
		
		cRepository.save(newCandidate);
	}
	
	public void deleteCandidate(Candidate c) {
		cRepository.delete(c);
	}
	
	public void updateCandidate(Candidate c) {
		Optional <Candidate> possibleCandidate = cRepository.findById(c.getCandidateId());
		Candidate existingCandidate=possibleCandidate.get();
		existingCandidate.setName(c.getName());
		existingCandidate.setInternships(c.getInternships());
		
		cRepository.save(existingCandidate);
	}
	
}
