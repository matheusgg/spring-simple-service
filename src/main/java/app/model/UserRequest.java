package app.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class UserRequest {
	private String name;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate bithDate;
}
