package org.apache.dubbo.springboot.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.organization.iterface.StoreMemberConsumeInterface;
import com.organization.vo.StoreServerType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class DubboTestController {
    @Reference(version = "ningbing")
    private StoreMemberConsumeInterface storeMemberConsumeInterface;

    @GetMapping("/dubbo")
    public String getDubboResult(){
        System.out.println(storeMemberConsumeInterface);
        List<StoreServerType> rootStoreServerTypeList = storeMemberConsumeInterface.findRootStoreServerTypeList("4028e35b7aae7fa5017aaeb744850003","0");
        return "ok"+rootStoreServerTypeList;
    }
    @GetMapping("/dubbo2")
    public String searchHeaderByCondition(String c,String v) throws Exception {
        return "ok"+ storeMemberConsumeInterface.searchHeaderByCondition("4028e35b7aae7fa5017aaeb744850003",c,v);
    }
    @PostConstruct
    public void t1(){
        /*List<StoreServerType> rootStoreServerTypeList = storeMemberConsumeInterface.findRootStoreServerTypeList("4028e35b7aae7fa5017aaeb744850003","0");
        System.out.println(rootStoreServerTypeList);*/
        System.out.println(storeMemberConsumeInterface);
    }
}
