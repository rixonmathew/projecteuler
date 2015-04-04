package com.rixon.projecteuler.main.matrixproduct;

/**
 * Created by rixonmathew on 04/04/15.
 */
public class MatrixCoordinate {

    private long row;
    private long column;

    private MatrixCoordinate(long row,long column) {
        this.row = row;
        this.column = column;
    }

    public static MatrixCoordinate fromCoordinates(long row,long column) {
        return new MatrixCoordinate(row,column);
    }

    public long getRow() {
        return row;
    }

    public long getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "MatrixCoordinate{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MatrixCoordinate that = (MatrixCoordinate) o;

        if (row != that.row) return false;
        return column == that.column;

    }

    @Override
    public int hashCode() {
        int result = (int) (row ^ (row >>> 32));
        result = 31 * result + (int) (column ^ (column >>> 32));
        return result;
    }
}

