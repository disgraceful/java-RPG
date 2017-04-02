package com.disgrace.ddripoff.spells;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum TemporaryEffectType {
	STUN, BUFF, DEBUFF, BLIGHT, BLEED;// MARK, CURSE, DISEASE;
}
