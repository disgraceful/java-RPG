package ddripoffmodel;

public interface ITemporaryEffect {
	
	public int getEffectDuration();
	public void setEffectDuration(int duration);
	public TemporaryEffect getEffect();
	public void applyEffect();
}
