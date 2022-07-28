package reflection_proxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyMain {

    public static void main(String[] args) {
        Map mapProxyInstance = (Map) Proxy.newProxyInstance(
                ProxyMain.class.getClassLoader(), new Class[]{Map.class},
                new TimingDynamicInvocationHandler(new HashMap<>()));

        mapProxyInstance.put("hello", "world");
        mapProxyInstance.put("Name", "Ritesh");
    }
}
