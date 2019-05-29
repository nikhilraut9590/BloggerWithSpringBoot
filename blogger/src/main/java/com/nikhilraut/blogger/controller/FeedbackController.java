package com.nikhilraut.blogger.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhilraut.blogger.entity.Feedback;
import com.nikhilraut.blogger.exception.FeedbackNotFoundException;
import com.nikhilraut.blogger.repository.IFeedbackRepository;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:4200")
public class FeedbackController {

	@Autowired
	IFeedbackRepository iFeedbackRepository;

	// get all Feedbacks list
	@GetMapping("feedback")
	public ResponseEntity<List<Feedback>> getAllFeedbacks() {
		List<Feedback> feedbackList = iFeedbackRepository.findAll();
		if (feedbackList.isEmpty())
			throw new FeedbackNotFoundException();
		return new ResponseEntity<>(feedbackList, HttpStatus.OK);
	}

	// create new Feedback
	@PostMapping("feedback")
	public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) throws Exception {
		Optional<Feedback> feedback1 = iFeedbackRepository.findById(feedback.getFeedback_Id());
		if (feedback1.isPresent())
			throw new HttpMediaTypeNotSupportedException("");
		return new ResponseEntity<Feedback>(iFeedbackRepository.save(feedback), HttpStatus.CREATED);
	}

	// get Feedback by id
	@GetMapping("feedback/{id}")
	public ResponseEntity<?> getFeedbackById(@PathVariable(value = "id") Integer feedbackId) {
		Optional<Feedback> feedback = iFeedbackRepository.findById(feedbackId);
		if (!feedback.isPresent())
			throw new FeedbackNotFoundException();
		return new ResponseEntity<>(feedback, HttpStatus.OK);

	}

	@DeleteMapping("feedback/{id}")
	public ResponseEntity<String> deleteFeedback(@PathVariable(value = "id") Integer feedbackId) {
		Feedback feedback = iFeedbackRepository.findById(feedbackId).orElseThrow(() -> new FeedbackNotFoundException());
		iFeedbackRepository.delete(feedback);
		return new ResponseEntity<String>("feedback deleted successfully.!", HttpStatus.OK);
	}

	// Update a Note
	@PutMapping("feedback/{id}")
	public ResponseEntity<Feedback> updateFeedback(@PathVariable(value = "id") Integer feedbackId,
			@Valid @RequestBody Feedback feedbackDetails) {

		Feedback feedback = iFeedbackRepository.findById(feedbackId).orElseThrow(() -> new FeedbackNotFoundException());

		feedback.setFeedbacker_emailId(feedbackDetails.getFeedbacker_emailId());
		feedback.setFeedbacker_message(feedbackDetails.getFeedbacker_message());
		feedback.setFeedbacker_name(feedbackDetails.getFeedbacker_name());

		Feedback updatedFeedback = iFeedbackRepository.save(feedback);
		return new ResponseEntity<Feedback>(updatedFeedback, HttpStatus.OK);
	}

}
