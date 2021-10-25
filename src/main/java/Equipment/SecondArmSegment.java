package Equipment;

import java.util.ArrayList;

public class SecondArmSegment {
    public SecondArmSegment() {
        smallSegments = new ArrayList<SmallArmSegment>();
        smallSegments.add(new SmallArmSegment(6));
        smallSegments.add(new SmallArmSegment(6));
        smallSegments.add(new SmallArmSegment(5));
    }
    private final ArrayList<SmallArmSegment> smallSegments;
}
