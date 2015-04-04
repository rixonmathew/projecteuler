package com.rixon.projecteuler.main.matrixproduct.direction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rixonmathew on 04/04/15.
 */
public class DirectionProvider {

    private static Map<DirectionType,Direction> directions;
    static {
        directions = new HashMap<>();
        directions.put(DirectionType.RIGHT,new Right());
        directions.put(DirectionType.LEFT,new Left());
        directions.put(DirectionType.TOP,new Top());
        directions.put(DirectionType.BOTTOM,new Bottom());
        directions.put(DirectionType.TOP_RIGHT,new TopRight());
        directions.put(DirectionType.TOP_LEFT,new TopLeft());
        directions.put(DirectionType.BOTTOM_RIGHT,new BottomRight());
        directions.put(DirectionType.BOTTOM_LEFT,new BottomLeft());
    }

    public static Direction getDirection(DirectionType directionType){
        return directions.get(directionType);
    }
}
