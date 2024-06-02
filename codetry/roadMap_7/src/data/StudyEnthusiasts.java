/*
StudyEnthusiasts: hội những người ham học bỏ quan không quan tâm gì cả
**ban đầu bác thợ săn học hành rất kém tập trung vì bận nhìn phò mã. Nhưng nếu
bác tham gia StudyEnthusiasts thì sẽ được tiếp nhận ý chí của hội
ý chí 'học không quan tâm gì cả' của hội
từ đó bác chỉ tập trung việc học và không nhìn phò mã nữa==> học đến mức bỏ ăn
từ người bthg==>vô hội==>học bỏ ăn luôn==>học không quan tâm gì hết
**ban đầu ngựa học hành rất kém vì ngựa vừa học vừa hú hí nhưng nếu ngựa tham gia 
StudyEnthusiasts thì ngựa sẽ tiếp nhận được ý chí. Từ đó ngựa sẽ tập trung học và không
sợ bác thợ săn nữa==> học k quan tâm đến mạng sống 
từ người bthg =>vào hội=>học không quan gì hết

StudyEnthusiasts: hội những người mê học tập hơn tất cả họ k quan tâm b là gì, loài gì
chỉ cần quan tâm đến việc học, còn nước da, màu tóc, học như thế nào thì kệ em

Tư duy ngược(sai) bên đầu bên trong horse và hunter có studyHard() rồi đem đặc điểm 
chung đưa cho interface
 */
package data;

public interface StudyEnthusiasts {
    //ai cũng có thể tham gia hội này đc. Nếu muốn là đc
    //nhưng nếu tham gia thì phải ham học hơn tất cả
    //->interface không có props
    //chỉ cần có thuộc tính thì tất cả hội viên đều có
    
    //nhưng nếu anh cố tình tạo thuộc tính sao?
    //int fan = 3
    public static final int FAN = 3;
    //final == const(hằng số) lúc tạo ra phải có sẵn giá trị
    //mà trong inteface tất cả prop đều là static final
    //k có cái nagnw nào cần rót giá trị hết cả 
    //không có getter và setter
    //sẽ có sẵn constructor default(rỗng) vì bản chất interface cũng chỉ là class
    /*
    Tất cả các method trong interface đều là abstract method. Vì interface là 1 cái cớ
    để gom 2 class không có điểm chung về một nhóm, đã k có điểm chung thì lấy đâu
    công thức chung ==> phải bỏ trống
    ***Đã nói xạo thì sao dám nói chi tiết được
    */
    
    public double studyHard();
    public void showProfile();
    //**Thực tế thì không nên có 2 method trong interface
}
