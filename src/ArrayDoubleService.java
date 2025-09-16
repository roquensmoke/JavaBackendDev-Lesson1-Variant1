import java.io.PrintStream;

public class ArrayDoubleService extends ArrayService
{
    public ArrayDoubleService(int dim, ArrayTypeEnum arrayType)
    {
        super(dim, arrayType);
    }

    public ArrayDoubleService(int dim, ArrayTypeEnum arrayType, int lowestNum, int highestNum)
    {
        super(dim, arrayType, lowestNum, highestNum);
    }

    protected void initArrayData(int lowestNum, int highestNum)
    {
        int lenInterval = highestNum - lowestNum + 1;
        for (int i = 0; i < this.dimension; ++i) {
            this.arData[i] = lowestNum + (Math.random() * lenInterval);
        }
    }

    public void printToStream(PrintStream out)
    {
        for (int i = 0; i < this.dimension; ++i) {
            out.println(this.arData[i]);
        }
    }

    protected String format(double num)
    {
        return "" + num;
    }
}
