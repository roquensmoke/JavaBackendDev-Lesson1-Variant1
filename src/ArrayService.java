import java.io.PrintStream;

public class ArrayService
{
    protected double[] arData;
    protected int dimension;
    protected ArrayTypeEnum arrayType;

    public ArrayService(int dim, ArrayTypeEnum arrayType)
    {
        this.dimension = dim;
        this.arData = new double[this.dimension];
        this.arrayType = arrayType;
        this.initArrayData(0, 100);
    }

    public ArrayService(int dim, ArrayTypeEnum arrayType, int lowestNum, int highestNum)
    {
        this.dimension = dim;
        this.arData = new double[this.dimension];
        this.arrayType = arrayType;
        this.initArrayData(lowestNum, highestNum);
    }

    protected void initArrayData(int lowestNum, int highestNum)
    {
        int lenInterval = highestNum - lowestNum + 1;
        for (int i = 0; i < this.dimension; ++i) {
            //по-хорошему, это надо делать полиморфизмом
            switch (this.arrayType) {
                case INT:
                    this.arData[i] = lowestNum + (int)Math.floor(Math.random() * lenInterval);
                    break;
                case DOUBLE:
                    this.arData[i] = lowestNum + (Math.random() * lenInterval);
                    break;
            }
        }
    }

    public void printToStream(PrintStream out)
    {
        for (int i = 0; i < this.dimension; ++i) {
            switch (this.arrayType) {
                case INT:
                    out.println((int)this.arData[i]);
                    break;
                case DOUBLE:
                    out.println(this.arData[i]);
                    break;
            }
        }
    }
}
