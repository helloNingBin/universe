package function;

import example.concurrent.bean.FileBean;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        Function<FileBean,?> function = FileBean::getDetail;
        FileBean bean = new FileBean();
        bean.setDetail("abc");
        Object apply = function.apply(bean);
        System.out.println(apply);

        //FileBean::getDetail是等价于下面这个
        function = new Function<FileBean, Object>() {
            @Override
            public Object apply(FileBean fileBean) {
                return fileBean.getDetail();
            }
        };
    }
}
