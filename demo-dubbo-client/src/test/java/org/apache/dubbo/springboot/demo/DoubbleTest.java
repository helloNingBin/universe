package org.apache.dubbo.springboot.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.base.util.Page;
import com.order.iterface.OrderInterface2;
import com.organization.iterface.StoreMemberConsumeInterface;
import com.organization.vo.StoreServerType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DoubbleTest {
    @Reference(version = "ningbing")
    private StoreMemberConsumeInterface storeMemberConsumeInterface;
    @Reference(version = "ningbing")
    private OrderInterface2 orderInterface2;

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
    @Test
    public void test2() throws Exception {
        Page page = new Page();
        Page page1 = orderInterface2.getCarStoreOrderItem(page,"4028819e8a88366a018d4511e4800001",null,null,null);
        System.out.println(page1);
    }
}
