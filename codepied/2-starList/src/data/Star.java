package data;
//Star là khuôn dùng để đúc ra các ca sĩ nổi tiếng(object)
//tất cả người nổi tiếng đều được tạo ra từ khuôn này

public class Star {
    //poperties|field|atribute: thuộc tính
    //Những cái ngăn để rót vào
    private String name;
    public int yob;
    public static String gender;//static là không phân tán mà duy nhất một 
    //thằng ám chỉ prop hay method này thuộc class và k thuộc về object
    //các object phải xài chung với prop, method
    public String hotSong;
    
    //có ngăn rồi cần có cái phễu
    //cái phễu: constructor: cái phếu giúp rót giá trị vào đúng chỗ
    //định nghĩa: phễu là hàm giúp phân phối giá trị vào đúng ngăn
    //cái phểu phải public
    //phễu không được để đầu ra(kể cả void)
    //phải phải cùng tên với class chứa nó

    public Star(String name, int yob, String gender, String hotSong) {
        this.name = name;
        this.yob = yob;
        this.gender = gender;
        this.hotSong = hotSong;
    }
    
    //phễu tiếp nhận giá trị mà người dùng đưa vào
    //method|function: phương thức
    //vì in ra nên trả ra là void
    public void showInFor(){
        System.out.println("Tôi tên là: " + name + ", sinh năm: " + yob
        + ", giới tính: " + gender + ", anh đã hát: " + hotSong);
    }
    //get
    public String getName(){
        return name;
    }
    //set
    public void setName(String newName, int pwd){
        name = pwd == 5071994 ? newName : name;
    }
     
}
