package com.monkeysh.blogs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController()
@RequestMapping(value = "/api/blogs")
public class BlogsController {

    private Logger LOGGER = LoggerFactory.getLogger(BlogsController.class);

    @GetMapping()
    public String test(){
        LOGGER.info("in test");
        return "test success";
    }

    /**
     * GET blog by id
     */
    @GetMapping("/{id}")
    public String getBlogById(@PathVariable BigInteger id) {
        LOGGER.info("in getBlogById....");
        LOGGER.info("Requested Blog Id : [ " + id + " ]");
        return "Blog Id : " + id;
    }

}
