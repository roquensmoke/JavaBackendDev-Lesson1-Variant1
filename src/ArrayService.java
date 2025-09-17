import java.io.PrintStream;

public abstract class ArrayService
{
    protected static final int N_LOWEST = 0;
    protected static final int N_HIGHEST = 100;

    protected double[] arData;
    protected int dimension;
    protected ArrayTypeEnum arrayType;

    public static ArrayService create(int dim, ArrayTypeEnum arrayType, int lowestNum, int highestNum)
    {
        return switch (arrayType) {
            case INT -> new ArrayIntService(dim, arrayType, lowestNum, highestNum);
            case DOUBLE -> new ArrayDoubleService(dim, arrayType, lowestNum, highestNum);
        };
    }

    public static ArrayService create(int dim, ArrayTypeEnum arrayType)
    {
        return switch (arrayType) {
            case INT -> new ArrayIntService(dim, arrayType, N_LOWEST, N_HIGHEST);
            case DOUBLE -> new ArrayDoubleService(dim, arrayType, N_LOWEST, N_HIGHEST);
        };
    }

    protected ArrayService(int dim, ArrayTypeEnum arrayType)
    {
        this.dimension = dim;
        this.arData = new double[this.dimension];
        this.arrayType = arrayType;
        this.initArrayData(0, 100);
    }

    protected ArrayService(int dim, ArrayTypeEnum arrayType, int lowestNum, int highestNum)
    {
        this.dimension = dim;
        this.arData = new double[this.dimension];
        this.arrayType = arrayType;
        this.initArrayData(lowestNum, highestNum);
    }

    public String getMaxElement()
    {
        var max = this.arData[0];
        for (int i = 1; i < this.dimension; ++i) {
            if (this.arData[i] > max) {
                max = this.arData[i];
            }
        }
        return this.format(max);
    }

    public String getMinElement()
    {
        var min = this.arData[0];
        for (int i = 1; i < this.dimension; ++i) {
            if (this.arData[i] < min) {
                min = this.arData[i];
            }
        }
        return this.format(min);
    }

    public String getAverage()
    {
        var sum = 0.;
        for (int i = 0; i < this.dimension; ++i) {
            sum += this.arData[i];
        }
        return this.format(sum / this.dimension);
    }

    public ArrayService sortBubbleAscending()
    {
        for (int i = 0; i < this.dimension - 1; ++i) {
            for (int j = i + 1; j < this.dimension; ++j) {
                if (this.arData[i] > this.arData[j]) {
                    var tmp = this.arData[i];
                    this.arData[i] = this.arData[j];
                    this.arData[j] = tmp;
                }
            }
        }
        return this;
    }

    abstract protected String format(double num);

    abstract protected void initArrayData(int lowestNum, int highestNum);

    abstract public void printToStream(PrintStream out);
}
