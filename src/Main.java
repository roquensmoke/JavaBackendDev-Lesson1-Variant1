import java.util.Scanner;

public class Main
{
    public static void main(String[] arParams) throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размерность массива: ");
        int dimension = scanner.nextInt();
        if (dimension <= 0) {
            throw new Exception("Размерность должна быть больше нуля");
        }
        System.out.println("Введите тип элементов массива (0 - целые, 1 - вещественные): ");
        int arrayType = scanner.nextInt();
        if (arrayType != 0 && arrayType != 1) {
            throw new Exception("Неверный тип элементов");
        }
        System.out.println("Введите границы генерации случайных чисел через пробел (только целые): ");
        int nMin = scanner.nextInt();
        int nMax = scanner.nextInt();
        if (nMin > nMax) {
            var tmp = nMin;
            nMin = nMax;
            nMax = tmp;
        }

        ArrayService obArray;
        if (nMax == nMin) {
            obArray = new ArrayService(
                dimension,
                arrayType == 0 ? ArrayTypeEnum.INT : ArrayTypeEnum.DOUBLE
            );
        } else {
            obArray = new ArrayService(
                dimension,
                arrayType == 0 ? ArrayTypeEnum.INT : ArrayTypeEnum.DOUBLE,
                nMin,
                nMax
            );
        }
        obArray.printToStream(System.out);

        scanner.close();
    }
}
