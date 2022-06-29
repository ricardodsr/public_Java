import java.time.LocalDate;

public class ArrayDatas {
    LocalDate[] datas;
    int tam;

    // Construtores
    ArrayDatas() {
        this.datas = new LocalDate[10];
        this.tam = 10;
    }

    ArrayDatas(int n) {
        this.datas = new LocalDate[n];
        this.tam = n;
    }
    
/* -------------------------------------------------- */
     
    // Length: 4
    // Size: 7
    //  0  1  2  3  4  5  6
    // [1, 5, 2 ,4, 230sada, 0sda90 ]
    public void insereData(LocalDate d) {
        this.datas[this.datas.length] = d;
    }

}
