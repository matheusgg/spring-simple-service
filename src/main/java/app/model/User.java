package app.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Document
public class User {
	@Id
	private String id;
	private String name;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate bithDate;
}
