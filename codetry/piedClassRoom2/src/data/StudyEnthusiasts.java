package data;

/*
StudyEnthusiasts: hội những người ham học bỏ qua không quan tâm gì cả

    **ban đầu bác thợ săn học hành rất kém tập trung vì bận nhìn phò mã. Nhưng nếu
bác tham gia StudyEnthusiasts thì sẽ được tiếp nhận ý chí của hội 
ý chí 'học không quan tâm gì cả' của hội
từ đó bác chỉ tập trung học và không nhìn phò mã nữa ==> học đến mức bỏ ăn
từ người bthg => vô hội => học bỏ ăn luôn => học không quan tâm gì hết

    **ban đầu ngựa học hành rất kém vì vừa học vừa hú hí nhưng nếu ngựa
tham gia StudyEnthusiasts thì ngựa sẽ tiếp nhận ý chí. từ đó ngựa sẽ tập trung học 
và không sợ bác thợ săn nữa ==> học k quan tâm mạng sống
từ người bthg => vào hội => học không quan tâm gì hết

StudyEnthusiasts: hội những người đam mê học tập hơn tất cả
họ k quan tâm bạn là gì, loài gì, chỉ cần bạn quan tâm thì có thể tham gia
nhưng nếu bạn tham gia bạn sẽ trở thành người 'học k quan tâm gì cả'

==>interface là 1 class chỉ quan tâm đến method, k quan tâm đến props ở đây họ chỉ
quan tâm đến việc học, còn nước da, màu tóc, học như thế nào thì kệ em

Tư duy ngược(sai) bên đầu bên trong horse và hunter có studyHard()
rồi đem đặc điểm chung đưa cho inteface
 */
public interface StudyEnthusiasts {
    //ai cũng có thể tham gia hội này cx đc. Nếu muốn là đc
    //nhưng nếu tham gia thì phải ham học hơn tất cả
    //->interface không có props
    //public int fan = 3;
    //chỉ cần có thuộc tính thì tất cả hội viên đều có
    //nếu cài thuộc tính sẽ trở thành áp đặt
    
    //nhưng nếu anh cố tình tạo thuộc tính sao?
    //int fan = 3;
    public static final int FAN = 3; 
    
    //final == const(hằng số) lúc tạo ra phải có sẵn giá trị
    //mà trong interface tất cả props đều là static final
    //k có cái ngăn nào bỏ trống là không có giá trị
    //=> Không bao giờ có constructor vì ngăn nào cũng có giá trị hết rồi nên k có
    //ngăn nào cần rót giá trị hết cả
    //không có getter và setter
    //sẽ có sẵn constructor default(rỗng) vì bản chất interface cũng chỉ là class
    
    /*
    tất cả các method trong interface đều là abstract method dù có từ khóa abstract 
    method hay không 
    */
    //Vì lúc đầu vô hội thì tụi mày học hành chăm chỉ. Nhưng mỗi thằng học sao thì đâu
    //biết. Phải để tụi nó tự học, nên vì đó là abstract
    
    /*
    Vì sao abstract trong interface đều là abstract method. Vì interface là 1 cái cơ
    để gom 2 class không có điểm chung về một nhóm, đã k có điểm chung thì lấy đâu
    công thức chung ==> phải bỏ trống
    **Đã nói xạo thì sao dám nói chi tiết được
    */
    public double studyHard();
    
    public void showProfile();
    //**THỰC TẾ THÌ KHÔNG NÊN CÓ 2 METHOD TRONG INTERFACE
}

