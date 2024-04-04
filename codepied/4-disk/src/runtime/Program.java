package runtime;

import data.Disky;

public class Program {
    public static void main(String[] args) {
        Disky dk1 = new Disky("Xanh lá", 4);
        Disky dk2 = new Disky("Xanh dương", 2);
        Disky ds[] = new Disky[2];
        ds[0] = dk1;
        ds[1] = dk2;
        for(int i = 0; i <= ds.length - 1; i++){
            ds[i].paint();
        }
    }
}
