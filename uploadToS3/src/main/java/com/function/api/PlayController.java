package com.function.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.function.dto.PlayListResponseDto;
import com.function.service.PlayService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/plays")
@RequiredArgsConstructor
public class PlayController {

	private final PlayService playService;

	@ApiOperation(value = "{id}에 해당하는 게임 기록 가져오기")
	@GetMapping("/{id}")
	public ResponseEntity<PlayListResponseDto> getOnePlayById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(playService.findById(id));
	}

	@ApiOperation(value = "아이디가 {id}인 유저의 모든 게임 기록 가져오기")
	@GetMapping("/users/{id}")
	public ResponseEntity<List<PlayListResponseDto>> getPlayByUserId(@PathVariable("id") Long userId) {
		return ResponseEntity.ok(playService.findByUserId(userId));
	}

}
