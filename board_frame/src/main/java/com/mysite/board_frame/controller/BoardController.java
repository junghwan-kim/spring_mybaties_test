package com.mysite.board_frame.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysite.board_frame.dto.BoardDTO;
import com.mysite.board_frame.service.BoardService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("/save")
	public String save() {
		return "save";
	}
	
	
	@PostMapping("/save")
	public String save(BoardDTO boardDTO) {
		
		System.out.println("boardDTO" + boardDTO);
		this.boardService.save(boardDTO);
		return "redirect:/list";
	}
	
	
	@GetMapping("/list")
	public String findAll(Model model) {
		List<BoardDTO> boardDTOList = this.boardService.findAll();
		System.out.println("boardDTOList="+boardDTOList);
		model.addAttribute("boardList",boardDTOList);
		return "list";
	}
	
	
	@GetMapping("/detail/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {
		this.boardService.updateHits(id);
		BoardDTO boardDTO = this.boardService.findById(id); //dto로 받아야함.		
		model.addAttribute("board", boardDTO);
		return "detail";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		BoardDTO boardDTO = this.boardService.findById(id);
		model.addAttribute("board",boardDTO);
		return "update";
	}
	
	@PostMapping("/update")
	public String update(BoardDTO boardDTO, Model model) {
		this.boardService.update(boardDTO);
		BoardDTO dto = this.boardService.findById(boardDTO.getId());
		model.addAttribute("board",dto);
		return "redirect:/detail/"+boardDTO.getId();
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.boardService.delete(id);
		return "redirect:/list";
	}
	
	
}
