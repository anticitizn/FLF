package Light;

public class LED {
    private LightColor lightColor;
    public LED ()
    {
        lightColor = LightColor.Off;
    }

    public void setColor(LightColor lightColor) {
        this.lightColor = lightColor;
    }

    public LightColor getLightColor() {
        return lightColor;
    }
}
