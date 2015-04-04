package com.rixon.projecteuler.main.matrixproduct.direction;

import com.rixon.projecteuler.main.matrixproduct.MatrixCoordinate;

/**
 * Created by rixonmathew on 04/04/15.
 */
public class Left implements Direction {
    @Override
    public DirectionType getDirectionType() {
        return DirectionType.LEFT;
    }

    @Override
    public MatrixCoordinate getNewCoordinates(MatrixCoordinate currentCoordinate, int numberOfElements) {
        return MatrixCoordinate.fromCoordinates(currentCoordinate.getRow(),currentCoordinate.getColumn()-numberOfElements);
    }

    @Override
    public MatrixCoordinate getNextCoordinate(MatrixCoordinate startingCoordinate) {
        return MatrixCoordinate.fromCoordinates(startingCoordinate.getRow(),startingCoordinate.getColumn()-1);
    }

}
