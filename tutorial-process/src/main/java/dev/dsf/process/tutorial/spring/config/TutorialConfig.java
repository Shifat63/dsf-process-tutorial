package dev.dsf.process.tutorial.spring.config;

import dev.dsf.bpe.v1.documentation.ProcessDocumentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import dev.dsf.bpe.v1.ProcessPluginApi;
import dev.dsf.process.tutorial.service.DicTask;

@Configuration
public class TutorialConfig
{
	@Autowired
	private ProcessPluginApi api;

	@Value("${isLoggingEnabled:false}")
	@ProcessDocumentation(description = "Should logging be enabled")
	private boolean isLoggingEnabled;

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public DicTask dicTask()
	{
		return new DicTask(api, isLoggingEnabled);
	}

}
