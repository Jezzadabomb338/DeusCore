package me.jezza.oc.client.lib;

import me.jezza.oc.common.interfaces.AdapterRequest;
import me.jezza.oc.common.utils.ASM;

/**
 * @author Jezza
 */
public abstract class AbstractAdapterRequest<T> extends AbstractRequest implements AdapterRequest {
	private final T adapter;
	private final String modId;

	protected boolean acquired;

	public AbstractAdapterRequest(T adapter) {
		this.adapter = adapter;
		modId = ASM.findOwner(adapter).getModId();
	}

	public T adapter() {
		return adapter;
	}

	public String modId() {
		return modId;
	}

	@Override
	protected boolean validAcquisition() {
		return acquired;
	}

	public void acquired(boolean acquired) {
		this.acquired = acquired;
	}

	@Override
	public void acquire() {
		confirmAcquisition();
	}
}