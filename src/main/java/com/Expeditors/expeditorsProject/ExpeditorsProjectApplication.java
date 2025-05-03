package com.Expeditors.expeditorsProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*@ComponentScan({"main.controllers", "main.repositories"})
@EnableJpaRepositories("main.repositories")*/
public class ExpeditorsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpeditorsProjectApplication.class, args);
	}

//	@RestController
//	public class TestController {
//
//		@GetMapping("/test")
//		public String test() {
//			return "Hello!";
//		}
//	}
}

//@Component
//class ScheduledTasks {
//
//	@Autowired
//	private InvoiceProcessor invoiceProcessor;
//
//	@Scheduled(cron = "0 0 8 * * ?") // Every day at 8 AM
//	public void sendDailyInvoices() {
//		invoiceProcessor.processInvoices();
//	}
//}
