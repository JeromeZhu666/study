package xin.jerome.study.javabasic.lang.process;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * 管理当前进程
 *
 * @author Jerome Zhu
 * @since 2019年12月24日 16:29
 */
public class ManagementCurrentProcess {

    /**
     * 代码获取当前进程pid的方式.
     */
    @Test
    public void getCurrentProcessIdJava9Before() {
        // Java5之后可用的方式
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String runtimeName = runtimeMXBean.getName();
        String pid = runtimeName.substring(0, runtimeName.indexOf("@"));
        System.out.println("[Java5 之后可用的获取方式]当前进程 Runtime 名 : " + runtimeName);
        System.out.println("[Java5 之后可用的获取方式]当前进程 PID : " + pid);
        // Java9之后可用的方式
        Long processId = ProcessHandle.current().pid();
        System.out.println("[Java9 之后可用的获取方式]当前进程 PID : " + processId);
        // Java10之后可用的方式
        Long runtimeMXBeanGetPid = runtimeMXBean.getPid();
        System.out.println("[Java10 之后可用的获取方式]当前进程 PID : " + runtimeMXBeanGetPid);
    }

    /**
     * 代码获取当前进程pid的信息.
     */
    @Test
    public void getCurrentProcessInfo() {
        // Java5之后可用的方式
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        long pid = runtimeMXBean.getPid();
        Instant startTimeInstant = Instant.ofEpochMilli(runtimeMXBean.getStartTime());
        LocalDateTime startTime = LocalDateTime.ofInstant(startTimeInstant, ZoneId.systemDefault());
        System.out.printf("当前进程 PID : %s, 启动时间 : %s \n", pid, startTime);
        long uptime = runtimeMXBean.getUptime();
        System.out.printf("当前进程 PID : %s, 上线时间 : %s \n", pid, uptime);
        int threadCount = threadMXBean.getThreadCount();
        System.out.printf("当前进程 PID : %s, 线程活跃数量 : %s \n", pid, threadCount);
    }

}
