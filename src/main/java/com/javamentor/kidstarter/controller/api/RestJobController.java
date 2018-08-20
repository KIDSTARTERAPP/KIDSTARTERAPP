package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.Job;
import com.javamentor.kidstarter.service.interfaces.JobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RestJobController {

    static final Logger logger = LoggerFactory.getLogger(RestJobController.class);

    @Autowired
    public JobService jobService;


    @GetMapping("/job/{id}")
    public ResponseEntity<?> getJobId(@PathVariable("id") long id) {
        Job job = jobService.getJobById(id);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @GetMapping("/job/{id}/tags")
    public ResponseEntity<?> getJobsById(@PathVariable("id") long id) {
        return new ResponseEntity<>(jobService.getJobById(id).getTags(), HttpStatus.OK);
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> listAllJobs() {
        List<Job> job = jobService.getAllJob();
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @DeleteMapping("/job/{id}")
    public ResponseEntity<?> deleteJobTag(@PathVariable("id") long id) {
        jobService.deleteJobById(id);
        return new ResponseEntity<Job>(HttpStatus.OK);
    }

    @PostMapping("/job")
    public ResponseEntity<?> addJob(@ModelAttribute("job") Job currentJob) {
        jobService.addJob(currentJob);
        return new ResponseEntity<>(currentJob, HttpStatus.OK);
    }

    @PutMapping("/job/{id}")
    public ResponseEntity<?>  updateJob(@ModelAttribute("job") Job newJob, @PathVariable("id") long id) {
        jobService.updateJob(newJob);
        return new ResponseEntity<>(newJob, HttpStatus.OK);
    }
}



