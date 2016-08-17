package abilities.ddripoffmodel;

import ddripoffmodel.StatWrapper;
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
