package Light;

import Position.Position;

public interface ILight {

    void switchOn();

    void switchOff();

    boolean checkIsOn();

     int getLEDAmount();

     Position getPosition();
}
