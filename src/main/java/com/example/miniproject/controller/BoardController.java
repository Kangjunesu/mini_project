package com.example.miniproject.controller;


import com.example.miniproject.dto.BoardRequestDto;
import com.example.miniproject.dto.BoardResponseDto;
import com.example.miniproject.dto.GeneralResponseDto;
import com.example.miniproject.dto.StatusResponseDto;
import com.example.miniproject.security.UserDetailsImpl;
import com.example.miniproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    //Create
    @PostMapping("/boards")
    public GeneralResponseDto createBoard(@RequestBody BoardRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return boardService.createBoard(requestDto, userDetails);
    }

    //ReadAll
    @GetMapping("/boards")
    public List<BoardResponseDto> getAllBoards(){
        return boardService.getAllBoards();
    }

    //ReadByID
    @GetMapping("/boards/{id}")
    public GeneralResponseDto getBoard(@PathVariable Long id){
        return boardService.getBoard(id);
    }

    @PutMapping("/boards/{id}")
    public GeneralResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return boardService.updateBoard(id, requestDto, userDetails);
    }

    @DeleteMapping("/boards/{id}")
    public StatusResponseDto deleteBoard(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return boardService.deleteBoard(id, userDetails);
    }





}
