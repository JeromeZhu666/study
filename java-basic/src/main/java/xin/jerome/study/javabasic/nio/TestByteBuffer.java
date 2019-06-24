package xin.jerome.study.javabasic.nio;

import org.junit.Test;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * 操作字节缓冲区
 *
 * @author Jerome Zhu
 * @since 2018.12.18 10:30
 */
public class TestByteBuffer {

    /**
     * 测试ByteBuffer的创建和获取capacity
     */
    @Test
    public void testCapacity() {
        byte[] bytes = new byte[]{1, 2, 3, 4};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        System.out.println(String.format("Buffer [capacity：%d]", byteBuffer.capacity()));
    }

    /**
     * 测试ByteBuffer的获取limit和设置limit
     */
    @Test
    public void testLimit() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6, 7};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        System.out.println(String.format("Buffer [capacity：%d, limit：%d]", byteBuffer.capacity(),
                byteBuffer.limit()));
        byteBuffer.limit(4);
        System.out.println(String.format("Buffer [capacity：%d, limit：%d]", byteBuffer.capacity(),
                byteBuffer.limit()));
    }

    /**
     * 测试ByteBuffer的获取position和设置position,并获取剩余可操作大小
     */
    @Test
    public void testPosition() {
        byte[] bytes = new byte[]{1, 2, 3, 4};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.position(3);
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        System.out.println(String.format("Remaining: %d", byteBuffer.remaining()));
    }

    /**
     * 测试ByteBuffer的mark以及位置的重置
     */
    @Test
    public void testMark() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6, 7};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.position(2);
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.mark(); // 在位置 2 设置mark
        byteBuffer.position(5); // 重置位置 为 5
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.reset(); // 位置重置
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
    }

    /**
     * 测试将缓冲区的状态还原到初始状态
     */
    @Test
    public void testClear() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6, 7};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.limit(5);
        byteBuffer.position(3);
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        // 还原缓冲区到初始状态
        byteBuffer.clear();
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
    }

    /**
     * 测试将缓冲区的翻转，读数据的最佳时机
     */
    @Test
    public void testFlip() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6, 7};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.position(5);
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.flip();
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
    }

    /**
     * 测试将缓冲区的倒带，丢弃标记并重置position为0
     */
    @Test
    public void testRewind() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6, 7};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.position(3);
        byteBuffer.limit(5);
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.rewind();
        System.out.println(String.format("Buffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
    }

    /**
     * 测试其它的操作
     */
    @Test
    public void testOthers() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6, 7};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        // 判断是否为只读缓冲区
        System.out.println("byteBuffer.isReadOnly : " + byteBuffer.isReadOnly());
        // 判断是否为直接缓冲区
        System.out.println("byteBuffer.isDirect : " + byteBuffer.isDirect());
        // 判断是否有可访问实现数组
        System.out.println("byteBuffer.hasArray : " + byteBuffer.hasArray());
        // 判断当前位置到limit是否还有剩余
        System.out.println("byteBuffer.hasRemaining : " + byteBuffer.hasRemaining());
    }

    /**
     * 测试分配空间
     */
    @Test
    public void testAllocate() {
        // 创建堆缓冲区
        ByteBuffer heapByteBuffer = ByteBuffer.allocate(666);
        System.out.print(String.format("heapByteBuffer [capacity：%d, limit：%d, position: %d]",
                heapByteBuffer.capacity(), heapByteBuffer.limit(), heapByteBuffer.position()));
        System.out.println(" heapByteBuffer.isDirect : " + heapByteBuffer.isDirect());
        // 创建直接缓冲区
        ByteBuffer directByteBuffer = ByteBuffer.allocateDirect(555);
        System.out.print(String.format("directByteBuffer [capacity：%d, limit：%d, position: %d]",
                directByteBuffer.capacity(), directByteBuffer.limit(), directByteBuffer.position()));
        System.out.println(" directByteBuffer.isDirect : " + directByteBuffer.isDirect());
    }

    /**
     * 测试包装数据处理
     */
    @Test
    public void testWrap() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(bytes);
        System.out.println(String.format("byteBuffer1 [capacity：%d, limit：%d, position: %d]",
                byteBuffer1.capacity(), byteBuffer1.limit(), byteBuffer1.position()));
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(bytes, 2, 4);
        System.out.println(String.format("byteBuffer2 [capacity：%d, limit：%d, position: %d]",
                byteBuffer2.capacity(), byteBuffer2.limit(), byteBuffer2.position()));
    }

    /**
     * 测试相对位置的读写，位置position自增
     */
    @Test
    public void testRelativeReadAndWrite() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        // put
        System.out.println(String.format("byteBuffer before put [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.put((byte) 2);
        System.out.println(String.format("byteBuffer after put [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        // 切换到读的最适合状态
        byteBuffer.flip();
        // get
        System.out.println(String.format("byteBuffer before get [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        System.out.println(byteBuffer.get());
        System.out.println(String.format("byteBuffer after get [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
    }

    /**
     * 测试绝对位置的读写，位置position不变
     */
    @Test
    public void testAbsoluteReadAndWrite() {
        byte[] bytes = new byte[]{1, 2, 3, 4};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        // put
        System.out.println(String.format("byteBuffer before put [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.put(2,(byte) 33);
        System.out.println(String.format("byteBuffer after put [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        // get
        System.out.println(String.format("byteBuffer before get [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        System.out.println(byteBuffer.get(2));
        System.out.println(String.format("byteBuffer after get [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
    }

    /**
     * 测试批量读写
     */
    @Test
    public void testBatchReadAndWrite() {
        byte[] src = new byte[]{1, 2, 3, 4, 5, 6};
        byte[] dst = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        // put
        System.out.println(String.format("byteBuffer before put [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.put(src, 1, 5);
        System.out.println(String.format("byteBuffer after put [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.flip();
        // get
        System.out.println(String.format("byteBuffer before get [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.get(dst, 0, dst.length);
        for (int i = 0; i < dst.length; i++) {
            System.out.print(dst[i] + " ");
        }
        System.out.println(String.format("\nbyteBuffer after get [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
    }

    /**
     * 测试slice
     */
    @Test
    public void testSlice() {
        byte[] src = new byte[]{1, 2, 3, 4, 5, 6, 7, 8};
        ByteBuffer byteBuffer = ByteBuffer.wrap(src);
        byteBuffer.position(3);
        System.out.println(String.format("byteBuffer [capacity：%d, limit：%d, position: %d, remaining: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position(), byteBuffer.remaining()));
        ByteBuffer sliceBuffer = byteBuffer.slice();
        System.out.println(String.format("sliceBuffer [capacity：%d, limit：%d, position: %d, remaining: %d]",
                sliceBuffer.capacity(), sliceBuffer.limit(), sliceBuffer.position(), sliceBuffer.remaining()));
        System.out.println(String.format("sliceBuffer.arrayOffset() = %d", sliceBuffer.arrayOffset()));
    }

    /**
     * 测试创建只读缓存区
     */
    @Test
    public void testCreateReadOnlyBuffer() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println("byteBuffer.isReadOnly() = " + byteBuffer.isReadOnly());
        System.out.println("readOnlyBuffer.isReadOnly() = " + readOnlyBuffer.isReadOnly());
    }

    /**
     * 测试缓存区的压缩方法
     */
    @Test
    public void testCompact() {
        byte[] bytes = new byte[]{1, 2, 3, 4, 5, 6, 7};
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        System.out.println(String.format("byteBuffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        // 执行两次get() 操作
        byteBuffer.get();
        byteBuffer.get();
        System.out.println(String.format("byteBuffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byteBuffer.compact();
        System.out.println(String.format("byteBuffer [capacity：%d, limit：%d, position: %d]",
                byteBuffer.capacity(), byteBuffer.limit(), byteBuffer.position()));
        byte[] array = byteBuffer.array();
        for (int i = 0; i < byteBuffer.position(); i++) {
            System.out.print(array[i]);
        }
    }


    /**
     * 演示  position<=limit<=capacity
     * capacity : 容量，声明的缓冲区的容量，一旦声明不能改变
     * limit : 界限，缓冲区中可以操作的范围
     * position : 位置，表示缓冲区中正在操作的位置
     */
    @Test
    public void testByteBuffer() {
        // 初始化缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
        printBuffer(byteBuffer);

        // put  向缓冲区中写数据
        byteBuffer.putChar('q');
        printBuffer(byteBuffer);

        byteBuffer.put("sdfa".getBytes());
        printBuffer(byteBuffer);

        // flip  切换到读的模式
        byteBuffer.flip();
        printBuffer(byteBuffer);

        // get 读取数据
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        printBuffer(byteBuffer);
        System.out.println(new String(bytes, 0, bytes.length));

        //  rewind 倒带  filp后的状态
        byteBuffer.rewind();
        printBuffer(byteBuffer);

        // clear 清空缓冲区 只是将position=0，其实数据还是在的
        byteBuffer.clear();
        printBuffer(byteBuffer);
    }

    /**
     * mark : 标记，用于记录当前position 的位置。可以通过reset(),恢复到mark的位置。
     */
    @Test
    public void testMark1() {
        String str = "shgasdgf";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes());
        printBuffer(byteBuffer);

        byteBuffer.flip();

        byte[] bytes = new byte[10];
        byteBuffer.get(bytes, 0, 2);
        System.out.println(new String(bytes, 0, 2));
        printBuffer(byteBuffer);

        byteBuffer.mark();
        byteBuffer.get(bytes, 2, 2);
        System.out.println(new String(bytes, 2, 2));
        printBuffer(byteBuffer);

        byteBuffer.reset();
        printBuffer(byteBuffer);

        // 判断缓冲区中是否还有可操作的数据
        if (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.remaining());
        }

    }

    @Test
    public void directByte() {
        ByteBuffer direct = ByteBuffer.allocateDirect(1024);
        System.out.println(direct.isDirect());
    }


    private void printBuffer(ByteBuffer byteBuffer) {
        System.out.println(String.format("Buffer [position：%d,limit：%d,capacity：%d]",
                byteBuffer.position(), byteBuffer.limit(), byteBuffer.capacity()));
    }
}
