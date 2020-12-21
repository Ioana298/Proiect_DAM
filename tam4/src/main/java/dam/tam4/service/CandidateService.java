package dam.tam4.service;

import java.util.List;
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
		newCandidate.setEmail(c.getEmail());
		newCandidate.setPhoneNumber(c.getPhoneNumber());
		newCandidate.setInternships(c.getInternships());
		
		cRepository.save(newCandidate);
	}
	
	public void deleteCandidate(Long id) {
		cRepository.delete(cRepository.findById(id).get());
	}
	
	public void updateCandidate(Candidate c) {
		Optional <Candidate> possibleCandidate = cRepository.findById(c.getCandidateId());
		Candidate existingCandidate=possibleCandidate.get();
		existingCandidate.setName(c.getName());
		existingCandidate.setEmail(c.getEmail());
		existingCandidate.setPhoneNumber(c.getPhoneNumber());
		existingCandidate.setInternships(c.getInternships());
		
		cRepository.save(existingCandidate);
	}
	public List <Candidate> getAllCandidates(){
		return cRepository.findAll();
	}
}
