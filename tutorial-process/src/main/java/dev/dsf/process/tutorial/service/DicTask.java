package dev.dsf.process.tutorial.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;

import dev.dsf.bpe.v1.ProcessPluginApi;
import dev.dsf.bpe.v1.activity.AbstractServiceDelegate;
import dev.dsf.bpe.v1.variables.Variables;

@Slf4j
public class DicTask extends AbstractServiceDelegate
{
	private boolean isLoggingEnabled;
	public DicTask(ProcessPluginApi api, boolean isLoggingEnabled)
	{
		super(api);
		this.isLoggingEnabled = isLoggingEnabled;
	}

	@Override
	protected void doExecute(DelegateExecution execution, Variables variables)
	{
		if(this.isLoggingEnabled){
			log.warn("DSF Organization Identifier: "+
					variables.getStartTask().getRestriction().getRecipientFirstRep().getIdentifier().getValue());

			String tutorialInputParameter = String.valueOf(api.getTaskHelper().getFirstInputParameterStringValue(
					variables.getStartTask(), "http://dsf.dev/fhir/CodeSystem/tutorial", "tutorial-input"));
			log.warn("DSF passed input parameter: "+tutorialInputParameter);

		}
	}
}
