package junw.stspringCloud3.testJar;

/**
 * Created by Intellij IDEA.
 * Project:st-springCloud3
 * Package:junw.stspringCloud3.testJar
 *
 * @author liujiajun_junw
 * @Date 2023-09-12-37  星期三
 * @Description
 */
public class resultWay {
//	根据完整的堆栈信息,这个错误的关键在于:
//
//	Caused by: java.lang.reflect.InaccessibleObjectException: Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass()... accessible
//
//	这是因为Spring使用了CGLIB进行字节码增强,需要通过反射调用ClassLoader的defineClass()方法。但在JDK 9+的模块化系统中,java.lang.ClassLoader类所在的java.base模块并没有开放给其他未命名模块,所以反射调用这个方法会报错。
//
//	解决方法是在启动Sentinel Dashboard时,加上JVM参数:--add-opens java.base/java.lang=ALL-UNNAMED
//
//	这个参数将会开放java.lang包给所有未命名的模块,这样就可以成功反射调用defineClass方法了。
	// java -jar -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=localhost:8080 -Dproject.name=sentinel-dashboard -Djava.security.egd=file:/dev/./urandom --add-opens java.base/java.lang=ALL-UNNAMED sentinel-dashboard.jar
	// 使用上面的命令去启动jar包，就可以搞定

}
