package org.aadi.springboot.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

	private String message;
	private List<String> details;
    private HttpStatus status;
    private LocalDateTime timestamp;
}
