package app;

import static java.util.stream.Collectors.joining;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SimpleController {

	@RequestMapping(value = "/generateMessage")
	@HystrixCommand(fallbackMethod = "generateDefaultMessage")
	public String generateMessage(final String raiseErr) {
		log.info("Executing generateMessage...");
		if ("true".equals(raiseErr)) {
			throw new RuntimeException("Exceção para testar o Hytrix!");
		}
		return "Mensagem de Teste";
	}

	public String generateDefaultMessage(final String riseException) {
		log.info("Executing fallback generateDefaultMessage...");
		return "Mensagem Padrão";
	}

	@RequestMapping(value = "/test-headers")
	public String testHeaders(@RequestHeader final HttpHeaders headers) {
		return headers.keySet().stream().collect(joining(", "));
	}

	@RequestMapping(value = "/file", method = POST)
	public void receiveFile(@RequestPart("file") final MultipartFile file) {
		log.info("File name: {} / Original name: {} / Size: {} / Content type: {}", file.getName(), file.getOriginalFilename(), file.getSize(), file.getContentType());
	}

	@RequestMapping(value = "/hi")
	public String hi() {
		return "Hi!";
	}

	@RequestMapping(value = "/simulate")
	public String simulate() {
		throw new RuntimeException("Simulation Exception");
	}
}
