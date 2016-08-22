public class Client {
    public static void main(String args[]) {
        Chart chart;
        // 读取配置文件中的参数
        String type = XMLUtil.getChartType();
        // 通过静态工厂方法创建产品
        chart = ChartFactory.getChart(type);
        chart.display();
    }
}