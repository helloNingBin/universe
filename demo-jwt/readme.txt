在这里学习的
https://zhuanlan.zhihu.com/p/342755411

SpringSecurity本质是一个过滤器链：
    FilterSecurityInterceptor：是一个方法级的权限过滤器，基本位于过滤链的最底部
    ExceptionTranslationFilter：是一个异常过滤器，用来处理在认证授权过程中抛出的异常
    UsernamePasswordAuthenticationFilter：对/login的POST请求做拦截，校验表彰中的用户名，密码

开启权限
 @EnableGlobalMethodSecurity(prePostEnabled=true)//这个写在配置类上
 @PreAuthorize("hasAuthority('test')")//这个写在请求方法上
 如果是自定义权限方法，可以这样获取权限列表

@Component("ex")
public class SGExpressionRoot {

    public boolean hasAuthority(String authority){
        //获取当前用户的权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();
        //判断用户权限集合中是否存在authority
        return permissions.contains(authority);
    }
}

#配置定义登录、权限异常
     //配置异常处理器，实现implements AccessDeniedHandler
        http.exceptionHandling()
                //配置认证失败处理器
                .authenticationEntryPoint(authenticationEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
