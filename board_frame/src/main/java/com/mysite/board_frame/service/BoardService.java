package com.mysite.board_frame.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.board_frame.dto.BoardDTO;
import com.mysite.board_frame.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;

	public void save(BoardDTO boardDTO) {
		this.boardRepository.save(boardDTO);		
	}

	public List<BoardDTO> findAll() {			
		return this.boardRepository.findAll();
	}

	public void updateHits(Long id) {
		this.boardRepository.updateHits(id);		
	}

	public BoardDTO findById(Long id) {
		
		return this.boardRepository.findById(id);
	}

	public void update(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		this.boardRepository.update(boardDTO);
	}

	public void delete(Long id) {
		this.boardRepository.delete(id);
		
	}
}
