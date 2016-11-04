public class ConcretePrototype implements Cloneable {
    // 成员属性
    private String  attr;

    public void  setAttr(String attr) {
        this.attr = attr;
    }

    public String  getAttr() {
        return this.attr;
    }

    //克隆方法
    public ConcretePrototype  clone() {
        //创建新对象
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAttr(this.attr);
        return prototype;
    }
}