package com;

import com.Controller.HelloWeixin;
import com.jfinal.config.*;
import com.jfinal.render.ViewType;

/**
 * Created by Administrator on 2015/11/4.
 */
public class Myconfig extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        loadPropertyFile("config.txt");
        me.setViewType(ViewType.JSP);
        me.setDevMode(getPropertyToBoolean("devMode",false));
    }

    @Override
    public void configRoute(Routes me) {
        me.add("/HelloWeixin", HelloWeixin.class);
    }

    @Override
    public void configPlugin(Plugins me) {

    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }
}
