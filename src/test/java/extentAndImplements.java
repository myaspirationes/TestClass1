import org.junit.Test;

/**
 * this 调用自己的方法;
 * super 调用父类方法.
 */
public class extentAndImplements {
    class Animal {

        public Animal() {
            System.out.println("这是构造函数的打印信息。。。");
        }

        void eat() {
            System.out.println("animal : eat");
        }
    }

    class Dog extends Animal {

        void eat() {
            System.out.println("dog : eat");
        }

        void eatTest() {
            this.eat();   // this 调用自己的方法
            super.eat();  // super 调用父类方法
        }
    }

    @Test
    public void extentTest() {
//            Animal a = new Animal();
//            a.eat();
        Dog d = new Dog();
        d.eatTest();
    }


}
