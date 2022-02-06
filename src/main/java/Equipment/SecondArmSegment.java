package Equipment;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class SecondArmSegment {
    public SecondArmSegment() {
        smallSegments = new ArrayList<>();
        smallSegments.add(new SmallArmSegment(6));
        smallSegments.add(new SmallArmSegment(6));
        smallSegments.add(new SmallArmSegment(5));
    }
    private final ArrayList<SmallArmSegment> smallSegments;
}
