package com.repo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.repo.models.TutorialDetails;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TutorialDetailsController {
  @Autowired
  
  private TutorialDetailsService tutorialDetailsService;

  @GetMapping({ "/details/{id}", "/tutorials/{id}/details" })
  public ResponseEntity<TutorialDetails> getDetailsById(@PathVariable(value = "id") Long id) {
	return  tutorialDetailsService.getDetailsById(id);
  }

  @PostMapping("/tutorials/{tutorialId}/details")
  public ResponseEntity<TutorialDetails> createDetails(@PathVariable(value = "tutorialId") Long tutorialId,
      @RequestBody TutorialDetails detailsRequest) {
	  return tutorialDetailsService.createDetails(tutorialId, detailsRequest);
  }

//  @PutMapping("/details/{id}")
//  public ResponseEntity<TutorialDetails> updateDetails(@PathVariable("id") long id,
//      @RequestBody TutorialDetails detailsRequest) {
//    TutorialDetails details = detailsRepository.findById(id)
//        .orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found"));
//
//    details.setCreatedBy(detailsRequest.getCreatedBy());
//
//    return new ResponseEntity<>(detailsRepository.save(details), HttpStatus.OK);
//  }

  @DeleteMapping("/details/{id}")
  public ResponseEntity<HttpStatus> deleteDetails(@PathVariable("id") long id) {
    return tutorialDetailsService.deleteDetails(id);
  }

}
