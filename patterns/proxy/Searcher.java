
class AccessValidator {
    // 模拟实现登录验证
    public boolean validate(String userId) {
        System.out.println("在数据库中验证用户'" + userId + "'是否是合法用户？");
        if (userId.equals("杨过")) {
            System.out.printf("'%s'登录成功！\n", userId);
            return true;
        } else {
            System.out.printf("'%s'登录失败！\n", userId);
            return false;
        }
    }
}

class Logger {
    // 模拟实现日志记录
    public void log(String userId) {
        System.out.printf("更新数据库，用户'%s'查询次数加1！\n", userId);
    }
}

public interface Searcher {
    String doSearch(String userId, String keyword);
}

class RealSearcher implements Searcher {

    @Override
    public String doSearch(String userId, String keyword) {
        System.out.printf("用户'%s'使用关键词'%s'查询商务信息！\n", userId, keyword);
        return "返回具体内容";
    }
}

class ProxySearcher implements Searcher {
    // 维持一个对真实主题的引用
    private RealSearcher searcher = new RealSearcher();
    private AccessValidator validator;
    private Logger logger;

    public ProxySearcher() {
        this.validator = new AccessValidator();
        this.logger = new Logger();
    }

    @Override
    public String doSearch(String userId, String keyword) {
        // 如果身份验证成功，则执行查询
        if (validate(userId)) {
            // 调用真实主题对象的查询方法
            String result = this.searcher.doSearch(userId, keyword);
            // 记录查询日志
            log(userId);
            // 返回查询结果
            return result;
        } else {
            return null;
        }
    }

    // 创建访问验证对象并调用其Validate()方法实现身份验证
    public boolean validate(String userId) {
        return this.validator.validate(userId);
    }

    // 创建日志记录对象并调用其Log()方法实现日志记录
    public void log(String userId) {
        this.logger.log(userId);
    }

}