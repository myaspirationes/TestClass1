


public class StudentApplication {

    public interface IStudent {
        public String doMethod1();
        public String doMethod2();
        public String doMethod3();
    }


    IStudent student=null;
    public StudentApplication(IStudent student) {
        this.student = student;
    }

    public String doMethod(){
        String str1=student.doMethod1();
        String str2=student.doMethod2();
        String str3=student.doMethod3();
        return str1+str2+str3;
    }

    public IStudent getStudent() {
        return student;
    }


}
