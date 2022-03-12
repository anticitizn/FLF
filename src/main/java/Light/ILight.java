package Light;

import Position.Position;

public interface ILight {
    boolean checkIsOn();

     int getLEDAmount();

     Position getPosition();
}
