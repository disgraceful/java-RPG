package com.disgrace.ddripoff.dungeon;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public interface Neighbour {
void displayNeighbours();
void setNeighbour(Enterable enterable);

}
