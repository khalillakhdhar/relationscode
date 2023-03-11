package com.repo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.repo.models.TutorialDetails;

public interface TutorialDetailsInterface {
	ResponseEntity<TutorialDetails> getDetailsById(@PathVariable(value = "id") Long id);
	public ResponseEntity<TutorialDetails> createDetails(Long tutorialId,TutorialDetails detailsRequest);
	public ResponseEntity<HttpStatus> deleteDetails(@PathVariable("id") long id);

}
