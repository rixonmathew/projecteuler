package com.rixon.projecteuler.main.matrixproduct.direction;

import com.rixon.projecteuler.main.matrixproduct.MatrixCoordinate;

/**
 * Created by rixonmathew on 04/04/15.
 */
public class TopLeft implements Direction {
    @Override
    public DirectionType getDirectionType() {
        return DirectionType.TOP_LEFT;
    }

    @Override
    public MatrixCoordinate getNewCoordinates(MatrixCoordinate currentCoordinate, int numberOfElements) {
        return MatrixCoordinate.fromCoordinates(currentCoordinate.getRow()-numberOfElements,currentCoordinate.getColumn()-numberOfElements);
    }

    @Override
    public MatrixCoordinate getNextCoordinate(MatrixCoordinate startingCoordinate) {
        return MatrixCoordinate.fromCoordinates(startingCoordinate.getRow()-1,startingCoordinate.getColumn()-1);
    }

}
