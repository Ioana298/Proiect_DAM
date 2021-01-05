package dam.tam4.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import dam.tam4.domain.Internship;
import dam.tam4.repository.InternshipRepository;

@Service
@Transactional
public class InternshipService {
	static Logger log = Logger.getLogger(InternshipService.class.getName());
	private final InternshipRepository iRepository;
	
	public InternshipService(InternshipRepository iRepository) {
		this.iRepository = iRepository;
	}
	
	public void addInternship(HttpServletRequest request, Internship i) {
		
		Internship newInternship=new Internship();
		newInternship.setInternshipId(null);
		newInternship.setName(i.getName());
		newInternship.setStartDate(i.getStartDate());
		newInternship.setEndDate(i.getEndDate());
		newInternship.setIsPaid(i.getIsPaid());
		newInternship.setCandidates(i.getCandidates());
		newInternship.setProject(i.getProject());
		
		iRepository.save(newInternship);
		log.info("Internship " + newInternship.toString() + " was added by "+ request.getUserPrincipal().getName());
	}
	
	public void deleteInternship(HttpServletRequest request, Long id) {
		log.info("Internship " + iRepository.findById(id).get().toString() + " was deleted by "+ request.getUserPrincipal().getName());
		iRepository.delete(iRepository.findById(id).get());
	}
	
	public void updateInternship(HttpServletRequest request, Internship i) {
		Optional <Internship> possibleInternship = iRepository.findById(i.getInternshipId());
		Internship existingInternship=possibleInternship.get();
		existingInternship.setName(i.getName());
		existingInternship.setCandidates(i.getCandidates());
		existingInternship.setProject(i.getProject());
		existingInternship.setStartDate(i.getStartDate());
		existingInternship.setEndDate(i.getEndDate());
		existingInternship.setIsPaid(i.getIsPaid());
		
		iRepository.save(existingInternship);
		log.info("Internship " + existingInternship.toString() + " was updated by "+ request.getUserPrincipal().getName());
	}

	public List <Internship> getAllInternships(){
		return iRepository.findAll();
	}
}

