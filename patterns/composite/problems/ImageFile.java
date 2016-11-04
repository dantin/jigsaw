/**
 * 为了突出核心框架代码，对杀毒过程的实现进行了大量简化
 */
import java.util.*;

/**
 * 图像文件类
 */
public class ImageFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public void killVirus() {
        // 简化代码，模拟杀毒
        System.out.println("----对图像文件'" + name + "'进行杀毒");
    }
}

/**
 * 文本文件类
 */
class TextFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public void killVirus() {
        // 简化代码，模拟杀毒
        System.out.println("----对文本文件'" + name + "'进行杀毒");
    }
}

/**
 * 文件夹类
 */
class Folder {
    private String name;
    // 定义集合folderList，用于存储Folder类型的成员
    private ArrayList<Folder> folderList = new ArrayList<Folder>();
    // 定义集合imageList，用于存储ImageFile类型的成员
    private ArrayList<ImageFile> imageList = new ArrayList<ImageFile>();
    // 定义集合textList，用于存储TextFile类型的成员
    private ArrayList<TextFile> textList = new ArrayList<TextFile>();

    public Folder(String name) {
        this.name = name;
    }

    // 增加新的Folder类型的成员
    public void addFolder(Folder f) {
        folderList.add(f);
    }

    // 增加新的ImageFile类型的成员
    public void addImageFile(ImageFile image) {
        imageList.add(image);
    }

    // 增加新的TextFile类型的成员
    public void addTextFile(TextFile text) {
        textList.add(text);
    }

    /**
     * 需提供三个不同的方法removeFolder()、removeImageFile()和
     * removeTextFile()来删除成员，代码省略
     */

    /**
     * 需提供三个不同的方法getChildFolder(int i)、getChildImageFile(int i)和
     * getChildTextFile(int i)来获取成员，代码省略
     */

    public void killVirus() {
        System.out.println("****对文件夹'" + name + "'进行杀毒"); //模拟杀毒

        // 如果是Folder类型的成员，递归调用Folder的killVirus()方法
        for (Object obj : folderList) {
            ((Folder)obj).killVirus();
        }

        // 如果是ImageFile类型的成员，调用ImageFile的killVirus()方法
        for (Object obj : imageList) {
            ((ImageFile)obj).killVirus();
        }

        // 如果是TextFile类型的成员，调用TextFile的killVirus()方法
        for (Object obj : textList) {
            ((TextFile)obj).killVirus();
        }
    }
}
