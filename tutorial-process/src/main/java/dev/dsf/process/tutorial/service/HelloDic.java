package dev.dsf.process.tutorial.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;

import dev.dsf.bpe.v1.ProcessPluginApi;
import dev.dsf.bpe.v1.activity.AbstractServiceDelegate;
import dev.dsf.bpe.v1.variables.Variables;

public class HelloDic extends AbstractServiceDelegate
{
	public HelloDic(ProcessPluginApi api)
	{
		super(api);
	}

	@Override
	protected void doExecute(DelegateExecution execution, Variables variables)
	{

	}
}
