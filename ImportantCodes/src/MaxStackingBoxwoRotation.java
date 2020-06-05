import java.util.*;

public class MaxStackingBoxwoRotation {
    public static ArrayList<Box> buildTallestStack(Box[] boxes) {
        if (boxes == null) return null;
        return buildTallestStack(boxes, null);
    }

    private static ArrayList<Box> buildTallestStack(Box[] boxes, Box bottom) {
        int maxHeight = 0;
        ArrayList<Box> maxStack = null;
        for (Box box : boxes) {
            if (box.canPlaceAbove(bottom)) {
                ArrayList<Box> boxStack = buildTallestStack(boxes, box);
                int height = getStackHeight(boxStack);
                if (height > maxHeight) {
                    maxHeight = height;
                    maxStack = boxStack;
                }
            }
        }
        if (maxStack == null) maxStack = new ArrayList<Box>();
        if (bottom != null) maxStack.add(0, bottom);
        return maxStack;
    }

    private static int getStackHeight(List<Box> boxes) {
        int height = 0;
        for (Box b : boxes) height += b.height;
        return height;
    }

    public static class Box {
        private int width, length, height;

        public Box(int w, int l, int h) {
            width = w;
            length = l;
            height = h;
        }

        public boolean canPlaceAbove(Box b) {
            return b == null ||
                    (this.width < b.width &&
                            this.length < b.length &&
                            this.height < b.height);
        }
    }
}
