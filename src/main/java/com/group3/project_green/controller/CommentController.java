package com.group3.project_green.controller;

import com.group3.project_green.DTO.CommentDTO;
import com.group3.project_green.Service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/comments/")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;

    @PostMapping("")
    public ResponseEntity<Long> register(@RequestBody CommentDTO commentDTO) {
        System.out.println(commentDTO);
        Long pno = service.register(commentDTO);
        return new ResponseEntity<>(pno, HttpStatus.OK);
    }

    @GetMapping(value = "/{pno}/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CommentDTO>> getListByPost(@PathVariable("pno") Long pno) {
        System.out.println("pno가 controller에  " + pno);
        List<CommentDTO> commentList = service.getList(pno);
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @DeleteMapping("/{cno}/remove")
    public ResponseEntity<String> remove(@PathVariable("cno") Long cno) {
        System.out.println(cno);
        service.remove(cno);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

}
