package com.rixon.projecteuler.main.matrixproduct.direction;

import com.rixon.projecteuler.main.matrixproduct.MatrixCoordinate;

/**
 * Created by rixonmathew on 04/04/15.
 */
public interface Direction {

    DirectionType getDirectionType();

    MatrixCoordinate getNewCoordinates(MatrixCoordinate currentCoordinate,int numberOfElements);

    MatrixCoordinate getNextCoordinate(MatrixCoordinate startingCoordinate);
}
