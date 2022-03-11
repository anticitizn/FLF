package Joystick;

import Equipment.Equipment;
import MixingUnit.MixingUnit;

public class SmartJoystick extends AbstractJoystick{

    private SmartJoystickState state;

    public SmartJoystick(Equipment Launcher, MixingUnit MixingUnit) {
        super(Launcher);
    }

    @Override
    public void pressLeftButton() {
        if (state instanceof SmartJoystickDeactivated) {
            state = new SmartJoystickActivated(launcher);
        } else {
            state = new SmartJoystickDeactivated(launcher);
        }
    }

    @Override
    public void pressRightButton() {
        // right button has no function on the smart joystick
        // but the method is retained so that SmartJoystick and
        // Joystick can be interchangeable
    }

    @Override
    public void pressBackButton() {
        state.pressBackButton();
    }
}
