package org.apache.dubbo.springboot.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.base.util.Page;
import com.organization.iterface.StoreMemberConsumeInterface;
import com.organization.vo.StoreServerType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DoubbleTest {
    @Reference(version = "ningbing")
    private StoreMemberConsumeInterface storeMemberConsumeInterface;
    @Test
    public void test1() throws Exception {
        StoreServerType bean = new StoreServerType();
        bean.setRootOrgId("4028819e6a9190d5016a952d90de0000");
        bean.setType("0");
        Page page = new Page();
        page.setStart(0);
        page.setLimit(5);
        Page page1 = storeMemberConsumeInterface.storeServerTypeList(bean, page);
        System.out.println(page1);
    }
}
