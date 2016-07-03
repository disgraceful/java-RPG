package ddripoffmodel;

public interface ITemporaryEffect{
	
	public int getEffectDuration();
	public void setEffectDuration(int duration);
	public TemporaryEffect getEffectType();
	public void tickEffect();
	public void expireEffect(StatWrapper[] targets);
	//public Object clone();
	
}
