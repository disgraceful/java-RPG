package com.disgrace.ddripoff.abilities;

import com.disgrace.ddripoff.characters.stats.StatWrapper;
/**
 * 
 * @author Kashapov
 *
 * describes abilities which works through time 
 */
public interface ITemporaryEffect{
	
	public int getEffectDuration();
	public void setEffectDuration(int duration);
	public TemporaryEffect getEffectType();
	public void tickEffect(StatWrapper t);
	public void expireEffect(StatWrapper[] targets);
}
