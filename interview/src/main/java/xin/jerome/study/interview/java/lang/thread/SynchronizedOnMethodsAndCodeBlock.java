package xin.jerome.study.interview.java.lang.thread;

/**
 * synchronized 关键字修饰在代码块和方法上,通过{@code javap -v -p}查看字节码.
 *
 * @author Jerome Zhu
 * @since 2019年12月16日 21:01
 */
public class SynchronizedOnMethodsAndCodeBlock {

    /**
     * 修饰在代码块对应字节码 :
     *   private static void synchronizedBlock();
     *     descriptor: ()V
     *     flags: ACC_PRIVATE, ACC_STATIC
     *     Code:
     *       stack=2, locals=2, args_size=0
     *          0: ldc           #2                  // class xin/jerome/study/interview/java/lang/thread/SynchronizedOnMethodsAndCodeBlock
     *          2: dup
     *          3: astore_0
     *          4: monitorenter
     *          5: aload_0
     *          6: monitorexit
     *          7: goto          15
     *         10: astore_1
     *         11: aload_0
     *         12: monitorexit
     *         13: aload_1
     *         14: athrow
     *         15: return
     *       Exception table:
     *          from    to  target type
     *              5     7    10   any
     *             10    13    10   any
     *       LineNumberTable:
     *         line 48: 0
     *         line 49: 5
     *         line 50: 15
     *       StackMapTable: number_of_entries = 2
     *         frame_type = 255 /* full_frame * /
     *           offset_delta =10
     *           locals =[ class java/lang/Object ]
     *           stack =[ class java/lang/Throwable ]
     *         frame_type =250 /* chop * /
     *           offset_delta =4
     */
    private static void synchronizedBlock() {
        synchronized (SynchronizedOnMethodsAndCodeBlock.class) {
        }
    }

    /**
     * 修饰在方法上对应字节码 :
     *   private static synchronized void synchronizedMethod();
     *     descriptor: ()V
     *     flags: ACC_PRIVATE, ACC_STATIC, ACC_SYNCHRONIZED
     *     Code:
     *       stack=0, locals=0, args_size=0
     *          0: return
     *       LineNumberTable:
     *         line 64: 0
     */
    private synchronized static void synchronizedMethod() {
    }
}
