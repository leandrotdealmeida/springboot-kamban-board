package com.japa.kanboard.write.adapter.in;

import com.japa.kanboard.write.domain.application.CreateBucketCommand;
import com.japa.kanboard.write.domain.application.CreateBucketCommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("v1/buckets")
public class BucketController {

    @Autowired
    private CreateBucketCommandHandler handler;

    @PostMapping
    public ResponseEntity create(@RequestBody CreateBucketCommand command) throws URISyntaxException {

        handler.handle(command);

        return ResponseEntity.created(new URI("")).build();
    }
}
