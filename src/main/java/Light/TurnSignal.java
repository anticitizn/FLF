package Light;

import Position.Position;

public class TurnSignal {
    private boolean isOn=false;
    private Position position;

    public TurnSignal(Position position)
    {
        this.position=position;
    }

    public void switchOn()
    {
        isOn=true;
    }

    public void switchOff()
    {
        isOn=false;
    }

    public boolean checkIsOn()
    {
        return isOn;
    }

    public Position getPosition()
    {
        return position;
    }
}
