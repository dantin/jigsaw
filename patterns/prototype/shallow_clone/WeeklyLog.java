/**
 * 工作周报WeeklyLog：具体原型类，考虑到代码的可读性和易理解性，只列出部分与模式相关的核心代码
 */
public class WeeklyLog implements Cloneable {
       // 为了简化设计和实现，假设一份工作周报中只有一个附件对象，实际情况中可以包含多个附件，
       // 可以通过List等集合对象来实现
       private Attachment attachment;
       private String name;
       private String date;
       private String content;
       public void setName(String name) {
              this.name  = name;
       }
       public  void setDate(String date) {
              this.date  = date;
       }
       public  void setContent(String content) {
              this.content  = content;
       }
       public void setAttachment(Attachment attachment) {
              this.attachment = attachment;
       }
       public  String getName() {
              return  (this.name);
       }
       public  String getDate() {
              return  (this.date);
       }
       public  String getContent() {
              return this.content;
       }
       public Attachment getAttachment() {
              return this.attachment;
       }
       //克隆方法clone()，此处使用Java语言提供的克隆机制
       public WeeklyLog clone() {
              Object obj = null;
              try {
                     obj = super.clone();
                     return (WeeklyLog)obj;
              } catch (CloneNotSupportedException e) {
                     System.out.println("不支持复制！");
                     return null;
              }
       }
}