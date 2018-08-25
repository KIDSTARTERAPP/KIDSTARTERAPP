package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.Tag;
import com.javamentor.kidstarter.service.interfaces.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestTagController {

	static final Logger logger = LoggerFactory.getLogger(RestTagController.class);

	@Autowired
	public TagService tagService;


	@GetMapping("/tag/{id}")
	public ResponseEntity<?> getTagId(@PathVariable("id") long id) {
		Tag tag = tagService.getTagId(id);
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}

	@GetMapping("/tag/{id}/jobs")
	public ResponseEntity<?> getJobsById(@PathVariable("id") long id) {
		return new ResponseEntity<>(tagService.getTagId(id).getJobs(), HttpStatus.OK);
	}

	@GetMapping("/tags")
	public ResponseEntity<List<Tag>> listAllTags() {
		List<Tag>tag = tagService.getAllTag();
		return new ResponseEntity<>(tag, HttpStatus.OK);
	}

    @DeleteMapping("/tag/{id}")
    public HttpStatus deleteTag(@PathVariable("id") long id) {
        tagService.deleteTagById(id);
        return HttpStatus.OK;
    }

	@PostMapping("/tag")
	public ResponseEntity<?> addTag(@ModelAttribute("name") Tag newTag) {
		tagService.addTag(newTag);
		return new ResponseEntity<>(newTag, HttpStatus.CREATED);
	}

	@PutMapping("/tag")
	public ResponseEntity<?> updateTag(@ModelAttribute("tag") Tag newTag) {
		tagService.updateTag(newTag);
		return new ResponseEntity<>(newTag, HttpStatus.OK);
	}

	@GetMapping("/select_tags")
	public ResponseEntity<List<Tag>> getRolesByStringArray(@RequestParam("tags") String list) {
		List<String> tags = Arrays.asList(list.replace("\"","")
				.replace("]","")
				.replace("[","")
				.split(","));
		return new ResponseEntity<>(tagService.getTagsByNameList(tags), HttpStatus.OK);
	}
}
