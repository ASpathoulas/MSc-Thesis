public class Data1 extends java.lang.Thread {


	private void otherMethod(B myB, int myInt){
		synchronized (myB) {
			myB.set(myInt);
		}
	}
    public static void main(String[] a) {
        B b1 = new B();
        B b2 = new B();
        for (int i = 0; i < 10; i++) {
        	Data1 t = new Data1(b1, b2);
		t.start();
        }
        for (int i = 0; i < 10; i++) {
		b1.get();
//		synchronized (b2) {
//			b2.set(i);
//		}
		otherMethod(b2,i);
        }
    }
    private B f1, f2;
    public Data1(B b1, B b2) {
        this.f1 = b1;
	this.f2 = b2;
    }
    public void run() {
        B b1 = this.f1;
        B b2 = this.f2;
        int i;
        synchronized (b2) {
            i = b2.get();
        }
        b1.set(i);
    }
}

class A {
	private int af;
	public A() {
		this.af = 0;
	}
	public int get() {
		return this.af;
	}
	public void set(int i) {
		this.af = i;
	}
}

class B {
	private A bf;
	public B() {
		A a = new A();
		this.bf = a;
	}
	public int get() {
		A a = this.bf;
		return a.get();
	}
	public void set(int i) {
		A a = this.bf;
		a.set(i);
	}
}
