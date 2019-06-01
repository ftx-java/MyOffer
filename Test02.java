package tx.offer;

/**
 * 第2题
 * 设计一个类，我们只能生成该类的一个实例(单例模式 懒汉式)
 *
 * @author tx
 * @date 2019/02/15
 */
public class Test02 {
    /**
     * 类初始化时，不初始化这个对象（有延时加载的优势，等真正用的时候在创建）。
     */
    private static Test02 instance;

    /**
     * 私有化构造器
     */
    private Test02() {
    }

    /**
     * 方法同步 调用效率低
     */
    public static synchronized Test02 getInstance() {
        if (instance == null) {
            instance = new Test02();
        }
        return instance;
    }
}
