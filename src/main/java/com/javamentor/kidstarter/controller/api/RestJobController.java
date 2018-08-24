package com.javamentor.kidstarter.controller.api;

import com.javamentor.kidstarter.model.Job;
import com.javamentor.kidstarter.model.user.Kid;
import com.javamentor.kidstarter.model.user.Teacher;
import com.javamentor.kidstarter.model.user.User;
import com.javamentor.kidstarter.service.interfaces.JobService;
import com.javamentor.kidstarter.service.interfaces.KidService;
import com.javamentor.kidstarter.service.interfaces.RoleService;
import com.javamentor.kidstarter.service.interfaces.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RestJobController {

    static final Logger logger = LoggerFactory.getLogger(RestJobController.class);

    @Autowired
    private JobService jobService;

    @Autowired
    private KidService kidService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private RoleService roleService;

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
    public HttpStatus deleteJobById(@PathVariable("id") long id) {
        jobService.deleteJobById(id);
        return HttpStatus.OK;
    }

    @PostMapping("/job")
    public ResponseEntity<?> addJob(@RequestBody Job currentJob) {
        jobService.addJob(currentJob);
        return new ResponseEntity<>(currentJob, HttpStatus.OK);
    }

    @PutMapping("/job")
    public ResponseEntity<?> updateJob(@RequestBody Job job) {
        Job currentJob = jobService.getJobById(job.getId());
        job.setKids(currentJob.getKids());
        job.setMentors(currentJob.getMentors());
        job.setTeachers(currentJob.getTeachers());
        jobService.updateJob(job);
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PutMapping("/job/wish_job/{id}")
    public HttpStatus addJobToWishList(@PathVariable("id") Long jobId) {
        System.out.println("!!! " + jobId);
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        HttpStatus status = HttpStatus.NOT_MODIFIED;
        if (principal.getAuthorities().contains(roleService.getByName("KID"))) {
            Kid currentKid = kidService.getUserKidById(principal.getId());
            Job currentJob = jobService.getJobById(jobId);
            if (!currentKid.getJobInterest().contains(currentJob)) {
                currentKid.getJobInterest().add(currentJob);
                kidService.updateKid(currentKid);
                status = HttpStatus.OK;
            }
        } else if (principal.getAuthorities().contains(roleService.getByName("TEACHER"))) {
            Teacher currentTeacher = teacherService.getUserTeacherById(principal.getId());
            Job currentJob = jobService.getJobById(jobId);
            if (!currentTeacher.getSpecialization().contains(currentJob)) {
                currentTeacher.getSpecialization().add(jobService.getJobById(jobId));
                teacherService.updateTeacher(currentTeacher);
                status = HttpStatus.OK;
            }
        }
        return status;
    }
}



