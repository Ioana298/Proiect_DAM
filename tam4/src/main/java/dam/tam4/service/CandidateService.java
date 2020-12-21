package dam.tam4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dam.tam4.domain.Candidate;
import dam.tam4.domain.Internship;
import dam.tam4.repository.CandidateRepository;
import dam.tam4.repository.InternshipRepository;

@Service
@Transactional
public class CandidateService {

	private final CandidateRepository cRepository;
	private final InternshipRepository iRepository;

	public CandidateService(CandidateRepository cRepository, InternshipRepository iRepository) {
		this.cRepository = cRepository;
		this.iRepository = iRepository;
	}

	public void addCandidate(Candidate c) {

		Candidate newCandidate=new Candidate();
		newCandidate.setCandidateId(null);
		newCandidate.setName(c.getName());
		newCandidate.setEmail(c.getEmail());
		newCandidate.setPhoneNumber(c.getPhoneNumber());
		newCandidate.setInternships(c.getInternships() == null? null: saveInternship(c.getInternships()));

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
		existingCandidate.setInternships(c.getInternships() == null? null: saveInternship(c.getInternships()));

		cRepository.save(existingCandidate);
	}
	public List <Candidate> getAllCandidates(){
		return cRepository.findAll();
	}

	private List<Internship> saveInternship(List<Internship> appliedInternships){

		//Lista goala ce va contine internshipurile din baza de date
		List<Internship> existentInternships = new ArrayList<>();

		//iteram prin lista trimisa din interfata / modal
		for (Internship i: appliedInternships) {

			// pentru fiecare element din modal, luam id-ul si cautam pe baza lui internshipul din baza de date
			Internship existentInternship = iRepository.findById(i.getInternshipId()).get();
			
			//adaugam fiecare internship gasit in lista
			existentInternships.add(existentInternship);
			}
		
		System.out.println(existentInternships);
		//returnam lista cu internshipurile gasite
		return existentInternships;
	}
}
