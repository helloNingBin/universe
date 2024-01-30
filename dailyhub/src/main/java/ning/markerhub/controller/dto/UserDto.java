package ning.markerhub.controller.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {

	private Long id;

	private String username;
	private String avatar;

	private LocalDateTime lasted;
	private LocalDateTime created;
}
