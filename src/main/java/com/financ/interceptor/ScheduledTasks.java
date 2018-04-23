package com.financ.interceptor;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.financ.comunication.EmailManagement;
import com.financ.model.ScheduledEmail;
import com.financ.repository.generic.RepositoryScheduledEmail;

@Component
public class ScheduledTasks {

	@Autowired
	RepositoryScheduledEmail scheduledEmail;

	@Autowired
	public void setService(RepositoryScheduledEmail scheduledEmail) {
		this.scheduledEmail = scheduledEmail;
	}

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 50000)
	public void scheduledEmail() {

		log.info("scheduledEmail ", dateFormat.format(new Date()));

		Collection<ScheduledEmail> emails = scheduledEmail.getAll(false);

		for (ScheduledEmail scheduledEmail : emails) {
			EmailManagement.send(scheduledEmail);
		}

	}

}