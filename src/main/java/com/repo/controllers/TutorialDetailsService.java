package com.repo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.repo.exception.ResourceNotFoundException;
import com.repo.models.Tutorial;
import com.repo.models.TutorialDetails;
import com.repo.repositories.TutorialDetailsRepository;
import com.repo.repositories.TutorialRepository;

@Service
public class TutorialDetailsService implements TutorialDetailsInterface {
	 @Autowired
	  private TutorialDetailsRepository detailsRepository;

	  @Autowired
	  private TutorialRepository tutorialRepository;


	  @Override
	  public ResponseEntity<TutorialDetails> getDetailsById(@PathVariable(value = "id") Long id) {
	    TutorialDetails details = detailsRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial Details with id = " + id));

	    return new ResponseEntity<>(details, HttpStatus.OK);
	  }


	  @Override
	  public ResponseEntity<TutorialDetails> createDetails(@PathVariable(value = "tutorialId") Long tutorialId,
	      @RequestBody TutorialDetails detailsRequest) {
	    Tutorial tutorial = tutorialRepository.findById(tutorialId)
	        .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + tutorialId));

	    detailsRequest.setCreatedOn(new java.util.Date());
	    detailsRequest.setTutorial(tutorial);
	    TutorialDetails details = detailsRepository.save(detailsRequest);

	    return new ResponseEntity<>(details, HttpStatus.CREATED);
	  }


@Override
public ResponseEntity<HttpStatus> deleteDetails(@PathVariable("id") long id) {
	    detailsRepository.deleteById(id);

	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }

	
}
