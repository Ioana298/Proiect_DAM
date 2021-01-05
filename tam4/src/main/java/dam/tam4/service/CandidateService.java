package dam.tam4.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import dam.tam4.domain.Candidate;
import dam.tam4.repository.CandidateRepository;

@Service
@Transactional
public class CandidateService {

	static Logger log = Logger.getLogger(CandidateService.class.getName());
	
	private final CandidateRepository cRepository;

	public CandidateService(CandidateRepository cRepository	) {
		this.cRepository = cRepository;
	}

	public void addCandidate(HttpServletRequest request, Candidate c) {

		Candidate newCandidate=new Candidate();
		newCandidate.setCandidateId(null);
		newCandidate.setName(c.getName());
		newCandidate.setEmail(c.getEmail());
		newCandidate.setPhoneNumber(c.getPhoneNumber());
		newCandidate.setInternships(c.getInternships());

		cRepository.save(newCandidate);
		log.info("Candidate " + newCandidate.toString() + " was added by "+ request.getUserPrincipal().getName());
	}

	public void deleteCandidate(HttpServletRequest request, Long id) {
		log.info("Candidate " + cRepository.findById(id).get().toString() + " was deleted by "+ request.getUserPrincipal().getName());
		
		cRepository.delete(cRepository.findById(id).get());
	}

	public void updateCandidate(HttpServletRequest request, Candidate c) {
		Optional <Candidate> possibleCandidate = cRepository.findById(c.getCandidateId());
		Candidate existingCandidate=possibleCandidate.get();
		existingCandidate.setName(c.getName());
		existingCandidate.setEmail(c.getEmail());
		existingCandidate.setPhoneNumber(c.getPhoneNumber());
		existingCandidate.setInternships(c.getInternships());

		cRepository.save(existingCandidate);
		log.info("Candidate " + existingCandidate.toString() + " was updated by "+ request.getUserPrincipal().getName());
	}
	public List <Candidate> getAllCandidates(){
		return cRepository.findAll();
	}
}
