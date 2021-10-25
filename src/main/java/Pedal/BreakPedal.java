package Pedal;

public class BreakPedal extends Pedal{

    public BreakPedal()
    {
        super();
    }

    public int press()
    {
        speed=speed-4;

        if(speed<=0)
        {
            speed=0;
        }
        return speed;
    }
}
