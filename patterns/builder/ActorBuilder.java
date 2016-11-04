/**
 * Actor角色类：复杂产品，考虑到代码的可读性，只列出部分成员属性，且成员属性的类型均为String，
 * 真实情况下，有些成员属性的类型需自定义
 */
class Actor {
       private  String type; //角色类型
       private  String sex; //性别
       private  String face; //脸型
       private  String costume; //服装
       private  String hairstyle; //发型

       public  void setType(String type) {
              this.type  = type;
       }
       public  void setSex(String sex) {
              this.sex  = sex;
       }
       public  void setFace(String face) {
              this.face  = face;
       }
       public  void setCostume(String costume) {
              this.costume  = costume;
       }
       public  void setHairstyle(String hairstyle) {
              this.hairstyle  = hairstyle;
       }
       public  String getType() {
              return  (this.type);
       }
       public  String getSex() {
              return  (this.sex);
       }
       public  String getFace() {
              return  (this.face);
       }
       public  String getCostume() {
              return  (this.costume);
       }
       public  String getHairstyle() {
              return  (this.hairstyle);
       }
}

//角色建造器：抽象建造者
public abstract class ActorBuilder {
       protected  Actor actor = new Actor();

       public  abstract void buildType();
       public  abstract void buildSex();
       public  abstract void buildFace();
       public  abstract void buildCostume();
       public  abstract void buildHairstyle();

       //工厂方法，返回一个完整的游戏角色对象
       public Actor createActor() {
              return actor;
       }
}

//英雄角色建造器：具体建造者
class HeroBuilder extends ActorBuilder {
       public  void buildType() {
              actor.setType("英雄");
       }
       public  void buildSex() {
              actor.setSex("男");
       }
       public  void buildFace() {
              actor.setFace("英俊");
       }
       public  void buildCostume() {
              actor.setCostume("盔甲");
       }
       public  void buildHairstyle() {
              actor.setHairstyle("飘逸");
       }
}

//天使角色建造器：具体建造者
class AngelBuilder extends ActorBuilder {
       public  void buildType() {
              actor.setType("天使");
       }
       public  void buildSex() {
              actor.setSex("女");
       }
       public  void buildFace() {
              actor.setFace("漂亮");
       }
       public  void buildCostume() {
              actor.setCostume("白裙");
       }
       public  void buildHairstyle() {
              actor.setHairstyle("披肩长发");
       }
}

//恶魔角色建造器：具体建造者
class DevilBuilder extends ActorBuilder {
       public  void buildType() {
              actor.setType("恶魔");
       }
       public  void buildSex() {
              actor.setSex("妖");
       }
       public  void buildFace() {
              actor.setFace("丑陋");
       }
       public  void buildCostume() {
              actor.setCostume("黑衣");
       }
       public  void buildHairstyle() {
              actor.setHairstyle("光头");
       }
}
