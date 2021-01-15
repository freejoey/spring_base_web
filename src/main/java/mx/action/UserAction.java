package mx.action;

import com.opensymphony.xwork2.ActionSupport;
import mx.bean.User;
import mx.service.IUser;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class UserAction extends ActionSupport {
    private Long id;
    private String name;
//    private User user;

//    @Resource(name = "iUser")
//    private IUser userImpl;

//    @PostConstruct
//    public void init() {
//        System.out.println("init UserAction." + userImpl);
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String login() {
//        System.out.println("model:" + user);
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        IUser userImpl = (IUser) wac.getBean("iUser");
        if (userImpl.getName(id).equals(name)) {
            return "success";
        } else {
            return "error";
        }
    }

    @Override
    public String execute() throws Exception {
        if (1 == getId() && "lisi".equals(getName())) {
            return "success";
        } else {
            return "error";
        }
    }

//    @Override
//    public User getModel() {
//        return user;
//    }
}
