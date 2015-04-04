package com.rixon.projecteuler.main;

import com.rixon.projecteuler.main.matrixproduct.MatrixCoordinate;
import com.rixon.projecteuler.main.matrixproduct.direction.Direction;
import com.rixon.projecteuler.main.matrixproduct.direction.DirectionProvider;
import com.rixon.projecteuler.main.matrixproduct.direction.DirectionType;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.util.Decimal64;

import java.io.IOException;

/**
 * Created by rixonmathew on 02/04/15.
 */
public class MatrixSolver {

    public long productOfConsecutiveElements(String fileName, int numberOfConsecutiveElements) {

        long maxProduct = 1;
        long product = 1;
        long row=0,column=0;
        DirectionType maxDirectionType = null;
        Decimal64[][] matrixData = null;
        try {
            matrixData = EulerMathHelper.loadData(fileName);
            FieldMatrix<Decimal64> fieldMatrix = MatrixUtils.createFieldMatrix(matrixData);
            for (int i=0;i<fieldMatrix.getRowDimension();i++){
                for (int j=0;j<fieldMatrix.getColumnDimension();j++){
                    for (DirectionType directionType:DirectionType.values()){
                        Direction direction = DirectionProvider.getDirection(directionType);
                        MatrixCoordinate currentCoordinate = MatrixCoordinate.fromCoordinates(i, j);
                        MatrixCoordinate newCoordinates = direction.getNewCoordinates(currentCoordinate,numberOfConsecutiveElements);
                        if (isValid(newCoordinates,fieldMatrix)) {
                            product = computeProduct(fieldMatrix,currentCoordinate,newCoordinates,direction);
                            if (product>maxProduct){
                                row = i;
                                column = j;
                                maxDirectionType = direction.getDirectionType();
                                maxProduct = product;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Found max elements at row :"+row+" and column:"+column+" and direction "+maxDirectionType.name()+" value "+maxProduct);
        return maxProduct;

    }

    private long computeProduct(FieldMatrix<Decimal64> fieldMatrix, MatrixCoordinate currentCoordinate, MatrixCoordinate newCoordinates, Direction direction) {
        MatrixCoordinate startingCoordinate = currentCoordinate;
        long product = fieldMatrix.getEntry((int)startingCoordinate.getRow(),(int)startingCoordinate.getColumn()).longValue();
        while (!startingCoordinate.equals(newCoordinates)) {
            startingCoordinate = direction.getNextCoordinate(startingCoordinate);
            product*=fieldMatrix.getEntry((int)startingCoordinate.getRow(),(int)startingCoordinate.getColumn()).longValue();
        }
        return product;
    }

    private boolean isValid(MatrixCoordinate newCoordinates, FieldMatrix<Decimal64> fieldMatrix) {
        boolean valid = true;
        if (newCoordinates.getRow()<0||newCoordinates.getRow()>=fieldMatrix.getRowDimension()){
            valid = false;
            return valid;
        }
        if (newCoordinates.getColumn()<0||newCoordinates.getColumn()>=fieldMatrix.getColumnDimension()){
            valid = false;
            return valid;
        }
        return valid;
    }

}
