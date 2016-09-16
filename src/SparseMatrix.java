import java.util.*;

public class SparseMatrix {
    public int size;
    public Hashtable hash;


    public SparseMatrix(Hashtable hash, int size) {
        this.hash = hash;
        this.size = size;

    }

    public SparseMatrix(int size) {
        this.hash = new Hashtable<>();
        this.size = size;
    }

    public SparseMatrix mulSparseSparse(SparseMatrix other) {
        SparseMatrix res = new SparseMatrix(size);
        int k = 0; //номер элемента
        int uk1; //указатель бегающий по строке первой матрицы
        int uk2; //указатель бегающий по столбцам второй матрицы

        for (int h = 0; h < size; h++)  //выбор строки
        {
            for (int i = 0; i < size; i++) //выбор столбца
            {
                uk1 = size * h;
                int temp = 0;
                uk2 = i;
                for (int j = 0; j < size; j++)  //умножение строки на столбец
                {
                    if ((this.hash.get(uk1) != null) & (other.hash.get(uk2) != null)) {
                        temp += ((int) this.hash.get(uk1) * (int) other.hash.get(uk2));
                    }
                    uk1 ++;
                    uk2 += size;
                }

                if (temp != 0)  //добавление
                {
                    res.hash.put(k, temp);
                }
                k++;
            }
        }
        return  res;
    }

    public void HashOut()
    {
        for (int i = 0; i < size*size; i++)
        {
            if(i%size == 0){
                System.out.println();
            }
            if (hash.get(i)!=null)
            {
                System.out.print((int)hash.get(i) + " ");
            }
            else
            {
                System.out.print("0 ");
            }
        }
    }

}