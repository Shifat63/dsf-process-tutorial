package dev.dsf.process.tutorial.service;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;

import dev.dsf.bpe.v1.ProcessPluginApi;
import dev.dsf.bpe.v1.activity.AbstractServiceDelegate;
import dev.dsf.bpe.v1.variables.Variables;

@Slf4j
public class DicTask extends AbstractServiceDelegate
{
	public DicTask(ProcessPluginApi api)
	{
		super(api);
	}

	@Override
	protected void doExecute(DelegateExecution execution, Variables variables)
	{
		log.warn("DSF identifier: "+
				variables.getStartTask().getRestriction().getRecipientFirstRep().getIdentifier().getValue());
	}
}
