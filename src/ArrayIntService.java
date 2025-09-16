import java.io.PrintStream;

public class ArrayIntService extends ArrayService
{
    public ArrayIntService(int dim, ArrayTypeEnum arrayType)
    {
        super(dim, arrayType);
    }

    public ArrayIntService(int dim, ArrayTypeEnum arrayType, int lowestNum, int highestNum)
    {
        super(dim, arrayType, lowestNum, highestNum);
    }

    protected void initArrayData(int lowestNum, int highestNum)
    {
        int lenInterval = highestNum - lowestNum + 1;
        for (int i = 0; i < this.dimension; ++i) {
            this.arData[i] = lowestNum + (int)Math.floor(Math.random() * lenInterval);
        }
    }

    public void printToStream(PrintStream out)
    {
        for (int i = 0; i < this.dimension; ++i) {
            out.println((int)this.arData[i]);
        }
    }

    protected String format(double num)
    {
        return "" + (int)num;
    }
}
