package rpg.core.factories;

import rpg.core.dungeon.events.curio.CurioType;

public class CurioEventFactory extends AbstractEventFactory {
	public CurioEventFactory() {
		params = CurioType.CORRUPTED_FOUNTAIN;
	}
}
